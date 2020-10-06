$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	
	var codigoVenda = button.data('codigo');
	var descricaoVenda = button.data('descricao');
	
	var modal = $(this);
	
	var form = modal.find('form');
	
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action += '/';
	
	}

	form.attr('action', action + codigoVenda);
	modal.find('.modal-body span').html('Tem certeza que deseja apagar o registro <strong>'+ descricaoVenda+'</strong>');
	
});