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
		<h1 class="my-4">Cliente: ${u.getNombre()}
			${u.getApellido() }</h1>
		<c:choose>
	        <c:when test="${mensaje!='' }">
	            <div class="alert alert-warning alert-dismissable">
	                <button type="button" class="close" data-dismiss="alert"
	                    aria-hidden="true">x</button>
	                <strong>Info!</strong> ${mensaje }
	            </div>
	        </c:when>
	    </c:choose>
		
		
		<div class="row">
			<div class="col-lg-6 portfolio-item">
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Cliente</a>
					</h4>
					<div>
						<p>Nombre: ${u.getNombre()}</p>
						<p>Apellido: ${u.getApellido()}</p>
						<p>Correo: ${u.getCorreo()}</p>
						<p>Telefono: ${u.getTelefono()}</p>
						
						
						<button type="button" class="btn btn-primary btn-lg "
							onclick="location.href='<c:url value="/addCocheAdminVista?idUsuario=${u.idUsuario }"/>'">
							<i class="fa fa-car"></i>Añadir Coches
						</button>
					</div>
				</div>
			</div>
			<div class="col-lg-10 portfolio-item">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Lista de Coches : ${u.getNombre()}
			${u.getApellido() }</a>
						</h4>
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<td>Matricula</td>
										<td>Marca</td>
										<td>Modelo</td>
										<td>Año</td>
										<td>Motor</td>
										<td>Potencia</td>
										<td></td>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listCars }" var="lc">
										<tr>
											<td>${lc.matricula}</td>
											<td>${lc.marca }</td>
											<td>${lc.modelo }</td>
											<td>${lc.anyo }</td>
											<td>${lc.motor }</td>
											<td>${lc.potencia }</td>
											<td>
											
												
												<button type="button" class="btn btn-danger"
													data-toggle="modal"
													data-target="#deleteCars${lc.idCoche}">
													<i class="fa fa-times" aria-hidden="true"
														data-toggle="modal"></i> Borrar
												</button>
												<div class="modal fade"
													id="deleteCars${lc.idCoche}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">Borrar
																	Coche</h5>
															</div>
															<div class="modal-body">¿Desea eliminar al
																coche ?</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">No</button>
																<button type="button" class="btn btn-danger"
																	onclick="location.href='<c:url value="/deleteCarsbyAdmin?idCoche=${lc.idCoche }"/>'">Sí</button>
															</div>
														</div>
													</div>
												</div>
												<button type="button" class="btn btn-warning"
													onclick="location.href='<c:url value="/editarCarsAdmins?idCoche=${lc.idCoche }"/>'">
													<i class="fa fa-cogs" aria-hidden="true"></i> Editar
												</button>
												<button type="button" class="btn btn-info"
													onclick="location.href='<c:url value="/revisionsVistaByCars?idCoche=${lc.idCoche }"/>'">
													<i class="fa fa-cogs" aria-hidden="true"></i> Revisiones
												</button>
												
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
