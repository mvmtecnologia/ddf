<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="includes/header.jsp" />
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
</head>
<body>
	<!-- Fixed navbar -->
	<jsp:include page="includes/navbarsemlogin.jsp" />


	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-9">
					
			</div>
			<div class="col-md-3">
				<img alt="forma de exibição" src="resources/img/lista.jpg" width="22" height="22">
				<img alt="forma de exibição" src="resources/img/grade.jpg" width="22" height="22">
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="row">
					<span class="titleFiltro">Preço</span>
					<div id="slider"></div>
				</div>
				<div class="row">
					<span class="titleFiltro">Forma</span>
				</div>
				<div class="row">
					<span class="titleFiltro">Dosagem</span>
				</div>
				<div class="row">
					<span class="titleFiltro">Laboratório</span>
				</div>
			</div>
			<div class="col-md-8">
				<c:forEach items="${remedioList}" var="remedio">
					<div class="row linhaRemedio" style="padding-top: 6px;">
						<div class="col-md-2" style="text-align: center;">
							<img alt="remedio" src="resources/img/remedio_trans.png" width="70" height="70">
						</div>
						<div class="col-md-7">
							<span style="font-size: 22px">${remedio.nomeCompleto} ${remedio.dosagem} ${remedio.forma}</span><br>
							Laboratório: ${remedio.nomeFabricante}
						</div>
						<div class="col-md-3">
							<span style="font-size: 21px">Valor: R$ <fmt:formatNumber type="number" minFractionDigits="2" 
            					maxFractionDigits="2" value="${remedio.preco}" /></span>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

	<jsp:include page="includes/footer.jsp" />
	
	<script type="text/javascript">
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
	</script>
</body>
</html>