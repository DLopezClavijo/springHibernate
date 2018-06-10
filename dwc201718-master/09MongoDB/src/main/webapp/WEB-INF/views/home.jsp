<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<f:form action="guardar" method="post" modelAttribute="persona">
		<f:hidden path="id"/>
		<f:label path="nombre">Nombre: </f:label>
		<f:input path="nombre" />
		<input type="submit" value="Enviar">
	</f:form>

	<table>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th></th>
		</tr>
		<c:forEach var="p" items="${listado}">
			<tr>
				<td>${p.id }</td>
				<td>${p.nombre }</td>
				<td> 
				<input type="button" value="Borrar" onclick="location.href='borrar?id=${p.id}'">
				<input type="button" value="Actualizar" onclick="location.href='actualizar?id=${p.id}'"> 
				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
