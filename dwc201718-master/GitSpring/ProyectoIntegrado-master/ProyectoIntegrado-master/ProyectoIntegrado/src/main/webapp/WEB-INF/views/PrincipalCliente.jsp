<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cliente</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
   	<link rel="stylesheet" href='<c:url value="/resources/css/1-col-portfolio.css"/>'>
   	<link rel="stylesheet" href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>
    
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href='<c:url value="/resources/css/1-col-portfolio.css"/>'>
    

  </head>

  <body >

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="/addCocheVista"/>"><i class="fa fa-car" aria-hidden="true"></i> Añadir Coche</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="/editMyUsersView"/>"><i class="fa fa-user-o" aria-hidden="true"></i>Mi usuario</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="/cerrarSesion"/>"><i class="fa fa-fw fa-sign-out"></i>Cerrar Sesión</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      	<!-- Page Heading -->
   		<h1 class="my-4">Bienvenido 
      		${usuario.getNombre()} ${usuario.getApellido() }
		</h1>
		<c:if test="${not empty fallo }"><h2>${fallo}</h2></c:if>
		<c:if test="${not empty mensaje }"><h2>${fallo}</h2></c:if>
		
		<c:choose>
	        <c:when test="${fallo!='' }">
	            <div class="alert alert-warning alert-dismissable">
	                <button type="button" class="close" data-dismiss="alert"
	                    aria-hidden="true">x</button>
	                <strong>Info!</strong> ${fallo }
	            </div>
	        </c:when>
	    </c:choose>
        <div class="row">
        

		<c:forEach items="${listaCoches }" var="c">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-80">
					<h4 class="card-title">
               			 <a href="#">Matricula: ${c.matricula}</a>
              		</h4>
              		
					<hr>
              		<p class="card-text">Modelo: ${c.modelo}</p>
	            	<p class="card-text">Marca: ${c.marca}</p>
	            	<p class="card-text">Modelo: ${c.modelo}</p>
	            	<p class="card-text">Año: ${c.anyo}</p>
	            	<p class="card-text">Motor: ${c.motor}</p>
	            	<p class="card-text">Potencia: ${c.potencia}</p>
              		<button type="button" class="btn btn-danger"
						data-toggle="modal"
						data-target="#deleteCars${c.idCoche}">
						<i class="fa fa-times" aria-hidden="true"
							data-toggle="modal"></i> Borrar
					</button>
					<div class="modal fade"
						id="deleteCars${c.idCoche}" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Borrar
										Coche</h5>
								</div>
								<div class="modal-body">¿Desea eliminar al
									coche con matricula ${c.matricula }?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">No</button>
									<button type="button" class="btn btn-danger"
										onclick="location.href='<c:url value="/deleteCars?idCoche=${c.idCoche }"/>'">Sí</button>
								</div>
							</div>
						</div>
					</div>
					<button type="button" class="btn btn-warning"
						onclick="location.href='<c:url value="/editCarsView?idCoche=${c.idCoche }"/>'">
						<i class="fa fa-car" aria-hidden="true"></i> Editar Coche
					</button>
					<button type="button" class="btn btn-info"
						onclick="location.href='<c:url value="/revisionsVistaByCarsClient?idCoche=${c.idCoche }"/>'">
						<i class="fa fa-cogs" aria-hidden="true"></i> Revisiones
					</button>
					
				</div>
			</div>
		</c:forEach>
        
      <!-- /.row -->
		</div>
     
    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
   	<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/popper.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
    
 

  </body>

</html>
