<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Añadir Coche</title>

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
<body>
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
		<c:if test="${mensaje != '' }">
			<div class="alert alert-warning alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<strong>Info!</strong> ${mensaje}
			</div>
		</c:if>
		<div class="row">
			<div class="col-lg-10 ">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Formulario para añadir un coche</a>
						</h4>
						<c:url value="/addCocheByWorks" var="addCocheByWorks"></c:url>
						<f:form class="navbar-form navbar-right " method="POST"
							action="${addCocheByWorks }" id="addCocheByWorks" commandName="coche"
							>
							<f:input style="display: none;" path="idCoche" type="number" name="idCoche"  required="required"
														class="form-control" />
							<div class="form-group">
								<f:label path="matricula">Matricula:</f:label>
								<f:input type="text" placeholder="Matricula"
									class="form-control" path="matricula" name="matricula"
									id="matricula" required="required" />
							</div>
							<div class="form-group">
								<f:label path="marca">Marca:</f:label>
								<f:input type="text" placeholder="Marca" class="form-control"
									path="marca" name="marca" id="marca" required="required" />
							</div>
							<div class="form-group">
								<f:label path="modelo">Modelo:</f:label>
								<f:input type="text" placeholder="Modelo" class="form-control"
									path="modelo" name="modelo" id="modelo" required="required" />
							</div>
							<div class="form-group">
								<f:label path="anyo">Año:</f:label>
								<f:input type="text" placeholder="Año" class="form-control"
									path="anyo" name="anyo" id="anyo" required="required" />
							</div>
							<div class="form-group">
								<f:label path="motor">Motor:</f:label>
								<f:input type="text" placeholder="Motor" class="form-control"
									path="motor" name="motor" id="motor" required="required" />
							</div>
							<div class="form-group">
								<f:label path="potencia">Potencia:</f:label>
								<f:input type="text" placeholder="Potencia" class="form-control"
									path="potencia" name="potencia" id="potencia" required="required" />
							</div>

							<button type="submit" class="btn btn-primary">
								<i class="fa fa-sign-in"></i>Guardar
							</button>
						</f:form>

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
	<script>
	$('select#idUsuario').on('change',function(){
	    var valor = $(this).val();
		sessionStorage.setItem("idUsuarioCoche", valor);
	    alert(valor);
	});
	</script>


</body>

</html>
