<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Session Closed</title>
</head>
<body>
	<h3>Welcome ${sessionScope.empObject.fullName} from Department
		${sessionScope.empObject.department} !!!!!</h3>
</body>
</html>