<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<f:form method="GET" action="/redireccion/redireccionar">
		<input type="submit" value="Enviar">
	</f:form>
</body>
</html>
