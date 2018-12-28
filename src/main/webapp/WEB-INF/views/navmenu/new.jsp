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
				<c:forEach var="song" items="${list}">
				<div class="col-lg-4 col-sm-6 my-4">
					<div class="card">
					  <!-- Card image -->
					  <a><img class="card-img-top" src="/cover?filename=${song.uuid}_${song.artist}_${song.title}"></a>
					  <!-- Card content -->
					  <div class="card-body text-center white-text">
					    <!-- Title -->
					    <h4 class="card-title"><a>${song.title}</a></h4>
					    <!-- Text -->
					    <a> ${song.artist} </a>
					  </div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>
</div>
<%@include file="../includes/footer.jsp" %>