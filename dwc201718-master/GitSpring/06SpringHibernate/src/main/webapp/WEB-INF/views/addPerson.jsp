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
						<h3 class="panel-title">Add Person</h3>
					</div>
					<div class="panel-body">
						<c:url value="/addNew" var="addeditaction"></c:url>
						<f:form action="${addeditaction}" commandName="person" method="post"
							class="form" role="form" enctype="multipart/form-data">
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
							<div class="form-group">
								<f:label path="imagen">IMAGE</f:label>
								<input type="file" name="file" id="file"/>
							</div>
							<input type="submit"
								value="<s:message code="" text="Add Person" />"
								class="btn btn-primary">
						</f:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
