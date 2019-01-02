var playlistManager = {
		get:function(callback) {
			$.getJSON('/playlist/all', callback);
		},
		addto:function(payload, callback){
			$.ajax({
				type:'post',
				url:'/playlist/new',
				data:JSON.stringify(payload),
				datatype:'json',
				contentType:"application/json;charset=utf-8",
				success:callback
			});
		}
}