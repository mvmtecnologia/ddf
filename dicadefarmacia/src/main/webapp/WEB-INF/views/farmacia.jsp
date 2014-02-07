<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Dica de Farmácia</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="resources/css/application.css" rel="stylesheet">
	</head>
	<body>

		<h2>Cadastrar Farmácia</h2>
		<form:form method="post" action="farmacia/add.html" commandName="farmacia">
			
			<span><spring:message code="label.farmacia.nome" /></span>
			<input type="text" name="nome" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.farmacia.telefone" /></span>
			<input type="tel" name="telefone1" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.farmacia.telefone.adicional" /></span>
			<input type="tel" name="telefone2" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.logradouro" /></span>
			<input type="text" name="logradouro" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.numero" /></span>
			<input type="number" name="numero" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.complemento" /></span>
			<input type="text" name="complemento" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.cep" /></span>
			<input type="text" name="cep" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.bairro" /></span>
			<input type="text" name="bairro" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.cidade" /></span>
			<input type="text" name="cidade" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.estado" /></span>
			<input type="text" name="estado" required="required" style="width: 100%"/>
			
			<span><spring:message code="label.endereco.pais" /></span>
			<input type="text" name="pais" required="required" style="width: 100%"/>
				
		
			<div class="row">
				<div class="col-md-6"><span><spring:message code="label.farmacia.nome" /></span></div>
				<div class="col-md-6"><span><spring:message code="label.farmacia.telefone" /></span></div>
			</div>
			<div class="row">
				<div class="col-md-6"><input type="text" name="nome" required="required" style="width: 100%"/></div>
				<div class="col-md-6"><input type="tel" name="telefone1" required="required" style="width: 100%"/></div>
			</div>
			
			<div class="table-responsive">
				<table class="table">
					<tr>
						<td><span><spring:message code="label.farmacia.nome" /></span></td>
						<td><input type="text" name="nome" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.farmacia.telefone" /></span></td>
						<td><input type="tel" name="telefone1" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.farmacia.telefone.adicional" /></span></td>
						<td><input type="tel" name="telefone2"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.logradouro" /></span></td>
						<td><input type="text" name="logradouro" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.numero" /></span></td>
						<td><input type="number" name="numero"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.complemento" /></span></td>
						<td><input type="text" name="complemento"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.cep" /></span></td>
						<td><input type="text" name="cep" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.bairro" /></span></td>
						<td><input type="text" name="bairro" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.cidade" /></span></td>
						<td><input type="text" name="cidade" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.estado" /></span></td>
						<td><input type="text" name="estado" required="required"/></td>
					</tr>
					<tr>
						<td><span><spring:message code="label.endereco.pais" /></span></td>
						<td><input type="text" name="pais" required="required"/></td>
					</tr>
				
				</table>
			</div>
			<div>
				<input type="submit" value="<spring:message code="label.addFarmacia"/>">
			</div>
			
			
		</form:form>
	
	
		<h3>Lista de Farmácias</h3>
		<c:if test="${!empty farmaciaLista}">
			<table class="data">
				<tr>
					<th>Email</th>
					<th>Name</th>
					<th>CPF</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach items="${farmaciaLista}" var="farma">
					<tr>
						<td>${farma.nome}</td>
						<td>${farma.telefone1}</td>
						<td>${farma.bairro}</td>
						<td><a href="/farmacia/delete/${farma.id}">delete</a></td>
						<td><a href="${pageContext.request.contextPath}/farmacia/edit/${farma.id}">editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
	</body>
</html>