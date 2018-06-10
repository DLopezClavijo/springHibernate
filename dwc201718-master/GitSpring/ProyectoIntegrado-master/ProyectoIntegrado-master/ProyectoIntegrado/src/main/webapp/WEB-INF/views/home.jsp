<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Scrolling Nav - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
   	<link rel="stylesheet" href='<c:url value="/resources/css/Prueba"/>'> 
    
    <link rel="stylesheet" href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>'> 

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href='<c:url value="/resources/css/scrolling-nav.css"/>'>
</head>
<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#registrar">Registrar</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">Contact</a>
            </li>
            
            <div class="pull-right">
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" class="nav-link js-scroll-trigger"
							data-toggle="dropdown">Iniciar Sesion</a>
							<ul class="dropdown-menu">
								<c:url value="/inicioSesion" var="iniciarSesion"></c:url>
								<f:form method="POST" action="${iniciarSesion }" id="formularioInicio" commandName="usuario">
									<div class="form-group">
										<f:label path="alias">Usuario: </f:label>
										<br>
										<f:input type="text" placeholder="Nombre Usuario"
											class="form-control" path="alias" name="alias" id="alias" required="required"/>
									</div>
									<div class="form-group">
										<f:label path="password">Password:</f:label>
										<f:input type="password" path="password" name="password" id="password"
											placeholder="Password" class="form-control" required="required"/>
									</div>
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-sign-in"></i>Inicar Sesion
									</button>
								</f:form>
							</ul>
						</li>
					</ul>
				</div>
          </ul>
        </div>
      </div>
    </nav>

    <header >
      <div class="container text-center">
        <h1>Welcome to Scrolling Nav</h1>
        <p class="lead">A landing page template freshly redesigned for Bootstrap 4</p>
      </div>
    </header>

    <section id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <h2>About this page</h2>
            <p class="lead">This is a great place to talk about your webpage. This template is purposefully unstyled so you can use it as a boilerplate or starting point for you own landing page designs! This template features:</p>
            <ul>
              <li>Clickable nav links that smooth scroll to page sections</li>
              <li>Responsive behavior when clicking nav links perfect for a one page website</li>
              <li>Bootstrap's scrollspy feature which highlights which section of the page you're on in the navbar</li>
              <li>Minimal custom CSS so you are free to explore your own unique design options</li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <section id="services" class="bg-light">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <h2>Services we offer</h2>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut optio velit inventore, expedita quo laboriosam possimus ea consequatur vitae, doloribus consequuntur ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>
          </div>
        </div>
      </div>
    </section>
    
    <section  id="registrar" class="bg-light">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-8 mx-auto">
    				<h2>Registrar</h2>
    				<c:if test="${mensaje != ''}">
	    				<div class="alert alert-warning alert-dismissable">
	     					<button type="button" class="close" data-dismiss="alert"
	      					aria-hidden="true">x</button>
	     					<strong>Info!</strong> ${mensaje}
	    				</div>
	  	 			</c:if>
    				<br>
					<c:url value="/Registrar" var="registrar"></c:url>
					<f:form class="navbar-form navbar-right " method="POST"
					action="${registrar }" id="formularioInicio" commandName="usuario">
					<div class="form-group">
						<f:label path="nombre">Nombre:</f:label>
						<f:input type="text" placeholder="Nombre"
							class="form-control" path="nombre" name="nombre" id="nombre" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="apellido">Apellidos:</f:label>
						<f:input type="text" placeholder="Apellidos"
							class="form-control" path="apellido" name="apellido" id="apellido" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="alias">Usuario:</f:label>
						<f:input type="text" placeholder="Usuario"
							class="form-control" path="alias" name="alias" id="alias" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="password">Password:</f:label>
						<f:input type="password" path="password" name="password" id="password"
							placeholder="Password" class="form-control" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="correo">Correo:</f:label>
						<f:input type="correo" path="correo" name="correo" id="correo"
							placeholder="Correo" class="form-control" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="telefono">Telefono:</f:label>
						<f:input type="number" path="telefono" name="telefono" id="telefono"
							placeholder="Telefono" class="form-control" required="required"/>
					</div>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-sign-in"></i>Registrar
					</button>
				</f:form>
    				
    			</div>
    		</div>
    	</div>
    </section>

    <section id="contact">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto" >
            <h2>Contactar</h2>
            <div style="float: left ;">
				<c:url value="/Registrar" var="registrar"></c:url>
					<f:form class="navbar-form navbar-right " method="POST"
					action="${registrar }" id="formularioInicio" commandName="usuario">
					<div class="form-group">
						<f:label path="nombre">Nombre:</f:label>
						<f:input type="text" placeholder="Nombre"
							class="form-control" path="nombre" name="nombre" id="nombre" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="apellido">Apellidos:</f:label>
						<f:input type="text" placeholder="Apellidos"
							class="form-control" path="apellido" name="apellido" id="apellido" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="alias">Usuario:</f:label>
						<f:input type="text" placeholder="Usuario"
							class="form-control" path="alias" name="alias" id="alias" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="password">Password:</f:label>
						<f:input type="password" path="password" name="password" id="password"
							placeholder="Password" class="form-control" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="correo">Correo:</f:label>
						<f:input type="correo" path="correo" name="correo" id="correo"
							placeholder="Correo" class="form-control" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="telefono">Telefono:</f:label>
						<f:input type="number" path="telefono" name="telefono" id="telefono"
							placeholder="Telefono" class="form-control" required="required"/>
					</div>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-sign-in"></i>Registrar
					</button>
				</f:form>
            </div>
           
            <div style="float: right ;">
        		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12683.962112160576!2d-5.956825251955528!3d37.36640100474346!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd126eecb7490a67%3A0xb164491d24192432!2sLavado+Y+Engrase+Los+Vecinos!5e0!3m2!1ses!2ses!4v1527937487360" width="400" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
       		</div>
            
            	
          </div>
          
        </div>
        
      </div>
    </section>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src='<c:url value="/resources/vendor/jquery/jquery.min.js" />'></script>
    <script src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>

    <!-- Plugin JavaScript -->
    <script src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />'></script> 

    <!-- Custom JavaScript for this theme -->
    <script src='<c:url value="/resources/js/scrolling-nav.js" />'></script> 

  </body>
</html>
