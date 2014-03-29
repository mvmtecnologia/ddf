<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<jsp:include page="./includes/header.jsp" />
</head>


<body>

    <!-- Fixed navbar -->
    <jsp:include page="./includes/navbarcomlogin.jsp" />

    <!-- Begin page content -->
    <div class="container">
        <div class="row">
            <div class=".col-md-1">
                <h3>Cadastro de Usuário</h3>

                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#usuarioModal">
                    Incluir</button>

                <!-- Modal -->
                <jsp:include page="./usuariomodal.jsp" />
            </div>
        </div>
        <br>
        <div class="row">
            <div class=".col-md-1">
                <table class="table table-bordered">
                    <tr>
                        <th>Email</th>
                        <th>Nome</th>
                        <th>Cpf</th>
                        <th>Ações</th>
                    </tr>
                    <c:forEach items="${usuarioList}" var="usuario">
                        <tr>
                            <td>${usuario.email}</td>
                            <td>${usuario.nome}</td>
                            <td>${usuario.cpf}</td>
                            <td><a href="delete/${usuario.id}"><img
                                    src="./resources/img/icons/delete.png" class="img-responsive"
                                    alt="Apagar"
                                ></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

    <jsp:include page="./includes/footer.jsp" />

</body>
</html>