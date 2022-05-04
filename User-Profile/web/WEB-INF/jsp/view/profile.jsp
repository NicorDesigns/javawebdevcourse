<%--@elvariable id="user" type="com.nicordesigns.User"--%>
<!-- Above comment is used to help out IDE's -->
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title>User Profile</title>
</head>
<body>
    <!-- EL access the bean properties and length -->
	User ID: ${user.userId}
	<br /> User Name: ${user.username} (${user.username.length()}
	characters)
	<!-- Using fn: functions, escape any special characters in the name -->
	<br /> Full Name: ${fn:escapeXml(user.lastName) += ', '
            += fn:escapeXml(user.firstName)}
	<br />
	<br />
	<!-- Using the attributes to get the permission values from the Map Object and their number (length) -->
	<b>Permissions (${fn:length(user.permissions)})</b>
	<br /> User: ${user.permissions["user"]}
	<br /> Moderator: ${user.permissions["moderator"]}
	<br /> Administrator: ${user.permissions["admin"]}
	<br />
</body>
</html>
