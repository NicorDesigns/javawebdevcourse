<%--@elvariable id="registrationId" type="java.lang.String"--%>
<%--@elvariable id="registration" type="com.nicordesigns.Registration"--%>
<!-- Above updates is for IDE assist -->
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Associate Support</title>
    </head>
    <body>
        <a href="<c:url value="/login?logout" />">Logout</a>
        
        <!-- New JSTL Code -->
        <h2>Registration #${registrationId}:<c:out value="${registration.subject}" /></h2>
        
        <!-- New JSTL Code -->
        <i><c:out value="${registration.userName}"/></i><br /><br />
        <c:out value="${registration.body}"/><br /><br />
       <c:if test="${registration.numberOfAttachments > 0}">
            Attachments:
            <c:forEach items="${registration.attachments}" var="attachment" varStatus="status">
                <c:if test="${!status.first}">, </c:if>
                <a href="<c:url value="/registrations">
                    <c:param name="action" value="download" />
                    <c:param name="registrationId" value="${registrationId}" />
                    <c:param name="attachment" value="${attachment.name}" />
                </c:url>"><c:out value="${attachment.name}" /></a>
            </c:forEach><br /><br />
        </c:if>
        
        <a href="<c:url value="/registrations" />">Return to list Registrations</a>
    </body>
</html>
