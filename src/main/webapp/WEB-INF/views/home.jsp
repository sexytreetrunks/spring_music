<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<!-- Start your project here-->
<!--   <div style="height: 100vh">
    <div class="flex-center flex-column">

      <h1 class="text-hide animated fadeIn mb-4" style="background-image: url('https://mdbootstrap.com/img/logo/mdb-transparent-250px.png'); width: 250px; height: 90px;">MDBootstrap</h1>
      <h5 class="animated fadeIn mb-3">Thank you for using our product. We're glad you're with us.</h5>

      <p class="animated fadeIn text-muted">MDB Team</p>
    </div>
  </div> -->
<!-- Full Page Intro -->
<div class="view" style="height:100vh">
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

<%@include file="includes/footer.jsp" %>
<script>
$(function() {
	new WOW().init();
})
</script>