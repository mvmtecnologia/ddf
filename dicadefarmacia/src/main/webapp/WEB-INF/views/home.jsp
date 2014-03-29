<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="pt-br">

<jsp:include page="./includes/header.jsp" />
<link href="./resources/css/home.css" rel="stylesheet">
</head>

<body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Dica de Farmácia</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="./login">Login</a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Begin page content -->
    <div class="container">
        <form class="form-home" role="form">
            <h2 class="form-home-heading">Pequisar medicamento por</h2>
            <input type="text" class="form-control" placeholder="nome, princípio ativo ou fabricante." required autofocus>
        </form>
    </div>

    <jsp:include page="./includes/footer.jsp" />

</body>
</html>
