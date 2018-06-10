<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Estudiante
</h1>
<f:form method="POST" action="/excepciones/anadir" commandName="estudiante">
	<f:label path="id">ID: </f:label>
	<f:input path="id"/>
	<br />
	<f:label path="nombre">NOMBRE: </f:label>
	<f:input path="nombre"/>
	<br />
	<f:label path="edad">EDAD: </f:label>
	<f:input path="edad"/>
	<br />
	<input type="submit" value="Enviar">
</f:form>
</body>
</html>
