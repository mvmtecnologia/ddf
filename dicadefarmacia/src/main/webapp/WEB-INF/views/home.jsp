<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="pt-br">
<jsp:include page="./includes/metahead.jsp" />
</head>
<body>
	<!-- HEADER  -->
	<jsp:include page="./includes/header.jsp" />
	<!-- END HEADER -->

	<!-- HEADER HOME  -->
	<section id="home">
		<div class="container">
			<div class="row centered">
				<h2 id="titulo"><spring:message code="home.h2.titulo.label" /></h2>
			</div>
			<div class="row centered">
				<div class="span3"></div>
				<div class="span6">
					<form id="pesquisarForm" name="pesquisarForm" action="/s"
						method="post">
						<input id="palavraChavePesquisa" name="nome" type="text" placeholder=<spring:message code="home.input.palavrachavepesquisa.placeholder" /> />
						<button id="pesquisar" name="pesquisar" type="submit"
							class="button"><spring:message code="home.button.pesquisar.label" /></button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- END HEADER HOME  -->

	<!-- FOOTER  -->
	<jsp:include page="./includes/footer.jsp" />
	<!-- END FOOTER -->
</body>
</html>
