<!doctype html>
<html lang="pt-br">
<jsp:include page="./includes/metahead.jsp" />
</head>
<body
	<!-- HEADER  -->
	<jsp:include page="./includes/header.jsp" />
	<!-- END HEADER -->

	<!-- HEADER HOME  -->
	<section id="home">
		<div class="container">
			<div class="row centered">
				<h2>Dica de Farmácia</h2>
			</div>
			<div class="row centered">
				<div class="span3"></div>
				<div class="span6">
					<form id="pesquisarForm" name="pesquisarForm" action="/s"
						method="post">
						<input id="palavraChavePesquisa" name="nome" type="text" />
						<button id="pesquisar" name="pesquisar" type="submit"
							class="button">Pesquisar</button>
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
