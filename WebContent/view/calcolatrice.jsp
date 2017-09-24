<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<body>
	<c:set var="result" value='${requestScope["result"]}' />
	<center>
		<form method="post" action="calculateServlet">
			<table>
				<tr>
					<td><input type="text" name="operand1"></td>
					<td><select name="operation">
							<option value="multiply">moltiplica</option>
							<option value="divide">dividi</option>
							<option value="sum">somma</option>
							<option value="subtract">sottrai</option>
					</select></td>
					<td><input type="text" name="operand2"></td>
					<td><input type="submit" name="calculate"></td>
				</tr>
			</table>
			<p>
				result
				<c:out value="${result}" />
			</p>
		</form>
	</center>
</body>
</html>