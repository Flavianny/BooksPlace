$('#meuModal').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	
	var id = button.data('codigo');
	
	var modal = $(this);
	
	var form = modal.find('form');
	
	var action = form.attr('action');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action + id);
});