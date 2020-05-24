<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Mettu Center Login</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">


							<div class="col-lg-6 d-none d-lg-block ">
								<img class="img-fluid px-3 px-sm-4 mt-3 mb-4"
									style="width: 100rem;" src="img/stop covid.PNG" alt="">

							</div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
									</div>
									<%
												if (session.getAttribute("message") == null) {
											%>
											<div class="text-center">
												<h1 class="h6 text-gray-900 mb-2">
													<c:out value="${message}"></c:out>
												</h1>

											</div>
											<%
												}
											%>
										<form class="needs-validation" method="post" action="LoginController">
										<div class="form-group">
											<input type="email" name="username"
												class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												placeholder="Enter Email Address..." required="">
										</div>
										<div class="invalid-feedback">Valid Email id is required.</div>
										<div class="form-group">
											<input type="password" name="password"
												class="form-control form-control-user"
												id="exampleInputPassword" placeholder="Password" required="">
										</div>
										<div class="invalid-feedback">Valid password is required.</div>
										<div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input type="checkbox" class="custom-control-input"
													id="customCheck"> <label
													class="custom-control-label" for="customCheck">Remember
													Me</label>
											</div>
										</div>

										<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="forgetpassword.jsp">Forgot
											Password?</a>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>
<script>
				// Example starter JavaScript for disabling form submissions if there are invalid fields
								(
										function() {
											'use strict';

											window
													.addEventListener(
															'load',
															function() {
																// Fetch all the forms we want to apply custom Bootstrap validation styles to
																var forms = document
																		.getElementsByClassName('needs-validation');

																// Loop over them and prevent submission
																var validation = Array.prototype.filter
																		.call(
																				forms,
																				function(
																						form) {
																					form
																							.addEventListener(
																									'submit',
																									function(
																											event) {
																										if (form
																												.checkValidity() === false) {
																											event
																													.preventDefault();
																											event
																													.stopPropagation();
																										}
																										form.classList
																												.add('was-validated');
																									},
																									false);
																				});
															}, false);
										})();
			</script>
</body>

</html>
