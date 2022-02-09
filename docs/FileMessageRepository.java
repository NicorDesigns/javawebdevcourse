package com.thd.monarch.messaging.service;

import static org.slf4j.LoggerFactory.getLogger;

import com.thd.monarch.services.MessagingService.MessageStatus;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;

public interface FileMessageRepository {

  final class LogHolder {

    private static final Logger log = getLogger(FileMessageRepository.class);
  }

  /**
   * The type of file, either Regular or Temporary
   */
  enum FileType {
    REGULAR(".ser"),
    TEMPORARY(".tmp");

    private final String extension;

    FileType(String extension) {
      this.extension = extension;
    }

    public String getExtension() {
      return extension;
    }
  }

  /**
   * @return the 'home' path of the repository, which contains directories containing the messages.
   */
  Path getHomePath();

  /**
   * Returns the path of the directory that stores messages of the given status.
   *
   * @param status the status of the message(s)
   * @return the directory Path
   */
  default Path getStatusPath(MessageStatus status) {
    return getHomePath().resolve(mapStatusToPathname(status));
  }

  /**
   * Maps the given MessageStatus to the name of the directory that contains messages of that
   * status.
   *
   * @param status the status of the message(s)
   * @return the name of the directory that contains messages of that status.
   */
  default String mapStatusToPathname(MessageStatus status) {
    switch (status) {
      case CREATED:
        return "created";
      case RETRY:
        return "retry";
      case PARTIAL:
      case SENT:
        return "sent";
      case FAILED:
      default:
        return "failed";
    }
  }

  /**
   * Return the Path for a message file that has the given ID, in the given status, and of the given
   * file type.
   *
   * @param uuid     the ID of the message
   * @param status   the status of the message
   * @param fileType the file type of the message file
   * @return the Path for the message file
   */
  default Path buildMessageFilePath(UUID uuid, MessageStatus status, FileType fileType) {
    var filename = uuid.toString() + fileType.getExtension();
    return getHomePath().resolve(mapStatusToPathname(status)).resolve(filename);
  }

  /**
   * Given the Path to a regular message file, return the equivalent path for its temporary file.
   *
   * @param regularFilePath the path to regular message file
   * @return the equivalent path for its temporary file.
   */
  default Path convertToTempFilePath(Path regularFilePath) {
    return Path.of(regularFilePath.toString()
        .replace(FileType.REGULAR.getExtension(), FileType.TEMPORARY.getExtension()));
  }

  /**
   * Given the Path to a temporary file, return the equivalent path for its temporary file.
   *
   * @param tempFilePath the path to the temporary file
   * @return the equivalent path for its regular file.
   */
  default Path convertToRegularFilePath(Path tempFilePath) {
    return Path.of(tempFilePath.toString()
        .replace(FileType.TEMPORARY.getExtension(), FileType.REGULAR.getExtension()));
  }

  /**
   * Returns a list of file Paths for all files in the given status, sorted ascending by last
   * modified timestamp. Only message files are returned (those that have a UUID name).
   *
   * @param messageStatuses the status of the message(s)
   * @return a list of file Paths for all files in the given status.
   */
  default List<Path> findFilesByStatus(FileType fileType, MessageStatus... messageStatuses) {

    var pathList = new ArrayList<Path>();

    for (var messageStatus : messageStatuses) {
      var dir = getStatusPath(messageStatus);
      if (!Files.exists(dir)) {
        continue;
      }

      try (var walk = Files.walk(dir, 1)) {
        pathList.addAll(walk.filter(Files::isRegularFile)
            .filter(p -> p.toString().endsWith(fileType.getExtension()))
            .filter(p -> this.isMessageFile(p, fileType))
            .sorted(this::compareLastModifiedTime)
            .collect(Collectors.toList()));
      } catch (IOException ioe) {
        LogHolder.log
            .error("[findFilesByStatus] Error while loading file paths for [{}] {}: {}", fileType,
                messageStatuses, ioe);
      }
    }

    return pathList;
  }

  /**
   * Returns the path to the first message file that is found among all regular message files in the
   * home directory hierarchy.
   *
   * @param id       the UUID of the message to find
   * @param fileType the type of message file to find
   * @return the Path to the message file that was found
   */
  default Optional<Path> findFileById(UUID id, FileType fileType) {

    // If the directory doesn't exist, nothing to do
    var dir = getHomePath();
    if (!Files.exists(dir)) {
      return Optional.empty();
    }

    // Find messages in entire home directory tree that matches the UUID
    Optional<Path> messagePath;
    try (var walk = Files.walk(dir, 2)) {
      messagePath = walk
          .filter(Files::isRegularFile)
          .filter(p -> this.isMessageFile(p, fileType))
          .filter(p -> this.getFilenameWithoutExtension(p, fileType).equals(id.toString()))
          .findFirst();
    } catch (IOException ex) {
      LogHolder.log.error("[findFileById] Unable to find [{}] file for [{}].", fileType, id, ex);
      return Optional.empty();
    }
    return messagePath;
  }

  /**
   * Return whether or not the given Path points to a message file
   */
  default boolean isMessageFile(Path filePath, FileType fileType) {
    try {
      UUID.fromString(getFilenameWithoutExtension(filePath, fileType));
      return true;
    } catch (IllegalArgumentException ex) {
      LogHolder.log.error("[isMessageFile] Unable to parse UUID from [{}].", filePath, ex);
      return false;
    }
  }

  default String getFilenameWithoutExtension(Path filePath, FileType fileType) {
    return filePath.getFileName().toString().replace(fileType.getExtension(), "");
  }

  /**
   * A Comparator that compares the last modified time of the given Paths.
   *
   * @see java.util.Comparator
   */
  default int compareLastModifiedTime(Path path1, Path path2) {
    try {
      var attr1 = Files.readAttributes(path1, BasicFileAttributes.class);
      var attr2 = Files.readAttributes(path2, BasicFileAttributes.class);
      return attr1.lastModifiedTime().compareTo(attr2.lastModifiedTime());
    } catch (IOException ex) {
      LogHolder.log.error(
          "[compareLastModifiedTime] Failed to compare last modified times for [{}] and [{}].",
          path1, path2, ex);
      return 0;
    }
  }

  /**
   * Delete the files at the given paths that have a last modified time older than the given time
   * window.
   *
   * @param paths      The files to potentially delete
   * @param timeWindow Files with a last modified time older this time window
   * @throws IOException if an exception is thrown attempting to delete a file
   */
  default void deleteOldFiles(List<Path> paths, TimeWindow timeWindow) throws IOException {
    var cutoffTime = ZonedDateTime.now().minus(timeWindow.getAmount(), timeWindow.getChronoUnit())
        .toInstant();
    for (var path : paths) {
      var attr = Files.readAttributes(path, BasicFileAttributes.class);
      var lastModifiedTime = attr.lastModifiedTime().toInstant();
      if (cutoffTime.isAfter(lastModifiedTime)) {
        Files.delete(path);
      }
    }
  }

  /**
   * Safely writes the given bytes to the specified path by first writing the bytes, then reading
   * back and comparing the bytes.
   *
   * @throws IOException if the written bytes are not equal to the re-read bytes.
   */
  default void writeVerifiedBytes(Path path, byte[] bytes) throws IOException {
    Files.write(path, bytes);
    var readBytes = Files.readAllBytes(path);
    if (!Arrays.equals(bytes, readBytes)) {
      throw new IOException(
          String.format("[writeBytes] Unsuccessful write of message to [%s].", path));
    }
  }
}
