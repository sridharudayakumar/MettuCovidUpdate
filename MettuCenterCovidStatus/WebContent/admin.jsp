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

<title>Mettu Center - Staff Dashboard</title>

<!-- Custom fonts for this template-->
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
			<div id="content">

				<!-- Topbar -->

				<!-- Topbar Search -->










				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>

					</div>

					<!-- Content Row -->

					<div class="row">
						<c:forEach var="count" items="${counttempList }">
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card bg-info text-white shadow">
									<div class="card-body text-center">
										Total Cases
										<div class="text-white-50 text-center">${count.total}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card bg-primary text-white shadow">
									<div class="card-body text-center">
										Active Cases
										<div class="text-white-50 text-center">${count.active}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-success text-white shadow">
									<div class="card-body text-center">
										Cured
										<div class="text-white-50 text-center">${count.cured}</div>
									</div>
								</div>
							</div>

							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-warning text-white shadow">
									<div class="card-body text-center">
										Critical Cases
										<div class="text-white-50 text-center">${count.critical}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-danger text-white shadow">
									<div class="card-body text-center">
										Deaths
										<div class="text-white-50 text-center">${count.death}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-secondary text-white shadow">
									<div class="card-body text-center">
										Quarantined
										<div class="text-white-50 text-center ">${count.quarantined}</div>
									</div>
								</div>

							</div>
						</c:forEach>
					</div>



					<div class="col-lg-12 mb-4">


						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Reports</h6>
							</div>
							<div class="card-body">
								<div class="row">

									<ul class="list-group list-group-flush">
										<li class="list-group-item"><a
											href="ReportHealthWise.jsp">Health Status wise Report</a></li>
										<li class="list-group-item"><a href="ReportDateWise.jsp">Date
												Wise Report</a></li>
										<li class="list-group-item"><a href="ReportAgeWise.jsp">Age
												Wise Report</a></li>
										<li class="list-group-item"><a href="ReportZoneWise.jsp">Zone
												Wise Report</a></li>
										<li class="list-group-item"><a
											href="ReportWoredaWise.jsp">Woreda Wise Report</a></li>
										<li class="list-group-item"><a
											href="ReportRegionWise.jsp">Region Wise Report</a></li>
										<li class="list-group-item"><a
											href="ReportGenderWise.jsp">Gender Wise Report</a></li>


									</ul>


								</div>
							</div>
						</div>


						<!-- informations -->


						<!-- End of Main Content -->

						<!-- Footer -->
						<!-- <footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Developed and maintained by Mettu University, Ethiopia</span>
						</div>
					</div>
				</footer> -->
						<!-- End of Footer -->

					</div>
					<!-- End of Content Wrapper -->

				</div>
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
</body>

</html>
