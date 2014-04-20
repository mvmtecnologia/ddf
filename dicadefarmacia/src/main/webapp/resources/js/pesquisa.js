$(document).ready(function() {
	var valorMaximo = $('#valorMaximo').val();
	$('#slider').slider({
		range: true,
  		min: 0,
  		max: valorMaximo,
        values: [0, valorMaximo],
        slide: function( event, ui ) {
        	$( "#amount" ).val( "R$ " + ui.values[ 0 ] + " - R$ " + ui.values[ 1 ] );
        }
	});
	$( "#amount" ).val( "R$ " + $( "#slider" ).slider( "values", 0 ) + " - R$ " + $( "#slider" ).slider( "values", 1 ) );
	
	var limpaSelecionado = function() {
		$('.linhaRemedio').each(function(index){
			$(this).css("background-color", "");
			$(this).css("-webkit-border-radius", "0px");
			$(this).css("-moz-border-radius", "0px");
			$(this).css("border-radius", "0px");
			
		});
	};
	$('.linhaRemedio').click(function() {
		limpaSelecionado();
		$(this).css("background-color", "aquamarine");
		$(this).css("-webkit-border-radius", "7px");
		$(this).css("-moz-border-radius", "7px");
		$(this).css("border-radius", "7px");
	});
});


function filtraForma(forma) {
	
	if ($('#'+ forma).is(':checked')) {
		var searchString = window.location.search.substring(1);
		
		$('#divResultado').load('filtro?' + searchString + '&forma=' + forma + ' #divResultado');
	} else {
		console.log(forma + ' deschecked');
	}
}