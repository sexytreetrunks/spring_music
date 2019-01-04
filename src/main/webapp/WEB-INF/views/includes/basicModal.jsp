	<!-- Modal -->
	<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel"></h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        ${error }
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="confirm-no">Close</button>
	        <button type="button" class="btn btn-cyan" style="display:none" id="confirm-yes">Yes</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->
	
<script>
var modalConfirm = function(callback){
	$("#confirm-yes").on("click",function(){
		callback(true);
	});
	$("#confirm-no").on("click",function(){
		callback(false);
	});
};
</script>