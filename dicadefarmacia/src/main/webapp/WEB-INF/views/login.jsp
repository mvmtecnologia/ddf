<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="./includes/header.jsp" />
<!-- Custom styles for this template -->
<link href="./resources/css/login.css" rel="stylesheet">
</head>

<body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="./home">Dica de Farmácia</a>
            </div>
        </div>
    </div>

    <div class="container">

        <form class="form-signin" role="form">
            <input type="email" class="form-control" placeholder="E-mail" required autofocus>
            <input type="password" class="form-control" placeholder="Senha" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        </form>

    </div>

    <jsp:include page="./includes/footer.jsp" />

</body>
</html>
