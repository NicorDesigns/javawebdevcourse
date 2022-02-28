<%@ page session="false" import="com.nicordesigns.Attachment, com.nicordesigns.Registration" %>
<%
    String registrationId = (String)request.getAttribute("RegistrationId");
    Registration registration = (Registration)request.getAttribute("Registration");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer Support</title>
    </head>
    <body>
        <h2>Registration #<%= registrationId %>: <%= registration.getSubject() %></h2>
        <i>Customer Name - <%= registration.getCustomerName() %></i><br /><br />
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
                    %><a href="<c:url value="/Registrations">
                        <c:param name="action" value="download" />
                        <c:param name="RegistrationId" value="<%= registrationId %>" />
                        <c:param name="attachment" value="<%= a.getName() %>" />
                    </c:url>"><%= a.getName() %></a><%
                }
                %><br /><br /><%
            }
        %>
        <a href="<c:url value="/Registrations" />">Return to list Registrations</a>
    </body>
</html>
