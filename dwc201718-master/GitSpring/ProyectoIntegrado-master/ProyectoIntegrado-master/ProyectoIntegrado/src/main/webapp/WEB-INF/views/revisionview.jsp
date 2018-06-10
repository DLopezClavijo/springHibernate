<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Coche info revision</title>

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
		<h1 class="my-4">Ver Coche${usuario.getNombre()}
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
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Coche</a>
						</h4>
						<div>
							<p>Matricula: ${coche.getMatricula()}</p>
							<p>Marca: ${coche.getMarca()}</p>
							<p>Modelo: ${coche.getModelo()}</p>
							<p>Año: ${coche.getAnyo()}</p>
							<p>Motor: ${coche.getMotor()}</p>
							<p>Potencia: ${coche.getPotencia()}</p>
						</div>
					</div>
				</div>
			<div class="col-lg-6 portfolio-item">
				<div class="card-body">
					<div>
						<h4 class="card-title">
							<a href="#">Propietario</a>
						</h4>
						<div>
							<p>Propietario: ${coche.getUsuario().getNombre()} ${coche.getUsuario().getApellido()}</p>
							<p>Telefono: ${coche.getUsuario().getTelefono()} </p>
							<p>Correo: ${coche.getUsuario().getCorreo()} </p>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-lg-12 portfolio-item">
				<button type="button" class="btn btn-primary btn-block "
					onclick="location.href='<c:url value="/addRevisionView?idCoche=${coche.idCoche }"/>'">
					<i class="fa fa-cogs"></i>Añadir Revision
				</button>
			</div>
			
			<div class="col-lg-12 portfolio-item">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Lista de Revisiones</a>
						</h4>
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<td>Fecha</td>
										<td>Kilometros</td>
										<td>Reparacion</td>
										<td>Observaciones</td>
										<td>Precio</td>
										<td></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listRevisionsById }" var="lr">
										<tr>
											<td>${lr.fecha}</td>
											<td>${lr.kilometros }</td>
											<td>${lr.reparacion.nombre }</td>
											<td>${lr.observaciones }</td>
											<td>${lr.precio }</td>
											<td>
											
												<button type="button" class="btn btn-warning"
													onclick="location.href='<c:url value="/revisionsVista?idRevision=${lr.idRevision }"/>'">
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													Editar
												</button>
												<button type="button" class="btn btn-danger"
													data-toggle="modal"
													data-target="#borrarRevision${lr.idRevision}">
													<i class="fa fa-times" aria-hidden="true"
														data-toggle="modal"></i> Borrar
												</button>
												<div class="modal fade"
													id="borrarRevision${lr.idRevision}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">Borrar
																	Revision</h5>
															</div>
															<div class="modal-body">¿Desea eliminar la revision seleccionada?</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">No</button>
																<button type="button" class="btn btn-danger"
																	onclick="location.href='<c:url value="/borrarRevision?idRevision=${lr.idRevision }"/>'">Sí</button>
															</div>
														</div>
													</div>
												</div>
											</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>

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
