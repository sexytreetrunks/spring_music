<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>
<div class="d-flex justify-content-center" style="padding-top:40px">
	<div class="container col-lg-10" style="background-color:rgba(255,255,255,0.95)">
		<section class="my-5">
			<h2 class="my-4 text-center cyan-text">Upload Your Favorite Song!</h2>
			<form enctype="multipart/form-data" method="post">
				<div>
				    <label for="songfile" class="w-100">
					    <span id="song-upload" class="btn btn-light btn-lg btn-block">Click to upload Song</span>
				    </label>
				    <input id="songfile" type="file" name="songfile" style="display:none" accept=".mp3" required/>
				</div>
				<div class="container my-4">
					<div class="row">
						<div class="col-lg-4 text-center">
							<label for="coverfile" class="w-100">
							    <img class="img-fluid" src="/resources/img/noimage.png" style="height:250px; width:250px; background-color:#f5f5f5">
						    </label>
						    <input id="coverfile" type="file" name="cover" style="display:none" accept="image/*"/>
						</div>
						<div class="col-lg-8">
							<div class="form-group">
								<label for="title">
									<span class="small text-left">Title <span class="red-text">*</span></span>
								</label> 
								<input type="text" class="form-control" id="title" name="title" required>
							</div>
							<div class="form-group">
								<label for="artist">
									<span class="small text-left">Artist <span class="red-text">*</span></span>
								</label> 
								<input type="text" class="form-control mr-md-2" id="artist" name="artist" required>
							</div>
							<div class="form-group">
								<label for="tags">
									<span class="small text-left">Tags</span>
								</label> 
								<input type="text" class="form-control" id="tags" name="tags" placeholder="#hashtag">
							</div>
						</div>
					</div>
				</div>
				<input type="hidden" name="length">
				<div class="container mt-4 mb-0 text-right">
					<button type="reset" class="btn btn-outline-warning">Cancel</button>
					<button type="submit" class="btn btn-cyan">Upload</button>
				</div>
			</form>
		</section>
	</div>
</div>
<%@include file="../includes/basicModal.jsp"%>
<%@include file="../includes/footer.jsp" %>
<script>
$(function(){
	var audio = new Audio()
	audio.addEventListener('loadedmetadata',function(){
		$("input[name='length']").val(formatTime(audio.duration))
	})
	
	$("#songfile").change(function(e){
		$("#song-upload").removeClass("btn-light")
		$("#song-upload").addClass("btn-cyan")
		$("#song-upload").html("Click to change")
		var uploadfile = e.target.files[0]
		var idx = uploadfile.name.lastIndexOf(".")
		$("#title").val(uploadfile.name.substring(0,idx))
		var objurl = URL.createObjectURL(uploadfile)
		audio.src = objurl
	})
	
	$("#coverfile").change(function(){
		var fileList = this.files
		var reader = new FileReader()
		reader.readAsDataURL(fileList[0])
		reader.onload = function(e){
			$("#coverfile").prev().find("img").attr("src",e.target.result)
		}
	})
	$("button[type='submit']").click(function(e){
		e.preventDefault()
		if($("#songfile").val()=="") {
			$(".modal-title").html('양식 미완성')
			$(".modal-body").html('업로드할 음악이 없습니다')
			$("#errorModal").modal('show')
			return
		}
		$("form").submit()
	})
})
function formatTime(duration) {
	var totalsec = parseInt(duration)
	var mm = Math.floor(totalsec/60)
	var ss = (totalsec%60)
	return (mm==0? '00': mm)+":"+(ss==0? '00': (ss<10? '0'+ss:ss))
}	
</script>