<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="pt-br">

<jsp:include page="includes/header.jsp" />
<link href="resources/css/home.css" rel="stylesheet">
</head>

<body>

    <!-- Fixed navbar -->
    <jsp:include page="includes/navbarcomlogin.jsp" />

    <!-- Begin page content -->
    <div class="container">
        <form class="form-home" role="form">
            <h2 class="form-home-heading">Pequisar medicamento por</h2>
            <input type="text" class="form-control" placeholder="nome, princípio ativo ou fabricante." required autofocus>
        </form>
    </div>

    <jsp:include page="includes/footer.jsp" />

</body>
</html>
