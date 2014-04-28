<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="">Dica de Farmácia</a>
		</div>
		<c:if test="${pageContext.request.userPrincipal.name == null}">

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login">Login</a></li>
				</ul>
			</div>
		</c:if>


		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<ul class="nav navbar-nav navbar-right">
				<li>${pageContext.request.userPrincipal.name} |</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/logout" />"> Logout</a></li>
			</ul>
		</c:if>


	</div>
</div>