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
			<div class="col-md-3" style="display: none;">
				<img alt="forma de exibição" src="resources/img/lista.jpg" width="22" height="22">
				<img alt="forma de exibição" src="resources/img/grade.jpg" width="22" height="22">
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="row">
					<span class="titleFiltro">Preço</span>
					<br>
					<input type="text" id="amount" style="border:0; color:#f6931f; font-weight:bold;" class="margemFiltro">
					<div id="slider" style="width: 70%; margin-left: 20px;"></div>
					<input id="valorMaximo" value="${valorFinal}" hidden="true" />
					<br>
				</div>
				<div class="row">
					<span class="titleFiltro">Forma:</span>
					<c:forEach items="${listaForma}" var="forma">
						<div class="row margemFiltro">
							<input type="checkbox" id="${forma}" onclick="filtraForma('${forma}')" /> ${forma}
						</div>
					</c:forEach>
					<br>
				</div>
				<div class="row">
					<span class="titleFiltro">Dosagem</span>
					<c:forEach items="${listaDosagem}" var="dosagem">
						<div class="row margemFiltro">
							<input type="checkbox" id="${dosagem}" /> ${dosagem}
						</div>
					</c:forEach>
					<br>
				</div>
				<div class="row">
					<span class="titleFiltro">Laboratório</span>
					<c:forEach items="${listaLaboratorio}" var="laboratorio">
						<div class="row margemFiltro">
							<input type="checkbox" id="${laboratorio}" /> ${laboratorio}
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-8">
				<div id="divResultado">
				<c:forEach items="${remedioList}" var="remedio">
					<div class="row linhaRemedio" style="padding-top: 6px; cursor: pointer;">
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
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

	<jsp:include page="includes/footer.jsp" />
	<script src="resources/js/pesquisa.js"></script>
	
	<script type="text/javascript">		
		
		
	</script>
</body>
</html>