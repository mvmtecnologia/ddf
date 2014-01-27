<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Dica de Farmácia</title>
</head>
<body>

	<h2>Cadastro de Usuário</h2>
	<a href="client">Usuário</a>
	<form:form method="post" action="add.html" commandName="contact">
		<div style="float: left; width: 10%">
			<span><spring:message code="label.email" /></span><br /> <span><spring:message
					code="label.nome" /></span><br /> <span><spring:message
					code="label.cpf" /></span>
		</div>
		<div style="float: right; width: 90%">
			<input type="email" name="email" required="required" /><br /> <input
				type="text" name="nome" required="required" /><br /> <input
				type="text" name="cpf" required="required" />
		</div>
		<br />
		<br />
		<div>
			<input type="submit"
				value="<spring:message code="label.addcontact"/>">
		</div>

		<!-- 
			<table>
				<tr>
					<td><form:label path="email">
							<spring:message code="label.email" />
						</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="nome">
							<spring:message code="label.nome" />
						</form:label></td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td><form:label path="cpf">
							<spring:message code="label.cpf" />
						</form:label></td>
					<td><form:input path="cpf" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="<spring:message code="label.addcontact"/>" /></td>
				</tr>
			</table>
			 -->
	</form:form>


	<h3>Contacts</h3>
	<c:if test="${!empty contactList}">
		<table class="data">
			<tr>
				<th>Email</th>
				<th>Name</th>
				<th>CPF</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.email}</td>
					<td>${contact.nome}</td>
					<td>${contact.cpf}</td>
					<td><a href="delete/${contact.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>