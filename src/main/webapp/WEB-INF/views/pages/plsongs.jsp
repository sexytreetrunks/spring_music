<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

<div class="container-fluid justify-content-center container-main">
<div class="container col-lg-9 bg-white">
<section>
	<div class="d-flex justify-content-center my-5">
		<div>
			<img src="/cover?filename=${pl.cover}" onerror="this.src='/resources/img/noimage.png'" class="rounded-circle img-fluid" width="250" height="250">
			<h4 class="text-center mt-4"> ${pl.title } </h4>
			<div class="text-center">
				<button class="btn btn-info btn-pill btn-sm">Play All</button> <button class="btn btn-outline-danger btn-pill btn-sm" id="deletePlaylist">delete</button>	
			</div>
		</div>	
	</div>
	<ul class="list-group list-group-flush">
		<c:forEach var="song" items="${list}">
			<li class="list-group-item">
				<div class="row">
					<div class="col-1 align-self-center text-center">
						<a><i class="fas fa-play fa-lg pr-5"></i></a>
					</div>
					<div class="col pl-4">
						<div class="row pt-2">
							<h3>${song.title}</h3>
						</div>
						<div class="row">
							<h6>${song.artist}</h6>
						</div>
					</div>
					<div class="col-2 align-self-center text-center pr-2">
						<i class="fas fa-trash-alt fa-lg clickable" id="${song.uuid}"></i><!-- click시 ajax로 playlist에있는 곡 삭제 -->
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</section>
</div>
</div>
<%@include file="../includes/footer.jsp" %>
<script src="/resources/js/playlistManager.js"></script>
<%@include file="../includes/successModal.jsp" %>
<%@include file="../includes/basicModal.jsp" %>
<script>
$(function(){
	var playlistId = ${pl.id};
	
	$(".fa-trash-alt").click(function(){
		var parant = $(this).closest("li");
		var songId = $(this).attr('id');
		playlistManager.removeOne(playlistId,songId,function(result){
			console.log(result);
			if(result > 0) {
				parant.remove();
				$("#successModal").find(".modal-body").html('플레이리스트에서 곡이 삭제되었습니다');
				$("#successModal").modal('show');
			}
		});
	})
	
	$("#deletePlaylist").click(function(){
		$("#errorModal").find(".modal-title").html("삭제 확인");
		$("#errorModal").find(".modal-body").html("플레이리스트를 삭제하시겠습니까?");
		$("#errorModal").find("#confirm-no").html("NO");
		$("#errorModal").find("#confirm-yes").show();
		$("#errorModal").modal('show');
	})
	
	modalConfirm(function(choice){
		if(choice) {
			playlistManager.removeAll(playlistId, function(result){
				console.log(result);
				if(result > 0) {
					window.location.href="/collection?result=success";
				}
			});
		} else {
			$("#basicModal").modal('hide');
		}
	})
})

</script>
