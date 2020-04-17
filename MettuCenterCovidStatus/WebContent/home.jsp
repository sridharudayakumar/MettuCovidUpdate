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
<meta name="description"
	content="Dashboard provides a details of the person affected by covid-19 in Mettu, Ethiopia. also it provides an awarness to the public for protect them from the virus spread.">
<meta name="author" content="Mettu University">

<title>Mettu Center - Dashboard</title>

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
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-text mx-3">Mettu Center</div>
			</a>
			<div class="text-center">
				<img class="img-fluid px-3 px-sm-10 mt-0 mb-4" style="width: 30rem;"
					src="img/covid-header.png" alt="">
			</div>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="index.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->

			<!-- Nav Item - Pages Collapse Menu -->




			<!-- Divider -->


			<!-- Heading -->


			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Admin</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						<a class="collapse-item" href="login.jsp">Login</a>
						<div class="collapse-divider"></div>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>


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
						<h1 class="h3 mb-0 text-gray-800">Mettu Center - Dashboard</h1>

					</div>

					<!-- Content Row -->

					<!-- Color System -->

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

					<!-- Ethiopia dashboard -->

					<div class="row"></div>
					<div class="row">
						<c:forEach var="count" items="${counttempList }">
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card  border-left-info bg-gray-200">
									<div class="card-body text-center ">
										Covid-19 Cases in Ethiopia 
										
									</div>
								</div>

							</div>
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card  border-bottom-info">
									<div class="card-body text-center">
										Total Cases
										<div class="text-gray-900 text-center">96</div>
									</div>
								</div>

							</div>
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card  border-bottom-primary">
									<div class="card-body text-center">
										Active Cases
										<div class="text-gray-900 text-center">76</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card  border-bottom-success">
									<div class="card-body text-center">
										Cured
										<div class="text-gray-900 text-center">15</div>
									</div>
								</div>
							</div>

							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card  border-bottom-warning">
									<div class="card-body text-center">
										Critical
										<div class="text-gray-900 text-center">1</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card  border-bottom-danger">
									<div class="card-body text-center">
										Deaths
										<div class="text-gray-900 text-center">3</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</div>

					<!-- informations -->

					<div class="row">

						<div class="col-lg-12 mb-4">

							<!-- Do's and Dont's -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Symptoms &
										Preventions</h6>
								</div>
								<div class="card-body">
									<div class="text-center">
										<img class="img-fluid px-3 px-sm-4 mt-3 mb-4"
											style="width: 80rem;" src="img/Covid symptoms.PNG" alt="">
									</div>

								</div>
							</div>

							<div class="row">
								<div class="col-xl-6 col-md-6 mb-4">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="m-0 font-weight-bold text-primary text-uppercase mb-1">Help
														Line Numbers</div>

												</div>
												<div class="col-auto">
													<i class="fas fa-calendar fa-2x text-gray-300"></i>
												</div>
											</div>
										</div>
									</div>
								</div>


								<div class="col-xl-6 col-md-4 mb-4">
									<div class="card border-left-warning shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="m-0  font-weight-bold text-warning text-uppercase mb-1">Social
														Media</div>

												</div>
												<div class="col-auto">
													<i class="fas fa-comments fa-2x text-gray-300"></i>

												</div>
												<div class="card-body">
													<strong>Federal Ministry of Health</strong> <a
														href="http://www.facebook.com/EthiopiaFMoH/" target="_blank">
														http://www.facebook.com/EthiopiaFMoH/</a> <a
														href="https://twitter.com/FMoHealth" target="_blank">https://twitter.com/FMoHealth</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End of Information -->
					<!-- Updates Row -->

					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-12 mb-4">

							<!-- Project Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Guidelines</h6>
								</div>
								<div class="card-body">
									<div class="row">

										<ul class="list-group list-group-flush">
											<li class="list-group-item"><a
												href="img/Awarness in afan oromo.png" target="_blank">Covid-19
													Awareness in Afaan Oromo</a></li>
											<li class="list-group-item"><a
												href="img/Awarness in amharic.png" target="_blank">Covid-19
													Awareness in Amharic</a></li>

										</ul>


									</div>
								</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Updates &
										Notifications</h6>
								</div>
								<div class="card-body">
									<div class="row">

										<ul class="list-group list-group-flush">
											<li class="list-group-item"><a
												href="https://news.cgtn.com/news/2020-04-17/Chinese-medical-team-arrives-in-Ethiopia-to-help-in-COVID-19-fight-PLym4IZOQ8/index.html"
												target="_blank">Chinese medical team arrives in Ethiopia
													to help in COVID-19 fight</a></li>
											<li class="list-group-item"><a
												href="https://www.bloomberg.com/news/articles/2020-04-16/fear-of-economic-shock-hampers-ethiopia-s-coronavirus-fight"
												target="_blank">Ethiopias Nobel Laureate Is Hampering
													the Virus Fight</a></li>

										</ul>


									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Videos -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-12 mb-4">

							<!-- Project Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Videos</h6>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-xl-4 col-md-6 mb-4">
											<div class="card border-left-warning shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-warning text-uppercase mb-1">Covid-19
																Prevention in Afaan Oromo</div>
															<div class="pic-block">
																<a target="_blank"
																	href="https://www.youtube.com/watch?v=HBubf-9h_TY"><img
																	src="img/covidPrevent Afaan oromo.PNG"
																	style="width: 17rem;" alt="" title=""></a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-xl-4 col-md-6 mb-4">
											<div class="card border-left-warning shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-warning text-uppercase mb-1">Need
																to know about hands washing</div>
															<div class="pic-block">
																<a target="_blank" href="https://youtu.be/d914EnpU4Fo"><img
																	src="img/Know about hand washing.PNG"
																	style="width: 17rem;" alt="" title=""></a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-xl-4 col-md-2 mb-4">
											<div class="card border-left-warning shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-warning text-uppercase mb-1">Know
																the right way to wash your hands</div>
															<div class="pic-block">
																<a target="_blank"
																	href="https://www.youtube.com/watch?v=3PmVJQUCm4E"><img
																	src="img/How to wash hands.PNG" style="width: 17rem;"
																	alt="" title=""></a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-xl-4 col-md-2 mb-4">
											<div class="card border-left-warning shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-warning text-uppercase mb-1">How
																virus spreads to others</div>
															<div class="pic-block">
																<a target="_blank"
																	href="https://www.youtube.com/watch?v=u63dcOalxg4"><img
																	src="img/how virus spread.PNG" style="width: 17rem;"
																	alt="" title=""></a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-xl-4 col-md-2 mb-4">
											<div class="card border-left-warning shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-warning text-uppercase mb-1">Virus
																Awareness in Amharic</div>
															<div class="pic-block">
																<a target="_blank"
																	href="https://www.youtube.com/watch?v=jcb2A9M9K9U"><img
																	src="img/virus awareness in amharic.PNG"
																	style="width: 17rem;" alt="" title=""></a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
						<!-- End of videos -->


					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Developed and maintained by Mettu University,
							Ethiopia</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
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
	</div>

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
