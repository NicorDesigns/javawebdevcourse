<%@ page session="false" import="com.nicordesigns.Attachment, com.nicordesigns.Registration" %>
<%
    String registrationId = (String)request.getAttribute("registrationId");
    Registration registration = (Registration)request.getAttribute("registration");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Associate Support</title>
    </head>
    <body>
        <!-- Fix the fact that these values are null -->
        <h2>Registration #<%= registrationId %>: <%= registration.getUserName() %></h2>
        <i>User Name - <%= registration.getUserName() %></i><br /><br />
        <%= registration.getBody() %><br /><br />
        <%
            if(registration.getNumberOfAttachments() > 0)
            {
                %>Attachments: <%
                int i = 0;
                for(Attachment a : registration.getAttachments())
                {
                    if(i++ > 0)
                        out.print(", ");
                    %><a href="<c:url value="/registrations">
                        <c:param name="action" value="download" />
                        <c:param name="registrationId" value="<%= registrationId %>" />
                        <c:param name="attachment" value="<%= a.getName() %>" />
                    </c:url>"><%= a.getName() %></a><%
                }
                %><br /><br /><%
            }
        %>
        <a href="<c:url value="/registrations" />">Return to list Registrations</a>
    </body>
</html>
