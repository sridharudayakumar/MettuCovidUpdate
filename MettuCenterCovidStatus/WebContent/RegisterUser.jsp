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

<title>Mettu Center - Dashboard</title>

<!-- Custom fonts for this template-->

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/checkout/">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/form-validation.css" rel="stylesheet">

<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="include/sidebarmenu.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<!-- Registration form -->

			<div class="container">
				<div class="row no-gutters align-items-center">
					<div class="col-md-12 ">

						<h2>User Registration</h2>
						<hr>
					</div>
					<hr>
				</div>

				<div class="row">

					<div class="col-lg-12 mb-4">
						<form class="needs-validation" method="post" action="AddUser">
						<%-- <div class="text-danger">
									<label for="firstName"><c:out value="${FailureText}"></c:out></label>
								</div>
								<div class="text-success">
									<label for="firstName"><c:out value="${SuccessText}"></c:out></label>
								</div> --%>
							<div class="row">
								
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-6 mb-3">
									<label for="firstName">First name</label> <input type="text"
										class="form-control" id="firstName" name="firstName"
										placeholder="" value="" required="">
									<div class="invalid-feedback">Valid first name is
										required.</div>
								</div>
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-6 mb-3">
									<label for="lastName">Last name</label> <input type="text"
										class="form-control" id="lastName" name="lastName"
										placeholder="" value="" required="">
									<div class="invalid-feedback">Valid last name is
										required.</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-6 mb-3">
									<label for="age">Email</label> <input type=email
										"
										class="form-control" id="email" name="email"
										placeholder="" value="" required="">
									<div class="invalid-feedback">Valid email required.</div>
								</div>
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-6 mb-3">
									<label for="age">password</label> <input type=password
										"
										class="form-control" id="password"
										name="password" placeholder="" value="" minlength="6"
										required="">
									<div class="invalid-feedback">Valid password is required.</div>
								</div>
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-3 mb-3"></div>
								<div class="col-md-6 mb-3">
									<label for="role">Role</label> <select
										class="custom-select d-block w-100" id="role" name="role"
										required="">
										<option value="">Choose...</option>
										<option>Administrator</option>
										<option>Hospital Staff</option>
										<option>Police</option>
										<option>PRO</option>
										<option>Zone Health Bureau</option>

									</select>

								</div>

							</div>





							<hr class="mb-4">
							<div class="row">
								<div class="col-md-6 mb-3">

									<button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>

								</div>
								<div class="col-md-6 mb-3">


									<button class="btn btn-warning btn-lg btn-block" type="reset">Cancel</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>



		</div>
		<!-- end of registration -->


		<!-- /.container-fluid -->

		<!-- End of Main Content -->

		<!-- End of Footer -->


		<!-- End of Content Wrapper -->


		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>


		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="vendor/chart.js/Chart.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="js/demo/chart-area-demo.js"></script>
		<script src="js/demo/chart-pie-demo.js"></script>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-3.2.1.slim.min.js.download"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script>
			window.jQuery
					|| document
							.write(
									'<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
		</script>
		<script src="js/popper.min.js.download"></script>
		<script src="js/bootstrap.min.js.download"></script>
		<script src="js/holder.min.js.download"></script>
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