<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<html>
<head>
<title>Formulario</title>
</head>
<body>
	<h2>Formulario de Empleado</h2>
	<f:form method="POST" action="/formulario/mostrar" commandName="miEmp">
		<f:label path="idEmpleado">ID:</f:label>
		<f:input path="idEmpleado" />
		<br />
		<f:label path="nombre">NOMBRE:</f:label>
		<f:input path="nombre" />
		<br />
		<f:label path="salario">SALARIO:</f:label>
		<f:input path="salario" />
		<br />
		<f:label path="edad">EDAD:</f:label>
		<f:input path="edad" />
		<br />
		<input type="submit" value="Enviar">
	</f:form>
</body>
</html>
