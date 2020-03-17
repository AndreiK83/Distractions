<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit User</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<form:form action="saveUser" method="post" modelAttribute="user">
			<table cellpadding="5">
				<form:hidden path="id" />
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastname" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><select id="gender" name="gender">
							<option value="M">M</option>
							<option value="F">F</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" /></td>

				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>