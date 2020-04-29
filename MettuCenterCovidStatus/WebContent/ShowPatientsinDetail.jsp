<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<jsp:include page="include/policesidemenu.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<!-- <div id="content-wrapper" class="d-flex flex-column"> -->

		<!-- Main Content -->



		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<h1 class="h3 mb-2 text-gray-800">Patient Details</h1>

			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Patients List</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">

							<thead>
								<tr>
									<th>S.No</th>
									<th>Patient ID</th>
									<th>First Name</th>
									<th>Middle Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th>Region</th>
									<th>Country</th>
									<th>Health Status</th>
									<th>Admitted On</th>
									<th height="30px">Action</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="patient" items="${patientList}"
									varStatus="status">

									<tr>
										<td>${status.index + 1}</td>
										<td>${patient.patientId}</td>
										<td style="text-transform: capitalize">${patient.firstName}</td>
										<td style="text-transform: capitalize">${patient.middleName}</td>
										<td style="text-transform: capitalize">${patient.lastName}</td>
										<td>${patient.gender}</td>
										<td>${patient.region}</td>
										<td>${patient.country}</td>
										<td>${patient.presentStatus}</td>
										<td>${patient.admittedOn}</td>


										<td><a
											href="StaffPatientInfo?id=<c:out value="${patient.patientId}"/>"
											class="btn btn-xs btn-real tooltips" style="size: 10px;"
											data-original-title="Profile"><i class="fa fa-user-check"></i> </a> 
											
											<%-- <a href="UpdatePatientController?id=<c:out value="${patient.patientId}"/>"
											class="btn btn-xs btn-real tooltips" style="size: 10px;"
											data-original-title="Edit"><i class="fa fa-edit"></i> </a> <a
											href="DeletePatientController?id=<c:out value="${patient.patientId}"/>"
											class="btn btn-xs btn-real tooltips" style="size: 10px;"
											data-original-title="Delete"><i
												class="fa fa-times fa fa-white"></i></a> --%></td>
									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- end: PAGE -->


	<!-- /.container-fluid -->

	<!-- End of Main Content -->
	<div class="row"></div>
	<!-- Footer -->
	<footer class="sticky-footer bg-white">
		<div class="container my-auto">
			<div class="copyright text-center my-auto">
				<span>Developed and maintained by Mettu University, Ethiopia</span>
			</div>
		</div>
	</footer>
	<!-- End of Footer -->


	<!-- End of Content Wrapper -->


	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- <!-- Logout Modal-->
	<!-- <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>  -->

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>

</body>

</html>