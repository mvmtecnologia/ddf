<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="includes/header.jsp" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/css/login.css" rel="stylesheet">
</head>


<body>

    <!-- Fixed navbar -->
    <jsp:include page="includes/navbarsemlogin.jsp" />

    <div class="container">


              ${param.error}
             
        <form class="form-signin" method="post" action="<c:url value="/login"/>">
            <input type="email" id="username" class="form-control" name="username" placeholder="E-mail" required autofocus>
            <input type="password" class="form-control"  id="password" name="password" placeholder="Senha" required>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Entrar">
        </form>

    </div>

    <jsp:include page="includes/footer.jsp" />

</body>
</html>
