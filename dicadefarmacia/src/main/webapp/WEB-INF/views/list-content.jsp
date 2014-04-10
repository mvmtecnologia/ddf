<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="includes/header.jsp" />
</head>
<body>
	<!-- Fixed navbar -->
    <jsp:include page="includes/navbarsemlogin.jsp" />
    
	<div class="container">
		<ul>
			<c:forEach items="${remedioList}" var="remedio">
				<li>
					${remedio.nomeCompleto}  - Valor: ${remedio.preco}<br>
					Laboratório: ${remedio.nomeFabricante}
				</li>
			</c:forEach>
		</ul>

	</div>
	
	<jsp:include page="includes/footer.jsp" />
</body>
</html>