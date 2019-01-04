<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header.jsp" %>
<style>
h1 {
  letter-spacing: 8px;
}

h5 {
  letter-spacing: 3px;
}

.hr-light {
  border-top: 3px solid #fff;
  width: 80px;
}

</style>
<c:choose>
	<c:when test="${user eq null}">
		<div style="height:100vh">
			<!-- Mask & flexbox options-->
			<div class="d-flex justify-content-center align-items-center h-100">
				<!-- Content -->
				<div class="container">
					<!--Grid row-->
					<div class="row">
						<!--Grid column-->
						<div class="col-md-12 mb-4 white-text text-center">
							<h1
								class="h1-reponsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown"
								data-wow-delay="0.3s">
								<strong>STEALER</strong>
							</h1>
							<hr class="hr-light my-4 wow fadeInDown" data-wow-delay="0.4s">
							<h5 class="text-uppercase mb-4 white-text wow fadeInDown"
								data-wow-delay="0.4s">
								<strong>MUSIC SERVICE FOR EVERYONE</strong>
							</h5>
							<a href="/signup" class="btn btn-outline-white wow fadeInDown" data-wow-delay="0.4s">Sign Up</a> 
							<a href="/login" class="btn btn-outline-white wow fadeInDown" data-wow-delay="0.4s">Login</a>
						</div>
						<!--Grid column-->
					</div>
					<!--Grid row-->
				</div>
				<!-- Content -->
			</div>
			<!-- Mask & flexbox options-->
		</div>
		<!-- Full Page Intro -->
	</c:when>
	<c:otherwise>
		<div class="d-flex justify-content-center">
		<div class="container col-lg-9 bg-white container-main">
			<!-- Section: Blog v.1 -->
			<section class="my-5 wow fadeInDown">
			
			  <!-- Section heading -->
			  <h2 class="h1-responsive font-weight-bold text-center my-5">Welcome, ${user.name}!</h2>
			  <!-- Section description -->
			  <p class="text-center w-responsive mx-auto mb-5">Stealer provides you plenties of music and artist.<br>Explore and Enjoy</p>
			
			  <!-- Grid row -->
			  <div class="row">
			
			    <!-- Grid column -->
			    <div class="col-lg-5">
			
			      <!-- Featured image -->
			      <div class="view overlay rounded z-depth-2 mb-lg-0 mb-4">
			        <img class="img-fluid" src="/resources/img/cover1.png" alt="Sample image">
			        <a>
			          <div class="mask rgba-white-slight"></div>
			        </a>
			      </div>
			
			    </div>
			    <!-- Grid column -->
			
			    <!-- Grid column -->
			    <div class="col-lg-7">
			
			      <!-- Category -->
			      <a href="#!" class="cyan-text">
			        <h6 class="font-weight-bold mb-3"><i class="fa fa-line-chart pr-2"></i>Chart</h6>
			      </a>
			      <!-- Post title -->
			      <h3 class="font-weight-bold mb-3"><strong>Hot 100 songs</strong></h3>
			      <!-- Excerpt -->
			      <p> Hot 100 chart ranks the top 100 songs of the week based on sales, radio airplay, and streaming activity.</p>
			      <!-- Read more button -->
			      <a class="btn btn-info btn-md" href="/chart">Explore</a>
			
			    </div>
			    <!-- Grid column -->
			
			  </div>
			  <!-- Grid row -->
			
			  <hr class="my-5">
			
			  <!-- Grid row -->
			  <div class="row">
			
			    <!-- Grid column -->
			    <div class="col-lg-7">
			
			      <!-- Category -->
			      <a href="#!" class="pink-text">
			        <h6 class="font-weight-bold mb-3"><i class="fa fa-cc-discover pr-2"></i>New</h6>
			      </a>
			      <!-- Post title -->
			      <h3 class="font-weight-bold mb-3"><strong>What's New?</strong></h3>
			      <!-- Excerpt -->
			      <p>Hear what’s trending and released today.<br> Discover fresh music</p>

			      <!-- Read more button -->
			      <a class="btn btn-pink btn-md mb-lg-0 mb-4" href="/new">Discover</a>
			
			    </div>
			    <!-- Grid column -->
			
			    <!-- Grid column -->
			    <div class="col-lg-5">
			
			      <!-- Featured image -->
			      <div class="view overlay rounded z-depth-2">
			        <img class="img-fluid" src="/resources/img/cover2.png" alt="Sample image">
			        <a>
			          <div class="mask rgba-white-slight"></div>
			        </a>
			      </div>
			
			    </div>
			    <!-- Grid column -->
			
			  </div>
			  <!-- Grid row -->
			
			  <hr class="my-5">
			
			  <!-- Grid row -->
			  <div class="row">
			
			    <!-- Grid column -->
			    <div class="col-lg-5">
			
			      <!-- Featured image -->
			      <div class="view overlay rounded z-depth-2 mb-lg-0 mb-4">
			        <img class="img-fluid" src="/resources/img/cover3.png" alt="Sample image">
			        <a>
			          <div class="mask rgba-white-slight"></div>
			        </a>
			      </div>
			
			    </div>
			    <!-- Grid column -->
			
			    <!-- Grid column -->
			    <div class="col-lg-7">
			
			      <!-- Category -->
			      <a href="#!" class="indigo-text">
			        <h6 class="font-weight-bold mb-3"><i class="fa fa-star pr-2"></i>Collection</h6>
			      </a>
			      <!-- Post title -->
			      <h3 class="font-weight-bold mb-3"><strong>Collections of Your favorite</strong></h3>
			      <!-- Excerpt -->
			      <p>Give stars to your favorite and Make your own playlists in Stealer.</p>
			      <!-- Read more button -->
			      <a class="btn btn-indigo btn-md" href="/collection">See More</a>
			
			    </div>
			    <!-- Grid column -->
			
			  </div>
			  <!-- Grid row -->
			
			</section>
			<!-- Section: Blog v.1 -->
		</div>
		</div>
	</c:otherwise>
</c:choose>


<%@include file="includes/footer.jsp" %>
<script>
$(function() {
	new WOW().init();
})
</script>