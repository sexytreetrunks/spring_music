<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

<div class="container justify-content-center" style="padding-top:40px">
<section>
	<h2 class="my-5 text-center white-text display-1">My Collection</h2>
	<div class="container">
		<div class="row">
			<c:forEach var="pl" items="${list}">
				<div class="col-lg-3 col-sm-4 my-4">
					<div class="view overlay">
						<img class="card-img-top img-round" src="/cover?filename=${pl.cover}" onerror="this.src='/resources/img/noimage.png'">
						<div class="mask flex-center rgba-stylish-strong">
							<a><i class="fas fa-play fa-4x white-text"></i></a>
						</div>
					</div>
					<!-- Card content -->
					<p class="text-center mt-2 white-text"><a href="/plsongs/${pl.id}">${pl.title}</a></p>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<input type="hidden" name="result" value="${param.result}">
</div>
<%@include file="../includes/footer.jsp" %>
<%@include file="../includes/successModal.jsp" %>
<script>
$(function(){
	var result = $("input[name='result']").val();
	if(result ==='success') {
		$("#successModal").find(".modal-body").html("플레이리스트가 삭제되었습니다");
		$("#successModal").modal("show");
	}
})

</script>