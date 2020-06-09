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
		<ul class="navbar-nav bg-gradient-info sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-text mx-3">Mettu Center</div>
			</a>
			<!-- <div class="text-center">
				<img class="img-fluid px-3 px-sm-10 mt-0 mb-4" style="width: 30rem;"
					src="img/covid-header.png" alt="">
			</div> -->

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			

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
					class="fas fa-fw fa-folder"></i> <span>Users</span>
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

						<h3 class=" mb-0 font-weight-bold text-primary">Meu COVID-19
							ISOLATION CENTER PLATFORM</h3>

						<br> <br>

					</div>

					<!-- Content Row -->

					<!-- Color System -->

					<div class="row">

						<c:forEach var="count" items="${counttempList }">
							<div class="col-xl-2 col-md-6 mb-4">


								<div class="card bg-info text-white shadow">
									<div class="card-body text-center">
										<strong>Total Cases</strong>
										<div class="text-white-50 text-center">${count.total}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card bg-primary text-white shadow">
									<div class="card-body text-center">
										<strong>Active Cases</strong>
										<div class="text-white-50 text-center">${count.active}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-success text-white shadow">
									<div class="card-body text-center">
										<strong>Cured</strong>
										<div class="text-white-50 text-center">${count.cured}</div>
									</div>
								</div>
							</div>

							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-warning text-white shadow">
									<div class="card-body text-center">
										<strong>Critical Cases</strong>
										<div class="text-white-50 text-center">${count.critical}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-danger text-white shadow">
									<div class="card-body text-center">
										<strong>Deaths</strong>
										<div class="text-white-50 text-center">${count.death}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card bg-secondary text-white shadow">
									<div class="card-body text-center">
										<strong>Quarantined</strong>
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
									<div class="card-body text-center ">Covid-19 Cases in
										Ethiopia</div>
								</div>

							</div>
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card  border-bottom-info">
									<div class="card-body text-center">
										<strong>Total Cases</strong>
										<div class="text-gray-900 text-center">${ethCases.total}</div>
									</div>
								</div>

							</div>
							<div class="col-xl-2 col-md-6 mb-4">

								<div class="card  border-bottom-primary">
									<div class="card-body text-center">
										<strong>Active Cases</strong>
										<div class="text-gray-900 text-center">${ethCases.active}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card  border-bottom-success">
									<div class="card-body text-center">
										<strong>Cured</strong>
										<div class="text-gray-900 text-center">${ethCases.cured}</div>
									</div>
								</div>
							</div>

							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card  border-bottom-warning">
									<div class="card-body text-center">
										<strong>Critical</strong>
										<div class="text-gray-900 text-center">${ethCases.critical}</div>
									</div>
								</div>
							</div>
							<div class="col-xl-2 col-md-6 mb-4">
								<div class="card  border-bottom-danger">
									<div class="card-body text-center">
										<strong>Deaths/Du'a</strong>
										<div class="text-gray-900 text-center">${ethCases.death}</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</div>

					<!-- informations -->

					<div class="row">

						<div class="col-lg-12 mb-4">

							<!-- Do's and Dont's -->


							<div id="carouselExampleIndicators" class="carousel slide"
								data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carouselExampleIndicators" data-slide-to="0"
										class="active"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
								</ol>
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img class="d-block w-70" src="img/corona-icons.jpg"
											width=1100 height=400 alt="COVID19">
									</div>
									<div class="carousel-item">
										<img class="d-block w-70" src="img/Covid symptoms.PNG"
											width=1100 height=350 alt="Second slide">
									</div>
									<div class="carousel-item">
										<img class="d-block w-70" src="img/corona-icons.jpg"
											width=1100 height=400 alt="Third slide">
									</div>
								</div>
								<a class="carousel-control-prev"
									href="#carouselExampleIndicators" role="button"
									data-slide="prev"> <span class="carousel-control-prev-icon"
									aria-hidden="true"></span> <span class="sr-only">Previous</span>
								</a> <a class="carousel-control-next"
									href="#carouselExampleIndicators" role="button"
									data-slide="next"> <span class="carousel-control-next-icon"
									aria-hidden="true"></span> <span class="sr-only">Next</span>
								</a>
							</div>
							<div class="carousel-item">
								<img src="..." alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>STOP COVID-19</h5>
									<p>...</p>
								</div>
							</div>
						</div>
					</div>

					<!--Main layout-->
					<!-- <main class=" m-0 p-0">
								<div class="container-fluid m-0 p-0"></div>
								</main> -->

					<!--Main layout-->


					<div class="row">
						<div class="col-xl-6 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="m-0 font-weight-bold text-white text-uppercase mb-1 pointer-none btn btn-primary">Help
												Line Numbers</div>
											<!-- <div class="col-auto">
												<i class="fas fa-calendar fa-2x text-gray-300"></i>
											</div> -->
											<div class="card-body">
												<p>
													<a
														class="pointer-none btn btn-danger font-weight-bold text-white">Call
														Numbers</a>
												</p>
												<a class="btn btn-app btstyle success"
													href="tel:+251471410486"> <span
													class="badge bg-success"><font class="btfont"
														text-primary><strong><h4>+251471410486</h4></strong></font></span>
													<i class="green fa fa-phone text-primary"></i><strong>
														Meu</strong>
												</a><br> <a class="btn btn-app btstyle primary"
													href="tel:444"> <span class="badge bg-success"><font
														class="btfont"><strong><h4>444</h4></strong></font></span> <i
													class="green fa fa-phone text-primary"></i>&nbsp;<strong>Ethiotelecom</strong>
												</a><br> <a class="btn btn-app btstyle" href="tel:6955">
													<span class="badge bg-success"><font class="btfont"><strong><h4>6955</h4></strong></font></span>
													<i class="green fa fa-phone success"></i><strong>Oromia</strong>
												</a>


											</div>

										</div>

									</div>
								</div>
							</div>
						</div>


						<div class="col-xl-6 col-md-4 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="m-0  font-weight-bold text-white text-uppercase mb-1 pointer-none btn btn-primary">Important
												Links</div>

										</div>
										<div class="col-auto">
											<i class="fas fa-comments fa-2x text-gray-300"></i>

										</div>
										<div class="card-body">
											<p>
												<a target="_blank" href="https://www.covid19.et/covid-19/"
													class="pointer-none btn btn-info">Ethiopia Covid-19
													Monitoring Platform</a>
											</p>
											<p>
												<a target="_blank"
													href="https://www.worldometers.info/coronavirus/"
													class="pointer-none btn btn-info">Worldometers Website
												</a>
											</p>
											<p>
												<a target="_blank" href="http://www.moh.gov.et/ejcc/"
													class="pointer-none btn btn-info">Ministry Of Health
													Ethiopia</a>
											</p>
											<p>
												<a target="_blank" href="http://www.orhb.gov.et/"
													class="pointer-none btn btn-info">Oromia Regional
													Health Bureau</a>
											</p>
											<p>
												<a target="_blank"
													href="https://www.facebook.com/mettuniversity/"
													class="pointer-none btn btn-info">Mettu University
													Facebook</a>
											</p>
											<p>
												<a href="SuspectRegistration.jsp"
													class="pointer-none btn btn-info">Suspect Registration</a>
											</p>



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
									<h6
										class=" m-0 font-weight-bold text-white pointer-none btn btn-primary">Location</h6>
								</div>
								<div class="card-body">
									<div class="row">

										<ul class="list-group list-group-flush">

											<div id="map-container-google-4"
												class="z-depth-1-half map-container-4" style="height: 200px">
												<iframe
													src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3947.8491904714137!2d35.5560439134064!3d8.31778109401618!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x17ab14b69405127d%3A0xb20e69745af2d57b!2sMettu%20University!5e0!3m2!1sen!2sus!4v1590740618629!5m2!1sen!2sus"
													width="1050" height="200" frameborder="0"
													style="border: 1;" allowfullscreen="" aria-hidden="false"
													tabindex="0"></iframe>
											</div>
										</ul>
									</div>

								</div>
							</div>

							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6
										class="m-0 font-weight-bold text-white pointer-none btn btn-primary">Updates
										& Notifications</h6>
								</div>
								<div class="card-body">
									<div class="row">


										<ul class="list-group list-group-flush">
											<c:forEach var="news" items="${newsList}">
												<li class="list-group-item"><a href="${news.url}"
													target="_blank">${news.description}</a></li>
											</c:forEach>

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
									<h6
										class="m-0 font-weight-bold text-white pointer-none btn btn-primary">Videos</h6>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-xl-4 col-md-6 mb-4">
											<div class="card border-left-info shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-info text-uppercase mb-1">
																<strong>Covid-19 Prevention in Afaan Oromo</strong>
															</div>
															<div class="pic-block">
																<iframe width="100%" height="250"
																	src="https://www.youtube-nocookie.com/embed/HBubf-9h_TY"
																	frameborder="0"
																	allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
																	allowfullscreen></iframe>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-xl-4 col-md-6 mb-4">
											<div class="card border-left-info shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-info text-uppercase mb-1">Need
																to know about hands washing</div>
															<div class="pic-block">
																<iframe width="100%" height="250"
																	src="https://www.youtube-nocookie.com/embed/5IbPzHzgMKs"
																	frameborder="0"
																	allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
																	allowfullscreen></iframe>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-xl-4 col-md-2 mb-4">
											<div class="card border-left-info shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-info text-uppercase mb-1">
																<strong>Awareness by Mettu University</strong>
															</div>
															<div class="pic-block">
																<div></div>
																<iframe width="100%" height="250"
																	src="https://www.youtube-nocookie.com/embed/nih4WNGGfoI"
																	frameborder="0"
																	allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
																	allowfullscreen></iframe>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-xl-4 col-md-2 mb-4">
											<div class="card border-left-info shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-info text-uppercase mb-1">How
																virus spreads to others</div>
															<div class="pic-block">
																<div>
																	<iframe style="width: 100%" height="250"
																		src="https://youtube.com/embed/-kU8Xv2CYJM"
																		frameborder="0"
																		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
																		allowfullscreen=""></iframe>
																</div>

															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-xl-4 col-md-2 mb-4">
											<div class="card border-left-info shadow h-100 py-2">
												<div class="card-body">
													<div class="row no-gutters align-items-center">
														<div class="col mr-2">
															<div
																class="text-xs font-weight-bold text-info text-uppercase mb-1">Virus
																COVId-19 Control and Prevention</div>
															<div class="pic-block">
																<div>
																	<iframe style="width: 100%" height="250"
																		src="https://youtube.com/embed/FC4soCjxSOQ"
																		frameborder="0"
																		allow="accelerometer; autoplay; encrypted-media; gyroscope; 
																 picture-in-picture"
																		allowfullscreen=""></iframe>
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
