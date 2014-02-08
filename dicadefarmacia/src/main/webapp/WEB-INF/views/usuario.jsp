<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt-br">
<jsp:include page="./includes/metahead.jsp" />
</head>
<body>
	<!-- HEADER  -->
	<jsp:include page="./includes/header.jsp" />
	<!-- END HEADER -->

	<section id="home">
		<div class="container">
			<h3>Cadastro de Usuário</h3>
			<div class="row">
				<div class="span6">
					<form:form method="post" action="add.html" commandName="usuario">
						<span><spring:message code="label.email" /></span>
						<input type="email" name="email" required="required" />

						<spring:message code="label.nome" />
						<input type="text" name="nome" required="required" />

						<span><spring:message code="label.cpf" /></span>
						<input type="text" name="cpf" required="required" />
						<input type="submit"
							value="<spring:message code="label.addcontact"/>">
					</form:form>
				</div>
			</div>

			<div class="row">
				<div class="span12">
					<h3>Contacts</h3>
					<c:if test="${!empty usuarioList}">
						<table class="data">
							<tr>
								<th>Email</th>
								<th>Name</th>
								<th>CPF</th>
								<th>&nbsp;</th>
							</tr>
							<c:forEach items="${usuario}" var="usuario">
								<tr>
									<td>${usuario.email}</td>
									<td>${usuario.nome}</td>
									<td>${usuario.cpf}</td>
									<td><a href="delete/${usuario.id}">delete</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</section>

</body>
<!-- FOOTER  -->
<jsp:include page="./includes/footer.jsp" />
<!-- END FOOTER -->
</html>