<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Dica
				de Farmácia</a>
		</div>

		<div class="collapse navbar-collapse">
		<c:if test="${pageContext.request.userPrincipal.name != null}"> 
			<ul class="nav navbar-nav navbar-right">
				<li>
				   ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />"> Logout</a>
				</li>
			</ul>
 
		</c:if>
		</div>
	</div>
</div>
