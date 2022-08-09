<!DOCTYPE html>
<html>
<head>
<title>Charity Associate Support</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />

</head>
<body>
	<div class="login">
		<h2>Login</h2>

		You must log in to access the charity registration site.<br /> <br />
		<!-- On login failed returned from the login Servlet -->
		<%
		if (((Boolean) request.getAttribute("loginFailed"))) {
		%>
		<b>The user name or password you entered are not correct. Please
			try again.</b><br /> <br />
		<%
		}
		%>
		<form method="POST" action="<c:url value="/login" />">
			User name<br /> <input type="text" name="username"
				required="required" /><br /> <br /> Password<br /> <input
				type="password" name="password" required="required" /><br /> <br />
			<input type="submit" value="Log In"
				class="btn btn-primary btn-block btn-large" />
		</form>
	</div>

</body>
</html>

