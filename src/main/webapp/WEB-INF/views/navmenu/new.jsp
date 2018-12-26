<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>
<style>
ul {
	list-style:none;
}
section > ul > li {
	background-color:white;
	border-radius:3px;
}
.card {
	background-color: rgba(0,0,0,.4)
}
</style>
<div class="d-flex justify-content-center" style="padding-top:40px">
	<section>
		<h2 class="my-5 text-center white-text display-1">Explore New Song!</h2>
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-sm-6 my-4">
					<div class="card">

					  <!-- Card image -->
					  <img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/images/43.jpg" alt="Card image cap">
					  <!-- Card content -->
					  <div class="card-body text-center white-text">
					
					    <!-- Title -->
					    <h4 class="card-title"><a>Title</a></h4>
					    <!-- Text -->
					    <a> artist </a>
					  </div>
					
					</div>
				</div>
				
			</div>
		</div>
	</section>
</div>
<%@include file="../includes/footer.jsp" %>