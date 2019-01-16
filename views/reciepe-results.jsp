<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>FoodHub</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />
	
	

	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700,900' rel='stylesheet' type='text/css'>
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700" rel="stylesheet"> -->
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
	<!-- animatedresponsiveImagegrid  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animatedresponsiveImagegrid.css">
	<!-- Magnifoc Popup  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/magnific-popup.css">

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/logincss.css" type="text/css" media="all">
	
	<script src="<%=request.getContextPath()%>/resources/js/modernizr-2.6.2.min.js"></script>
	
	</head>
	<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	<nav id="fh5co-main-nav" role="navigation">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle active"><i></i></a>
		<div class="js-fullheight fh5co-table">
			<div class="fh5co-table-cell js-fullheight">
				<ul>
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="gallery.html">Gallery</a></li>
					<li><a href="services.html">Services</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a></li>
					<li><a onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Register</a></li>
					

				</ul>
			</div>
		</div>
	</nav>
	 <div id="id01" class="modal">
 
		 <form class="modal-content animate" action="${contextPath}/user/login/" method="POST">
		   
		
		   <div class="container">
		     <label for="uname"><b>Username</b></label>
		     <input type="text" placeholder="Enter Username" name="username" required>
		
		     <label for="pwd"><b>Password</b></label>
		     <input type="password" placeholder="Enter Password" name="pwd" required>
		       
		     <button type="submit">Login</button>
		     <label>
		       <input type="checkbox" checked="checked" name="rememberme"> Remember me
		     </label>
		   </div>
		
		   <div class="container" style="background-color:#f1f1f1">
		     <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
		     <span class="psw">Forgot <a href="#">password?</a></span>
		   </div>
		 </form>
		</div>
		
	<div id="id02" class="modal"><h3>Sign Up Form</h3>
 
		 <form  class="modal-content animate" action="${contextPath}/user/register/" method="POST">
		   
		
		   <div class="container">
		     <label for="name"><b>Name</b></label>
		     <input type="text" placeholder="Enter Fullname" name="name" required>
		
		     <label for="pwd"><b>Passport</b></label>
		     <input type="text" placeholder="Enter Passport Number" name="passport" required>
		     
		     <label for="emailId"><b>Email Id</b></label>
		     <input type="text" placeholder="Enter Email" name="emailId" required>
		     
		     <label for="username"><b>UserName</b></label>
		     <input type="text" placeholder="Enter Username" name="username" required>
		     
		     <label for="pwd"><b>Password</b></label>
		     <input type="password" placeholder="Enter Password" name="pwd" required>
		     
		     <label for="contact"><b>Contact</b></label>
		     <input type="text" placeholder="Enter Contact" name="contact" required>
		    
		   <br><br>
		       
		     <button type="submit">Signup</button>
		     <label>
		       <input type="checkbox" checked="checked" name="agreement"> By Clicking this, I agree all terms and policies
		     </label>
		   </div>
		
		   <div class="container" style="background-color:#f1f1f1">
		     <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
		     <span class="psw">Forgot <a href="#">password?</a></span>
		   </div>
		 </form>
		</div>
		
	<div id="fh5co-page">
		<header>
			<div class="container">
				<div class="fh5co-navbar-brand">
					<h1 class="text-center"><a class="fh5co-logo" href="index.html"><i class="icon-camera2"></i></a></h1>
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
				</div>
			</div>
		</header>
		
		
		<!--div id="fh5co-services-section">
			<div class="container">
				
				<div class="row">
					<div class="services">
					
							<span><i class="icon-video-camera2"></i></span>
							<h3>Receipe Search Results</h3>
							<form action="${contextPath}/user/browse/id">
							<c:set var="recipies" value="${sessionScope.recipies}" />
							
							<c:forEach items="${sessionScope.recipies}" var="recipie">
							<div>
							
							<a href="${contextPath}/user/browse/id?id=${recipie.recipeId}">
							<input type="text"  value="${recipie.recipeName}" disabled/>
							</a>
							</div>
							
							</c:forEach> 
							
							</form>
					</div>
				</div>
			</div>
		</div-->

		<div id="fh5co-services-section">
			<div class="container">

				<div class="row">
					<div class="services">

						<span><i class="icon-video-camera2"></i></span>
						<h3>Receipe Search Results</h3>
						<form action="${contextPath}/user/browse/id">
							<c:set var="recipies" value="${sessionScope.recipies}" />

							<c:forEach items="${sessionScope.recipies}" var="recipie">
								<div class="row">
									<div class="services">
										<span><i class="icon-camera2"></i></span>

										<h3>${recipie.recipeName}
											... <i>(${recipie.rating})</i>
										</h3>
										<p>
											Contains... <i> Calories (${recipie.calories} gms),
												Proteins (${recipie.protien} gms), Sodium (${recipie.sodium}
												gms), Fats (${recipie.fat} gms) </i>..... <b><i><a
													href="${contextPath}/user/browse/id?id=${recipie.recipeId}">click
														here to view more >></a></i></b>
										</p>

									</div>
								</div>
							</c:forEach>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-3">
							<h3 class="section-title">Focus</h3>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics.</p>
						</div>
						
						<div class="col-md-3">
							<h3 class="section-title">Our Services</h3>
							<ul>
								<li><a href="#">Videos</a></li>
								<li><a href="#">Photography</a></li>
								<li><a href="#">Editing Photos</a></li>
								<li><a href="#">Newsletter</a></li>
								<li><a href="#">API</a></li>
								<li><a href="#">FAQ / Contact</a></li>
							</ul>
						</div>

						<div class="col-md-4">
							<h3 class="section-title">Photos</h3>
							<ul class="float">
								<li><a href="#">Natures</a></li>
								<li><a href="#">Adventure</a></li>
								<li><a href="#">Wedding</a></li>
								<li><a href="#">Food &amp; Drinks</a></li>
								<li><a href="#">Animals</a></li>
								<li><a href="#">Cars</a></li>
							</ul>
							<ul class="float">
								<li><a href="#">Architecture</a></li>
								<li><a href="#">Wallpaper Car</a></li>
								<li><a href="#">Business</a></li>
								<li><a href="#">Lanscape</a></li>
								<li><a href="#">Environment</a></li>
								<li><a href="#">Climate</a></li>
							</ul>
						</div>
						<div class="col-md-2">
							<h3 class="section-title">Information</h3>
							<ul>
								<li><a href="#">Terms &amp; Condition</a></li>
								<li><a href="#">License</a></li>
								<li><a href="#">Privacy &amp; Policy</a></li>
								<li><a href="#">Contact Us</a></li>
							</ul>
						</div>
					</div>
					<div class="row copy-right">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icon">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>Copyright 2016 Free Html5 <a href="#">Focus</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="http://freehtml5.co/" target="_blank">Freehtml5.co</a> / Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash </a></p>
						</div>
					</div>
				</div>
			</div>
		</footer-->
	
	</div>

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.countTo.js"></script>
	<!-- gridrotator -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.gridrotator.js"></script>
	<!-- Magnific Popup -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>

	<script type="text/javascript">	
		$(function() {
		
			$( '#ri-grid' ).gridrotator( {
				rows : 3,
				// number of columns 
				columns : 6,
				w1024 : { rows : 3, columns : 5 },
				w768 : {rows : 3,columns : 4 },
				w480 : {rows : 3,columns : 3 },
				w320 : {rows : 2,columns : 2 },
				w240 : {rows : 1,columns : 1 },
				preventClick : false
			} );
		
		});
		
		var modal = document.getElementById('id01');

		//When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		if (event.target == modal) {
		    modal.style.display = "none";
		}
		}
		
		var modal2 = document.getElementById('id02');

		//When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		if (event.target == modal2) {
		    modal2.style.display = "none";
		}
		}
		
	</script>

	</body>
</html>

