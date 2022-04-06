<%@ page import="java.util.Map, com.nicordesigns.Attachment, com.nicordesigns.Registration" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Registration> registrationDatabase =
            (Map<Integer, Registration>)request.getAttribute("registrationDatabase");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Associate Support</title>
    </head>
    <body>
        <h2>Registrations</h2>
        <a href="<c:url value="/registrations">
            <c:param name="action" value="create" />
        </c:url>">Create Registration</a><br /><br />
        <%
            if(registrationDatabase.size() == 0)
            {
                %><i>There are no Registrations in the system.</i><%
            }
            else
            {
                for(int id : registrationDatabase.keySet())
                {
                    String idString = Integer.toString(id);
                    Registration registration = registrationDatabase.get(id);
                    %>Registration #<%= idString %>: <a href="<c:url value="/registrations">
                        <c:param name="action" value="view" />
                        <c:param name="registrationId" value="<%= idString %>" />
                    </c:url>"><%= registration.getSubject() %></a> (User Name:
        			<%= registration.getUserName() %>)<br /><%
                }
            }
        %>
    </body>
</html>
