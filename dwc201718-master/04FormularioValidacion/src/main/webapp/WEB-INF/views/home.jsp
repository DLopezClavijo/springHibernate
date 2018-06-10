<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Alumno 
</h1>
<c:if test="${not empty mensaje }"><h2>${mensaje}</h2></c:if>
<f:form method="POST" action="/formulariovalidacion/mostrar" modelAttribute="alumno">
	<f:label path="nombre">NOMBRE:</f:label>
	<f:input path="nombre"/>
	<f:errors path="nombre"></f:errors>
	<br />
	<f:label path="email">EMAIL:</f:label>
	<f:input path="email"/>
	<f:errors path="email"></f:errors>
	<br />
	<f:label path="edad">EDAD:</f:label>
	<f:input path="edad"/>
	<f:errors path="edad"></f:errors>
	<br />
	<f:label path="cumple">CUMPLE:</f:label>
	<f:input path="cumple"/>
	<f:errors path="cumple"></f:errors>
	<br />
	<input type="submit" value="Enviar">
</f:form>
</body>
</html>
