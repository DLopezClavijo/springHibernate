<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<html>
<head>
<title>Principal</title>

<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<script type="text/javascript"
	src='<c:url value="/resources/js/bootstrap.min.js" />'></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Add / Edit Person</h3>
					</div>
					<div class="panel-body">
						<c:url value="/add" var="addeditaction"></c:url>
						<f:form action="${addeditaction}" commandName="person"
							class="form" role="form">
							<div class="form-group">
								<c:if test="${!empty person.name }">
									<f:label path="id">
										<s:message code="" text="ID"></s:message>
									</f:label>
									<f:input path="id" class="form-control" readonly="true"
										disabled="true" />
									<f:hidden path="id" />
								</c:if>
							</div>
							<div class="form-group">
								<f:label path="name">
									<s:message code="" text="NAME"></s:message>
								</f:label>
								<f:input path="name" class="form-control" />
							</div>
							<div class="form-group">
								<f:label path="country">
									<s:message code="" text="COUNTRY"></s:message>
								</f:label>
								<f:input path="country" class="form-control" />
							</div>
							<c:choose>
								<c:when test="${!empty person.name}">
									<input type="submit"
										value="<s:message code="" text="Edit Person" />"
										class="btn btn-primary">
								</c:when>
								<c:otherwise>
									<input type="submit"
										value="<s:message code="" text="Add Person" />"
										class="btn btn-primary">
								</c:otherwise>
							</c:choose>
						</f:form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<c:if test="${!empty listPersons }">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>COUNTRY</th>
								<th>EDIT</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listPersons }" var="p">
								<tr>
									<td>${p.id }</td>
									<td>${p.name }</td>
									<td>${p.country }</td>
									<td><a class="btn btn-info btn-xs"
										href='<c:url value="/edit/${p.id}"></c:url>'>Edit</a></td>
									<td><a class="btn btn-danger btn-xs"
										href="<c:url value="/delete/${p.id}"></c:url>">Del</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
