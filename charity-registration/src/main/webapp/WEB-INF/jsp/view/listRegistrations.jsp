<%--@elvariable id="registrationDatabase" type="java.util.Map<Integer, com.nicordesigns.Registration>"--%>

 
<!-- %@ page import="java.util.Map, com.nicordesigns.Attachment, com.nicordesigns.Registration" %-->
<!-- %
    @SuppressWarnings("unchecked")
    Map<Integer, Registration> registrationDatabase =
            (Map<Integer, Registration>)request.getAttribute("registrationDatabase");
%-->
 
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Associate Support</title>
    </head>
    <body>
        <a href="<c:url value="/login?logout" />">Logout</a>
        <h2>Registrations</h2>
        <a href="<c:url value="/registrations">
            <c:param name="action" value="create" />
        </c:url>">Create Registration</a><br /><br />
        <c:choose>
            <c:when test="${fn:length(registrationDatabase) == 0}">
                <i>There are no registrations in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${registrationDatabase}" var="entry">
                    Registration ${entry.key}: <a href="<c:url value="/registrations">
                        <c:param name="action" value="view" />
                        <c:param name="registrationId" value="${entry.key}" />
                    </c:url>">
                    <c:out value="${entry.value.subject}" /></a>
                    (User Name: <c:out value="${entry.value.userName}" />)<br />
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <!-- %
            if(registrationDatabase.size() == 0)
            {
                %><i>There are no Registrations in the system.</i><!-- %
            }
            else
            {
                for(int id : registrationDatabase.keySet())
                {
                    String idString = Integer.toString(id);
                    Registration registration = registrationDatabase.get(id);
                    %>--Registration #
                    <!-- %= idString %-->: 
                    <!-- a href="<c:url value="/registrations">
                        <c:param name="action" value="view" />
                        <c:param name="registrationId" value="<!-- %= idString %>" />
                    </c:url>" -->
                    <!--%= registration.getSubject() % ></a> 
                    (User Name: <!-- %= registration.getUserName() %>)<br /-->
                    <!-- %
                }
            }
        %-->
    </body>
</html>
