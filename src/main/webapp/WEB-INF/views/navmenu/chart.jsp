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
</style>
<div class="d-flex justify-content-center" style="padding-top:40px">
	<section>
		<h2 class="my-5 text-center white-text display-1">Top 100 Chart!</h2>
		<ul>
			<c:forEach var="song" items="${list}" varStatus="status">
				<li class="m-4">
					<div class="container">
						<div class="row py-2">
							<div class="col-1 align-self-center text-center">
								<h1><strong>${status.count}</strong></h1>
							</div>
							<div class="col-2 align-self-center">
								<img src="/cover?filename=${song.uuid}_${song.artist}_${song.title}" class="img-fluid">
							</div>
							<div class="col pl-4">
								<div class="row pt-2">
									<h2> ${song.title} </h2>
								</div>
								<div class="row">	
									<h6>${song.artist}</h6>
								</div>
							</div>
							<div class="col-2 align-self-center text-center pr-2">
								<a><i class="fas fa-play fa-lg"></i></a>
							</div>
						</div>
					</div>
				</li>			
			</c:forEach>
		</ul>
	</section>
</div>
<%@include file="../includes/footer.jsp" %>