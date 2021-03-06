<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@ page session="false" %>
<html>
<head>
	<title>Principal Usuario</title>
	<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/resources/css/1-col-portfolio.css"/>'>


<!-- Stylesheets ASIDE -->
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href=""><i class="fa fa-home"
				aria-hidden="true"></i>Inventario</a>
			
	         <li class="divider"></li>
	         <a href="<c:url value="/EditUser"/>"><button
	          	type="button" class="btn btn-primary btn-lg">
	          	<i class="fa fa-user-circle-o" aria-hidden="true"></i> Mi usuario</button>
	         </a>
	         <li class="divider"></li>
	         <a href="<c:url value="/VerCompra"/>"><button
	          	type="button" class="btn btn-primary btn-lg">
	          	<i class="fa fa-user-circle-o" aria-hidden="true"></i> Mis Compras</button>
	         </a>
	         <li class="divider"></li>
	         <a href="<c:url value="/cerrarSesion"/>"><button
	          	type="button" class="btn btn-danger btn-lg">
	          	<i class="fa fa-sign-out" aria-hidden="true"></i> Cerrar Sesion</button></a>
	         
	         
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarExample" aria-controls="navbarExample"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
		</nav>
		<br>
		<br>
		
			
		<c:if test="${mensaje != ''}">
			<div class="alert alert-warning alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">x</button>
					<strong>Info!</strong> ${mensaje}
			</div>	
		</c:if>
		<h1>Articulos</h1>
		<hr>
		
		<div class="row">
		
			<c:forEach items="${listaArticulo}" var="l">
				<div class="col-md-5">
					<h3>${l.nombre }</h3>
					<p>Descripcion: ${l.descripcion}</p>
					<p>Codigo: ${l.codigo}</p>
					<p>Cantidad: ${l.cantidad}</p>
					
	          		<button type="button" class="btn btn-primary" data-toggle="modal" 
	          			data-target="#comprarArticulo${l.idArticulos}">
							<i class="fa fa-cart-plus" aria-hidden="true"></i> Comprar
					</button> 
	          		<div class="modal fade" id="comprarArticulo${l.idArticulos}"
							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Comprar Articulo</h5>
									</div>
									<div class="modal-body">
										�Desea eliminar el articulo ${l.nombre } ?
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">No</button>
										<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/AddCompra?idArticulo=${l.idArticulos }"/>'"><i class="fa fa-cart-plus" aria-hidden="true"></i> S�</button>
	
									</div>
								</div>
							</div>
					</div>
	          		<hr>
				</div>
			</c:forEach>
		
		</div>
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Jose M�
					Lopez Zunino2018</p>
			</div>
	 	</footer>
	</div>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/popper.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
</body>
</html>
