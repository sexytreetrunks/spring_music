<style>
/* https://stackoverflow.com/questions/47451929/need-bootstrap-navbar-items-to-fill-entire-row-horizontally  */
.nav-tabs {
	border-bottom:none;
	width:100%;
	display: -ms-flexbox;
	display: flex;
}
.nav-tabs .nav-item {
	-ms-flex: 1 0 auto;
	flex: 1 0 auto;
	text-align: center;
}
.playlist-img {
	cursor:pointer;
}
</style>
<!-- Modal -->
<div class="modal fade" id="playlistModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
         	<ul class="nav nav-tabs nav-pills pills-pink" id="myTab" role="tablist">
			  <li class="nav-item">
			    <a class="nav-link active" id="addto-tab" data-toggle="tab" href="#addto" role="tab" aria-controls="addto" aria-selected="true">Add to</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="create-tab" data-toggle="tab" href="#create" role="tab" aria-controls="create" >Create</a>
			  </li>
			</ul>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<div class="tab-content" id="myTabContent">
		  <div class="tab-pane fade show active" id="addto" role="tabpanel" aria-labelledby="addto-tab">
		  <!-- ajax로 playlist 가져오기 없으면 플레이리스트가 없습니다라고 뜨게 하기 -->
			  <div class="row">
			  		<!-- 클릭한곳 image overlay -->
					<div class="col-4 my-2">
						<img class="card-img-top playlist-img" src="/resources/img/noimage.png" >
						<p class="text-center mt-2">playlist name1</p>
					</div>
					<div class="col-4 my-2">
						<img class="card-img-top playlist-img" src="/resources/img/noimage.png" >
						<p class="text-center mt-2">playlist name2</p>
					</div>
					<div class="col-4 my-2">
						<img class="card-img-top playlist-img" src="/resources/img/noimage.png" >
						<p class="text-center mt-2">playlist name3</p>
					</div>
					<div class="col-4 my-2">
						<img class="card-img-top playlist-img" src="/resources/img/noimage.png" >
						<p class="text-center mt-2">playlist name4</p>
					</div>
					<div class="col-4 my-2">
						<img class="card-img-top playlist-img" src="/resources/img/noimage.png" >
						<p class="text-center mt-2">playlist name5</p>
					</div>
					<div class="col-4 my-2">
						<img class="card-img-top playlist-img" src="/resources/img/noimage.png" >
						<p class="text-center mt-2">playlist name6</p>
					</div>
				</div>
		  </div>
		  <div class="tab-pane fade" id="create" role="tabpanel" aria-labelledby="create-tab">
			<div class="form-group">
			    <label for="newplaylist">Create New Playlist</label>
			    <input type="text" class="form-control" name="newplaylist" placeholder="Playlist Name">
			</div>
			<div class="modal-footer">
        	<button type="button" class="btn btn-outline-warning" data-dismiss="modal">Close</button>
        	<button type="button" class="btn btn-primary" id="savePlaylist">Save</button>
     		</div>
		  </div>
		 </div>
		</div>
      </div>
    </div>
</div>
