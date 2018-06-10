<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrapAdmin.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/resources/css/sb-admin.css"/>'>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"> <a class="navbar-brand" href="#">Taller Los
		Vecinos</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Usuarios"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#collapseComponents" data-parent="#exampleAccordion"> <i
					class="fa fa-users"></i> <span class="nav-link-text">Usuarios</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseComponents">
					<li><a href="#usuAdminList">Administrador</a></li>
					<li><a href="#usuWorksList">Trabajadores</a></li>
					<li><a href="#usuClientList">Clientes</a></li>
					<li><a href="<c:url value="/addUsersView"/>">Añadir
							Usuario</a></li>
					<li><a href="<c:url value="/editMyUsersView"/>">Mi Usuario</a></li>

				</ul>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Coches"><a class="nav-link nav-link-collapse collapsed"
				data-toggle="collapse" href="#collapseCars"
				data-parent="#exampleAccordion"> <i class="fa fa-car"></i> <span
					class="nav-link-text">Coches</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseCars">
					<li><a href="#carsList">Ver Coches</a></li>
					<li><a href="<c:url value="/addCocheAdminVista"/>">Añadir
							Coches</a></li>

				</ul></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Reparaciones"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#collapseReparaciones" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-wrench"></i> <span class="nav-link-text">Reparaciones</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseReparaciones">
					<li><a href="#repairList">Ver Reparaciones</a></li>
					<li><a href="<c:url value="/addRepairAdminVista"/>">Añadir
							Reparacion</a></li>

				</ul>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Revisiones"><a class="nav-link" href="#repairRevisions">
					<i class="fa fa-cogs"></i> <span class="nav-link-text">Ver
						Revisiones</span>
			</a></li>

			</li>



			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Cerrar Sesión"><a class="nav-link"
				href="<c:url value="/cerrarSesion"/>"> <i
					class="fa fa-fw fa-sign-out"></i><span class="nav-link-text">Cerrar
						Sesión</span></a></li>
		</ul>
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
	</div>
	</nav>

	<div class="content-wrapper">
		<div class="container-fluid">
			<header>
			<div class="container text-center">
				<h1>Bienvenido ${usuario.getNombre()} ${usuario.getApellido() }</h1>
				<p class="lead">A landing page template freshly redesigned for
					Bootstrap 4</p>
			</div>
			</header>
			<div class="row">
				<!--  List of Administrator -->
				<div class="col-lg-10" id="usuAdminList">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-user-circle" aria-hidden="true"></i>
							Administradores
						</div>
						<div class="card-body">
							<div>
								<section>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<td>Nombre</td>
													<td>Apellidos</td>
													<td>Usuario</td>
													<td>Correo</td>
													<td>Telefono</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listAdministrator }" var="l">
													<tr>
														<td>${l.nombre}</td>
														<td>${l.apellido }</td>
														<td>${l.alias }</td>
														<td>${l.correo }</td>
														<td>${l.telefono }</td>
														<td>
															<button type="button" class="btn btn-danger"
																data-toggle="modal"
																data-target="#borrarUsuario${l.idUsuario}">
																<i class="fa fa-user-times" aria-hidden="true"
																	data-toggle="modal"></i> Borrar
															</button>
															<div class="modal fade" id="borrarUsuario${l.idUsuario}"
																tabindex="-1" role="dialog"
																aria-labelledby="exampleModalLabel" aria-hidden="true">
																<div class="modal-dialog" role="document">
																	<div class="modal-content">
																		<div class="modal-header">
																			<h5 class="modal-title" id="exampleModalLabel">Borrar
																				Usuario</h5>
																		</div>
																		<div class="modal-body">¿Desea eliminar al
																			usuario ${l.nombre} ${l.apellido}?</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-secondary"
																				data-dismiss="modal">No</button>
																			<button type="button" class="btn btn-danger"
																				onclick="location.href='<c:url value="/borrarUsuario?idUsuario=${l.idUsuario }"/>'">Sí</button>
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
								</section>
							</div>
						</div>
					</div>
				</div>

				<!-- List of Workers -->
				<div class="col-lg-10" id="usuWorksList">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-user-circle-o" aria-hidden="true"></i>
							Trabajadores
						</div>
						<div class="card-body">
							<div>
								<section>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<td>Nombre</td>
													<td>Apellidos</td>
													<td>Usuario</td>
													<td>Correo</td>
													<td>Telefono</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listWorkers }" var="lw">
													<tr>
														<td>${lw.nombre}</td>
														<td>${lw.apellido }</td>
														<td>${lw.alias }</td>
														<td>${lw.correo }</td>
														<td>${lw.telefono }</td>
														<td>
															<button type="button" class="btn btn-danger"
																data-toggle="modal"
																data-target="#borrarUsuario${lw.idUsuario}">
																<i class="fa fa-user-times" aria-hidden="true"
																	data-toggle="modal"></i> Borrar
															</button>
															<div class="modal fade" id="borrarUsuario${lw.idUsuario}"
																tabindex="-1" role="dialog"
																aria-labelledby="exampleModalLabel" aria-hidden="true">
																<div class="modal-dialog" role="document">
																	<div class="modal-content">
																		<div class="modal-header">
																			<h5 class="modal-title" id="exampleModalLabel">Borrar
																				Trabajador</h5>
																		</div>
																		<div class="modal-body">¿Desea eliminar al
																			trabajador ${lw.nombre} ${lw.apellido}?</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-secondary"
																				data-dismiss="modal">No</button>
																			<button type="button" class="btn btn-danger"
																				onclick="location.href='<c:url value="/borrarUsuario?idUsuario=${l.idUsuario }"/>'">Sí</button>
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
								</section>
							</div>
						</div>
					</div>
				</div>

				<!-- List of Clients -->
				<div class="col-lg-10" id="usuClientList">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-user-o" aria-hidden="true"></i> Clientes
						</div>
						<div class="card-body">
							<div>
								<section>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<td>Nombre</td>
													<td>Apellidos</td>
													<td>Usuario</td>
													<td>Correo</td>
													<td>Telefono</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listClients }" var="lclient">
													<tr>
														<td>${lclient.nombre}</td>
														<td>${lclient.apellido }</td>
														<td>${lclient.alias }</td>
														<td>${lclient.correo }</td>
														<td>${lclient.telefono }</td>
														<td>
															<button type="button" class="btn btn-danger"
																data-toggle="modal"
																data-target="#borrarUsuario${lclient.idUsuario}">
																<i class="fa fa-user-times" aria-hidden="true"
																	data-toggle="modal"></i> Borrar
															</button>
															<div class="modal fade"
																id="borrarUsuario${lclient.idUsuario}" tabindex="-1"
																role="dialog" aria-labelledby="exampleModalLabel"
																aria-hidden="true">
																<div class="modal-dialog" role="document">
																	<div class="modal-content">
																		<div class="modal-header">
																			<h5 class="modal-title" id="exampleModalLabel">Borrar
																				Trabajador</h5>
																		</div>
																		<div class="modal-body">¿Desea eliminar al
																			cliente ${lclient.nombre} ${lclient.apellido}? borrara tambien todos sus coches</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-secondary"
																				data-dismiss="modal">No</button>
																			<button type="button" class="btn btn-danger"
																				onclick="location.href='<c:url value="/borrarUsuario?idUsuario=${lclient.idUsuario }"/>'">Sí</button>
																		</div>
																	</div>
																</div>
															</div>
															<button type="button" class="btn btn-info"
																onclick="location.href='<c:url value="/usersInfoview?idUsuario=${lclient.idUsuario }"/>'">
																<i class="fa fa-car" aria-hidden="true"></i> Ver Coches
															</button>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</section>

							</div>
						</div>
					</div>
				</div>

				<!-- List of Cars -->
				<div class="col-lg-10" id="carsList">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-car" aria-hidden="true"></i> Coches
						</div>
						<div class="card-body">
							<div>
								<section>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<td>Matricula</td>
													<td>Marca</td>
													<td>Modelo</td>
													<td>Año</td>
													<td>Motor</td>
													<td>Potencia</td>
													<td>Propietario</td>
													<td>Telefono</td>
													<td></td>
													
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listCars }" var="lcars">
													<tr>
														<td>${lcars.matricula }</td>
														<td>${lcars.marca }</td>
														<td>${lcars.modelo }</td>
														<td>${lcars.anyo }</td>
														<td>${lcars.motor }</td>
														<td>${lcars.potencia }</td>
														<td>${lcars.usuario.getNombre() }
															${lcars.usuario.getApellido() }</td>
														<td>${lcars.usuario.getTelefono() }</td>
														<td>
															
															
															<button type="button" class="btn btn-info"
																onclick="location.href='<c:url value="/revisionsVistaByCars?idCoche=${lcars.idCoche }"/>'">
																<i class="fa fa-cogs" aria-hidden="true"></i> Revisiones
															</button>



														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</section>
							</div>
						</div>
					</div>
				</div>

				<!-- List of Repair -->

				<div class="col-lg-10" id="repairList">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-fw fa-wrench" aria-hidden="true"></i>
							Reparaciones
						</div>
						<div class="card-body">
							<div>
								<section>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<td>Nombre</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listRepair }" var="lrepair">
													<tr>
														<td>${lrepair.nombre }</td>

														<td>
															<button type="button" class="btn btn-danger"
																data-toggle="modal"
																data-target="#borrarReparacion${lrepair.idReparacion}">
																<i class="fa fa-times" aria-hidden="true"
																	data-toggle="modal"></i> Borrar
															</button>
															<div class="modal fade"
																id="borrarReparacion${lrepair.idReparacion}"
																tabindex="-1" role="dialog"
																aria-labelledby="exampleModalLabel" aria-hidden="true">
																<div class="modal-dialog" role="document">
																	<div class="modal-content">
																		<div class="modal-header">
																			<h5 class="modal-title" id="exampleModalLabel">Borrar
																				Reparacion</h5>
																		</div>
																		<div class="modal-body">¿Desea eliminar la
																			reparación ${lrepair.nombre}?</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-secondary"
																				data-dismiss="modal">No</button>
																			<button type="button" class="btn btn-danger"
																				onclick="location.href='<c:url value="/deleteRepair?idReparacion=${lrepair.idReparacion }"/>'">Sí</button>
																		</div>
																	</div>
																</div>
															</div>
															<button type="button" class="btn btn-warning"
																onclick="location.href='<c:url value="/editRepairAdminVista?idReparacion=${lrepair.idReparacion }"/>'">
																<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																Editar
															</button>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</section>
							</div>
						</div>
					</div>
				</div>

				<!-- List of Revisions -->

				<div class="col-lg-10" id="repairRevisions">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-cogs" aria-hidden="true"></i> Revisiones
						</div>
						<div class="card-body">
							<div>
								<section>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<td>Matricula</td>
													<td>Fecha</td>
													<td>Kilometros</td>
													<td>Reparacion</td>
													<td>Observaciones</td>
													<td>Precio</td>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listRevisions }" var="lrevision">
													<tr>
														<td>${lrevision.coche.matricula }</td>
														<td>${lrevision.fecha }</td>
														<td>${lrevision.kilometros }</td>
														<td>${lrevision.reparacion.nombre }</td>
														<td>${lrevision.observaciones }</td>
														<td>${lrevision.precio }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								</section>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>




	<footer class="sticky-footer">
	<div class="container">
		<div class="text-center">
			<small>Copyright © Your Website 2018</small>
		</div>
	</div>
	</footer>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>

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
	</div>
</body>
</html>