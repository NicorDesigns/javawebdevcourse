# 3. Choosing a Logging Framework

In most development shops your Logging Framework has probably already been chosen for you but when doing new development from scratch you will have the choice.

In these days of everything in the cloud you will want to start of with a  Logging API that are not tightly coupled to the implementation of the Logging Framework you choose.

Here it is important to start with the standard:
java.util.logging framework
and the [LogManager](https://docs.oracle.com/en/java/javase/11/docs/api/java.logging/java/util/logging/LogManager.html) class - we will look into the documentation

We get our Logger instances back from this class and we can specify a system property to provide an alternative implementation of the standard logging API which is quite normal in modern web development to do.

### Performance

Every log message is a couple of milliseconds spent that can quickly build up in a web app with millions of log events per day.
You only want logging when you really need it and when you do need it such as for debugging you want it to be less than milliseconds


### Apache Commons Logging
[Apache Commons Logging - Overview](https://commons.apache.org/proper/commons-logging/)

[Apache Commons Logging - Guide](https://commons.apache.org/proper/commons-logging/guide.html)

### SLF4J

[SLF4J](https://www.slf4j.org/)

are both Facades that serves as a simple facade or abstraction for various logging frameworks.

We often use these two classes for named class specific logs:

[https://commons.apache.org/proper/commons-logging/apidocs/org/apache/commons/logging/LogFactory.html](https://commons.apache.org/proper/commons-logging/apidocs/org/apache/commons/logging/LogFactory.html)

[https://www.slf4j.org/api/org/slf4j/LoggerFactory.html](https://www.slf4j.org/api/org/slf4j/LoggerFactory.html\)

since they are facades they provide adapters for various Logging Implementations 


### Log4J2 API

[https://logging.apache.org/log4j/2.x/](https://logging.apache.org/log4j/2.x/)

a popular implementation framework and the bug that the whole world had to fix in production
Is what we will use in our examples because it is so popular! 

The Maven dependencies we will use 
- log4j-api
- log4j-core
- log4j-jcl
- log4j-slf4j-impl
- log4j-taglib

*Log4J2 Configuration*

[https://logging.apache.org/log4j/2.x/manual/configuration.html](https://logging.apache.org/log4j/2.x/manual/configuration.html)

Automatic Configuration

[https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/Level.html](https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/Level.html)

LogManager
[https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/LogManager.html](https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/LogManager.html)

Levels
[https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/Level.html](https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/Level.html)

Loggers

[Logger (Apache Log4j API 2.19.0 API)](https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/Logger.html)

Appenders

[https://logging.apache.org/log4j/2.x/manual/appenders.html](https://logging.apache.org/log4j/2.x/manual/appenders.html)

Layouts

[https://logging.apache.org/log4j/2.x/manual/layouts.html](https://logging.apache.org/log4j/2.x/manual/layouts.html)

