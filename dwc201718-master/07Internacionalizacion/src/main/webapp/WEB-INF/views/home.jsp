<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<ul>
		<li><a href="?locale=en"> <s:message code="english"></s:message> </a></li>
		<li><a href="?locale=es"> <s:message code="spanish"></s:message> </a></li>
	</ul>

	<h2> <s:message code="title"></s:message> </h2>
	<f:form method="GET" modelAttribute="student">
		<f:label path="name"> <s:message code="form.name"></s:message> </f:label>
		<f:input path="name" />
		<br />
		<f:label path="surname"> <s:message code="form.surname"></s:message> </f:label>
		<f:input path="surname" />
		<br />
		<f:label path="age"> <s:message code="form.age"></s:message> </f:label>
		<f:input path="age" />
		<br />
		<input type="submit" value=" <s:message code="form.send"></s:message> ">
	</f:form>
</body>
</html>
