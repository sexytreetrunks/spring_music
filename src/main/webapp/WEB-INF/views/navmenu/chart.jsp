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
div > i {
	cursor:pointer;
}
</style>
<div class="d-flex justify-content-center" style="padding-top:40px">
	<section>
		<h2 class="my-5 text-center white-text display-1">Top 100 Chart!</h2>
		<ul>
			<c:forEach var="song" items="${list}" varStatus="status">
				<li class="m-4" id="${song.uuid}">
					<div class="container">
						<div class="row py-2">
							<div class="col-1 align-self-center text-center">
								<h1><strong>${status.count + cri.pageStart}</strong></h1>
							</div>
							<div class="col-2 align-self-center">
								<img src="/cover?filename=${song.uuid}_${song.artist}_${song.title}" class="img-fluid" alt="coverimg">
							</div>
							<div class="col pl-4">
								<div class="row pt-2">
									<h2> ${song.title} </h2>
								</div>
								<div class="row">	
									<h6>${song.artist}</h6>
								</div>
							</div>
							<div class="col-3 align-self-center text-center pr-2">
								<i class="fas fa-play fa-lg pr-5"></i>
								<i class="fas fa-plus fa-lg addPlaylist"></i>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</div>
<%@include file="../includes/playlistModal.jsp" %>
<%@include file="../includes/successModal.jsp" %>
<%@include file="../includes/footer.jsp" %>
<script src="/resources/js/playlistManager.js"></script>
<script>
var songid;
var cover;
$(function(){
	$(".addPlaylist").click(function(e){
		songid = $(e.target).closest("li").attr("id");
		playlistManager.get(function(result){
			if(result.length > 0) {
				var html = "";
				for(var pl of result) {
					html+=showPlaylist(pl);
				}
				$("#addto > div").html(html);				
			}
		});
		$("#playlistModal").modal('show');
	})
	$("#playlistModal").on('hidden.bs.modal',function(){
		$("input[name='newplaylist']").val("");
	})
	$("#savePlaylist").click(function(){
		var title = $("input[name='newplaylist']").val();
		cover = $("#"+songid).find("img[alt='coverimg']").attr('src');
		var idx = cover.indexOf("=");
  		var payload = {
				"hasplaylist":false,
				"title":title,
				"songid":songid,
				"cover":cover.substring(idx+1)
		};
		playlistManager.addto(payload,function(result){
			$("#playlistModal").modal('hide');
			if(result > 0) {
				$("#successModal").find(".modal-body").html('플레이리스트에 곡이 추가되었습니다');
				$("#successModal").modal('show');
			}
		});  
	})
})

function showPlaylist(pl) {
	return "<div class='col-4 my-2'>"
			+"<img class='card-img-top playlist-img' onclick='onClickPlaylist(this)' src='/cover?filename=" +pl.cover+"' onerror=\"src=\'/resources/img/noimage.png\'\"'>"
			+"<input type='hidden' name='playlistid' value='" + pl.id + "'/>"
			+"<p class='text-center mt-2'>" + pl.title + "</p>"
			+"</div>";
}
function onClickPlaylist(e) {
	var playlistid = $(e).next().val();
	var payload = {
			"hasplaylist":true,
			"playlistid":playlistid,
			"songid":songid
	};
	playlistManager.addto(payload,function(result){
		console.log(result);
		$("#playlistModal").modal('hide');
		if(result > 0) {
			$("#successModal").find(".modal-body").html('플레이리스트에 곡이 추가되었습니다');
			$("#successModal").modal('show');
		}
	});
}

</script> 