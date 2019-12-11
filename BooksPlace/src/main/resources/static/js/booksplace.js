$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoLeitor = button.data('codigo');
	var nomeLeitor = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoLeitor);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + nomeLeitor + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
	
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
	
	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();
		
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
			
		});
		
		response.done(function(e) {
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">' + e + '</span>');
			botaoReceber.hide();
			
		});
		
		response.fail(function(e) {
			console.log(e);
			alert('Erro ao receber cobrança');
			
		});
		
		
		
	});
	
});

$('#meuModall').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	
	var codigo = button.data('codigo');
	
	var modal = $(this);
	
	var form = modal.find('form');
	
	var action = form.attr('action');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action + codigo);
});

$('#meuModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoLivro = button.data('codigo');
	var tituloLivro = button.data('titulo');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoLivro);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir <strong>' + tituloLivro + '</strong>?');
});
