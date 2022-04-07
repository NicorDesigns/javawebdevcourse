<!DOCTYPE html>
<html>
    <head>
        <title>Charity Associate Support</title>
    </head>
    <body>
        <h2>Login</h2>
        You must log in to access the charity registration site.<br /><br />
        <!-- On login failed returned from the login Servlet -->
        <%
            
            if(((Boolean)request.getAttribute("loginFailed")))
            {
                %>
        <b>The user name or password you entered are not correct. Please try
            again.</b><br /><br />
                <%
            }
        %>
        <form method="POST" action="<c:url value="/login" />">
            User name<br />
            <input type="text" name="username" /><br /><br />
            Password<br />
            <input type="password" name="password" /><br /><br />
            <input type="submit" value="Log In" />
        </form>
    </body>
</html>