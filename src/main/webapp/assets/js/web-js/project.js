$(function() {
	$('#btn-project-edit').click(function() {
		var id = $(this).data("id");
		var link = $('#formProject').attr('action');
		$.ajax({
			url: link,
			type: 'GET',
			dataType: 'JSON',
			data: {
				id: id,
				action: 'edit',
			},
			success: function(res) {
				$("#name").val(res.name);
				$("#description").val(res.description);
				$("#start_date").val(res.start_date);
				$("#end_date").val(res.end_date);
				$("#end_date").val(res.end_date);
				$("#owner").val(res.owner);
			}, 
			error: function(error) {
				showToastr('error', error);
			}
		})
	})
});