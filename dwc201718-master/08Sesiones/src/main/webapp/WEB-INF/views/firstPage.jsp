<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Session</title>
</head>
<body>
	<form:form method="post" action="showWelcome">
		<table>
			<tr>
				<td>Full Name</td>
				<td><input type="text" name="fullName" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Go To Welcome Page" /></td>
			</tr>
		</table>

	</form:form>

	<form:form method="post" action="showFinal">

		<table>
			<tr>
				<td>Employee Full Name</td>
				<td><input type="text" name="fullName" /></td>
			</tr>

			<tr>
				<td>Department Name</td>
				<td><input type="text" name="department" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Go To Welcome Page" /></td>
			</tr>
		</table>

	</form:form>
	<c:url value="/close" var="closeaction"></c:url>
	<button onclick="location.href='${closeaction}'">Cerrar Sesión</button>
</body>
</html>