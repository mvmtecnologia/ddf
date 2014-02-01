<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Dica de Farmácia</title>
	</head>
	<body>
		<form:form action="${pageContext.request.contextPath}/farmacia/updateFarmacia" method="post" commandName="editFarmacia">
			<form:input path="id" cssStyle="width: 100%; display: none;" />
			
			<span><spring:message code="label.farmacia.nome" /></span>
			<form:input path="nome" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.farmacia.telefone" /></span>
			<form:input path="telefone1" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.farmacia.telefone.adicional" /></span>
			<form:input path="telefone2" cssStyle="width: 100%" />
			
			<span><spring:message code="label.endereco.logradouro" /></span>
			<form:input path="logradouro" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.endereco.numero" /></span>
			<form:input path="numero" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.endereco.complemento" /></span>
			<form:input path="complemento" cssStyle="width: 100%" />
			
			<span><spring:message code="label.endereco.cep" /></span>
			<form:input path="cep" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.endereco.bairro" /></span>
			<form:input path="bairro" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.endereco.cidade" /></span>
			<form:input path="cidade" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.endereco.estado" /></span>
			<form:input path="estado" cssStyle="width: 100%" cssClass="required" />
			
			<span><spring:message code="label.endereco.pais" /></span>
			<form:input path="pais" cssStyle="width: 100%" cssClass="required" />
			
			
			<input type="submit" value="<spring:message code="label.addFarmacia"/>">
			
		</form:form>
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>