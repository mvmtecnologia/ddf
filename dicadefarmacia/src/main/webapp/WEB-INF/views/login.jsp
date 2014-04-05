<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="includes/header.jsp" />
<!-- Custom styles for this template -->
<link href="resources/css/login.css" rel="stylesheet">
</head>

<body>

    <!-- Fixed navbar -->
    <jsp:include page="includes/navbarsemlogin.jsp" />

    <div class="container">


        <form:form class="form-signin" method="post" action="admin.html" commandName="usuario"
            role="form"
        >
            <input type="email" class="form-control" name="email" placeholder="E-mail" required autofocus>
            <input type="password" class="form-control" name="senha" placeholder="Senha" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        </form:form>

    </div>

    <jsp:include page="includes/footer.jsp" />

</body>
</html>
