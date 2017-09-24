<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body>
	<form method="post" action="NewUserController">
	<table border=1>
		<thead>
			<tr>
				<th>User Name</th>
				<th>Email</th>
				<th>Registration Date</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.uname}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><fmt:formatDate pattern="dd MMM,yyyy"
							value="${user.registeredon}" /></td>
					<td>
						<!--  <a href="UserController?action=edit&userId=<c:out value="${user.uname}"/>">Update</a> -->
						<button type="submit" name="action" value="update_<c:out value="${user.uname}"/>">Update</button>
					</td>
					<td>
						<!-- <a href="UserController?action=delete&userId=<c:out value="${user.uname}"/>">Delete</a> -->
						<button type="submit" name="action" value="delete_<c:out value="${user.uname}"/>">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<!-- <a href="UserController?action=insert">Add User</a> -->
		<button type="submit" name="action" value="insert">Insert</button>
	</p>
	</form>
</body>
</html>