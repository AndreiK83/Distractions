<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		<h3>
			<a href="addUser">Add new User</a>
		</h3>
		<table border="1" cellpadding="5">

			<tr>
				<th>No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>
			<u:forEach items="${listOfUsers}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.email}</td>
					<td>${user.gender}</td>
					<td><a href="editUser?id=${user.id}">Edit</a> <a
						href="deleteUser?id=${user.id}">Delete</a></td>
				</tr>
			</u:forEach>
		</table>
	</div>

</body>
</html>