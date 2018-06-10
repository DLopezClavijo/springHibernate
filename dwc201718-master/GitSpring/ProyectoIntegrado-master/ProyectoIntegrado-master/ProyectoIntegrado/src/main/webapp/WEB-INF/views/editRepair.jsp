<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Editar Reparacion</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
   	<link rel="stylesheet" href='<c:url value="/resources/css/1-col-portfolio.css"/>'>
   	<link rel="stylesheet" href='<c:url value="/resources/fonts/font-awesome.min.css"/>'>
    
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href='<c:url value="/resources/css/1-col-portfolio.css"/>'>
    
</head>
 <body>
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
              <a class="nav-link" href="<c:url value="/return"/>"> <i class="fa fa-reply" aria-hidden="true"></i>
              Volver</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      	<!-- Page Heading -->
      	<h1 class="my-4">
      		Añadir Reparacion
      	</h1>
      	<c:if test="${mensaje != ''}">
			<div class="alert alert-warning alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">x</button>
					<strong>Info!</strong> ${mensaje}
			</div>
		</c:if>
		
		<c:url value="/editRepair" var="editRepair"></c:url>
			<f:form class="navbar-form navbar-right " method="POST"
			action="${editRepair }" id="formularioEditRepair" commandName="reparacion">
			<f:input style="display: none;" path="idReparacion" type="number" name="idReparacion"  required="required"
														class="form-control" />
			<div class="form-group">
				<f:label path="nombre">Nombre:</f:label>
				<f:input type="text" placeholder="Nombre"
					class="form-control" path="nombre" name="nombre" id="nombre" required="required"/>
			</div>
			
			<button type="submit" class="btn btn-primary">
				<i class="fa fa-user-plus" aria-hidden="true"></i>Guardar
			</button>
		</f:form>
		
      

      

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
