<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add new user</title>
</head>
<body>
	<form method="POST" action='UserController' name="frmAddUser">
		<%
			String action = request.getParameter("action");
			System.out.println(action);
		%>
		<%
			if (action.contains("update")) {
		%>
		User Name : <input type="text" name="uname"
			value="<c:out value="${user.uname}" />" readonly="readonly" /> (You
		Can't Change this)<br />
		<%
			} else {
		%>
		User Name : <input type="text" name="uname"
			value="<c:out value="${user.uname}" />" /> <br />
		<%
			}
		%>
		Password : <input type="password" name="pass"
			value="<c:out value="${user.password}" />" /> <br /> Email : <input
			type="text" name="email" value="<c:out value="${user.email}" />" />
		<br />

		<%
			if (action.contains("update")) {
		%>
		Registration : <input type="text" name="dob"
			value="<fmt:formatDate pattern="yyyy/MM/dd" value="${user.registeredon}" />"
			readonly="readonly" />(You Can't Change this) <br />
		<%
			} else {
		%>
		Registration : <input type="text" name="dob"
			value="<fmt:formatDate pattern="yyyy/MM/dd" value="${user.registeredon}" />" />(yyyy/MM/dd)
		<br />
		<%
			}
		%>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>