$('#delete').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoLeitor = button.data('codigo');
	var nomeLeitor = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoLeitor );
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir <strong>' + nomeLeitor + '</strong>?');
});