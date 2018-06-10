<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Trabajador</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href='<c:url value="/resources/css/Prueba"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>'>

<!-- Custom styles for this template -->
<link rel="stylesheet"
	href='<c:url value="/resources/css/scrolling-nav.css"/>'>
	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" href="resources/css/table.css">


</head>
<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Start
				Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#Clientes">Clientes</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#Coches">Coches</a></li>
					
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/cerrarSesion"/>"><i class="fa fa-fw fa-sign-out"></i>Cerrar Sesión</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<header>
		<div class="container text-center">
			<h1>Bienvenido ${usuario.getNombre()} ${usuario.getApellido() }</h1>
			<p class="lead">Como trabajador, puedes ver los coches y los
				clientes.</p>
		</div>
	</header>



	<section id="Clientes">
		<div class="container">
			<div class="row">
				<div class="panel panel-primary filterable">
					<div class="panel-heading">
						<h3 class="panel-title">Lista Clientes</h3>
						<div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Filter</button>
		                </div>
		                <table class="table">
		                	<thead>
			                    <tr class="filters">
			                        <th><input type="text" class="form-control" placeholder="Nombre" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Apellidos" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Alias" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Correo" disabled></th>
	                        		<th><input type="text" class="form-control" placeholder="Telefono" disabled></th>
			                        
			                    </tr>
			                    
			                </thead>
			                <tbody>
			                	<c:forEach items="${listClients }" var="l">
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
												<i class="fa fa-times" aria-hidden="true"
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
														<div class="modal-body">¿Desea eliminar al usuario
															${l.nombre} ${l.apellido}?</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">No</button>
															<button type="button" class="btn btn-danger"
																onclick="location.href='<c:url value="/borrarUsuario?idUsuario=${l.idUsuario }"/>'">Sí</button>
														</div>
													</div>
												</div>
											</div>
											<button type="button" class="btn btn-info"
												onclick="location.href='<c:url value="/usersInfoview?idUsuario=${l.idUsuario }"/>'">
												<i class="fa fa-car" aria-hidden="true"></i> Ver Coches
											</button>
										</td>
				                	</tr>
			                	</c:forEach>
			                </tbody>
		                </table>
						
					</div>
					<button type="button" class="btn btn-primary btn-lg disabled">
						<i class="fa fa-user-plus" aria-hidden="true"></i> Añadir Cliente
					</button>
				</div>
			</div>
		</div>
	</section>

	
	<section id="Coches">
		<div class="container">
			<div class="row">
				<div class="panel panel-primary filterable">
					<div class="panel-heading">
		               <h3 class="panel-title">Coches</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Filter</button>
		                </div>
		            </div>
					
					<table  class="table"  width="100%"
							cellspacing="0">
							<thead>
								<tr class="filters">
			                        <th><input type="text" class="form-control" placeholder="Matricula" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Marca" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Modelo" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Año" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Motor" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Potencia" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Nombre Cliente" disabled></th>
			                        <th><input type="text" class="form-control" placeholder="Telefono" disabled></th>
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
											<button type="button" class="btn btn-danger"
												data-toggle="modal"
												data-target="#borrarCars${lcars.idCoche}">
												<i class="fa fa-times" aria-hidden="true"
													data-toggle="modal"></i> Borrar
											</button>
											<div class="modal fade" id="borrarCars${lcars.idCoche}"
												tabindex="-1" role="dialog"
												aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Borrar
																Coche</h5>
														</div>
														<div class="modal-body">¿Desea eliminar al usuario
															${l.nombre} ${l.apellido}?</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">No</button>
															<button type="button" class="btn btn-danger"
																onclick="location.href='<c:url value="/borrarUsuario?idUsuario=${l.idUsuario }"/>'">Sí</button>
														</div>
													</div>
												</div>
											</div>
											<button type="button" class="btn btn-info"
												onclick="location.href='<c:url value="/revisionsVistaByCars?idCoche=${lcars.idCoche }"/>'">
												<i class="fa fa-cogs" aria-hidden="true"></i> Revisiones
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					
					<button type="button" class="btn btn-primary btn-lg disabled" >
						<i class="fa fa-car" aria-hidden="true"></i> Añadir Coche
					</button>				
				</div>
			</div>
		</div>
	</section>




	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2017</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src='<c:url value="/resources/vendor/jquery/jquery.min.js" />'></script>
	<script
		src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>

	<!-- Plugin JavaScript -->
	<script
		src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />'></script>

	<!-- Custom JavaScript for this theme -->
	<script src='<c:url value="/resources/js/scrolling-nav.js" />'></script>
	<script src='<c:url value="/resources/js/jqueryTabla.js" />'></script>

</body>
</html>
