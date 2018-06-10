<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Añadir Revision</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap2col.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>

<!-- Custom styles for this template -->
<link rel="stylesheet"
	href='<c:url value="/resources/css/2-col-portfolio.css"/>'>


<link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrapAdmin.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/resources/css/sb-admin.css"/>'>

</head>
<body >
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/return"/>"> <i class="fa fa-reply"
							aria-hidden="true"></i> Volver
					</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading -->
		<h1 class="my-4">Añadir Coche${usuario.getNombre()}
			${usuario.getApellido() }</h1>
		<c:if test="${mensaje != ''}">
			<div class="alert alert-warning alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<strong>Info!</strong> ${mensaje}
			</div>
		</c:if>
		<div class="row">
			<div class="col-lg-6 portfolio-item">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Formulario para añadir un coche</a>
						</h4>
						<c:url value="/addRevision" var="addRevision"></c:url>
						<f:form class="navbar-form navbar-right " method="POST"
							action="${addRevision }" id="addRevision" commandName="revisiones">
							<div class="form-group">
								<f:label path="fecha">Fecha:</f:label>
								<f:input type="date" placeholder="AAAA/MM/DD"
									class="form-control" path="fecha" name="fecha"
									id="fecha" required="required" />
							</div>
							<div class="form-group">
								<f:label path="kilometros">Kilometros:</f:label>
								<f:input type="number" placeholder="Kilometros" class="form-control"
									path="kilometros" name="kilometros" id="kilometros" required="required" />
							</div>
							<div class="form-group">
								<f:label path="observaciones">Observacion:</f:label>
								<f:input type="text" placeholder="Observacion" class="form-control"
									path="observaciones" name="observaciones" id="observaciones" required="required" />
							</div>
							<div class="form-group">
								<f:label path="precio">Observacion:</f:label>
								<f:input type="number" placeholder="Precio" class="form-control"
									path="precio" name="precio" id="precio" required="required" />
							</div>
							

							<button type="submit" class="btn btn-primary">
								<i class="fa fa-sign-in"></i>Guardar
							</button>
						</f:form>

					</div>
				</div>
			</div>
			
			<div class="col-lg-6 portfolio-item">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Elija una reparacion</a>
						</h4>
						
							<c:url value="/getReparacion" var="getReparacion"></c:url>
							<f:form class="navbar-form navbar-right " method="GET" action="${getReparacion }" id="getReparacion" commandName="reparaciones">
								<div class="form-group">
											<f:label path="idReparacion">Reparacion: </f:label>
												<f:select path="idReparacion" id="idReparacion" class="form-control form-control-lg">>
													<f:options items="${listRepair }" 
														itemValue="idReparacion"
														itemLabel="nombre"  />  					
									</f:select>
									
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-check-square-o" aria-hidden="true"></i>Confirmar Reparación
									</button>	
								</div>	
									
							</f:form>
						</div>

					</div>
				</div>
			
			</div>

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2018</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src='<c:url value="/resources/vendor/jquery/jquery2col.min.js" />'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/bootstrap/js/bootstrap2col.bundle.min.js" />'></script>





	<!-- Bootstrap core JavaScript-->
	<script src="resources/vendor/jquery/jqueryAdmin.min.js"></script>
	<script
		src="resources/vendor/bootstrap/js/bootstrapAdmin.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="resources/jquery-easing/jquery.easing.min.js"></script>
	<!-- Page level plugin JavaScript-->
	<script src="resources/chart.js/Chart.min.js"></script>
	<script src="resources/datatables/jquery.dataTables.js"></script>
	<script src="resources/datatables/dataTables.bootstrap4.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="resources/js/sb-admin.min.js"></script>
	<!-- Custom scripts for this page-->
	<script src="resources/js/sb-admin-datatables.min.js"></script>
	<script src="resources/js/sb-admin-charts.min.js"></script>


</body>

</html>
