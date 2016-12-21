$(document).ready(function($) {
	var pageParam = {};
	$("#pick").on('click', function(event) {
		event.preventDefault();
		/* Act on the event */
		$.get('/pick', function(data) {
			if(data){
				var task = $("#task");
				pageParam.taskData = data;
				console.log(pageParam);
				task.val(data.name);
				task.show(400);
				task.hover(function() {
					task.addClass('btn-success').removeClass('btn-danger');
				}, function() {
					task.addClass('btn-danger').removeClass('btn-success')
				});
			}
		});
	});
	$("#task").on('click', function(event) {
		event.preventDefault();
		var taskId = getId();
		if(taskId==null){
			return;
		}else{
			location.href = '/task/'+taskId;
		}

		/* Act on the event */
	});
	var getId = function(){
		if(pageParam.taskData.id){
			return pageParam.taskData.id;
		}else{
			return null;
		}
	}
});