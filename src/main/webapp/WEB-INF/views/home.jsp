<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Crud Example</title>
</head>
<body>
	<center>
		<h4>Here you can Register / Login</h4>
	</center>
	<table align="center">
		<tr>
			<td><a href="login">Login</a></td>
		</tr>
		<tr>
			<td><a href="register">Register</a></td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/list">List of Students</a></td>
		</tr>
	</table>
</body>
</html>