<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
	<center>
		<a href="${pageContext.request.contextPath}/">Home</a> <a
			href="${pageContext.request.contextPath}/register">Register</a>
	</center>
	<br>
	
	<div style="margin-bottom: 10px">
		<%@ include file="./particular.jsp"%>
	</div>
	<table class="w3-table-all">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Address</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>

				<td>${user.id}</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.email}</td>
				<td>${user.address}</td>
				<td><a href="<c:url value='/edit/${user.id}' />">Edit</a></td>
				<td><a href="<c:url value='/remove/${user.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>