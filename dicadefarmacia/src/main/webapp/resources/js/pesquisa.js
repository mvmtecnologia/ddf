var valorMaximo = $('#valorMaximo').val();
var valorMinimo = 0;

$(document).ready(function() {
	$('#slider').slider({
		range: true,
  		min: valorMinimo,
  		max: valorMaximo,
        values: [0, valorMaximo],
        slide: function( event, ui ) {
        	$('#amount').val('R$' + ui.values[ 0 ] + ' - R$ ' + ui.values[ 1 ]);
        },
        stop: function(event, ui) {
        	valorMinimo = ui.values[0];
        	valorMaximo = ui.values[1];
        	filtra();
        }
	});
	$('#amount').val('R$ ' + $('#slider').slider('values', 0) + ' - R$ ' + $('#slider').slider('values', 1));
	
});

limpaSelecionado = function() {
	$('.linhaRemedio').each(function(index){
		$(this).css("background-color", "");
		$(this).css("-webkit-border-radius", "0px");
		$(this).css("-moz-border-radius", "0px");
		$(this).css("border-radius", "0px");
		
	});
};

function seleciona(elem) {
	limpaSelecionado();
	$(elem).css("background-color", "aquamarine");
	$(elem).css("-webkit-border-radius", "7px");
	$(elem).css("-moz-border-radius", "7px");
	$(elem).css("border-radius", "7px");
}


function filtra() {
	var formaStr = '';
	var dosagemStr = '';
	var laboratorioStr = '';
	
	$('.forma').each(function() {
		if ($(this).is(':checked')) {
			formaStr += $(this).attr('id') + ',';
		}
	});
	$('.dosagem').each(function() {
		if ($(this).is(':checked')) {
			dosagemStr += $(this).attr('id') + ',';
		}
	});
	$('.laboratorio').each(function() {
		if ($(this).is(':checked')) {
			laboratorioStr += $(this).attr('id') + ',';
		}
	});
	
	formaStr = formaStr.substring(0, formaStr.length - 1);
	formaStr = replaceAll(' ', '+', formaStr);
	dosagemStr = dosagemStr.substring(0, dosagemStr.length - 1);
	dosagemStr = replaceAll(' ', '+', dosagemStr);
	laboratorioStr = laboratorioStr.substring(0, laboratorioStr.length - 1);
	laboratorioStr = replaceAll(' ', '+', laboratorioStr);
	
	var searchString = window.location.search.substring(1);
	
	$('#divResultado').load('filtro?' + searchString + '&forma=' + formaStr + '&dosagem=' + dosagemStr + 
			'&laboratorio=' + laboratorioStr + '&valorMinimo=' + valorMinimo + 
			'&valorMaximo=' + valorMaximo + ' #divResultado');
}

function replaceAll(find, replace, str) {
	return str.replace(new RegExp(find, 'g'), replace);
}