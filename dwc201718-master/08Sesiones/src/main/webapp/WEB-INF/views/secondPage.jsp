<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Session</title>
</head>
<body>
	<form:form method="post" action="showFinalObject" modelAttribute="emplo">

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
</body>
</html>