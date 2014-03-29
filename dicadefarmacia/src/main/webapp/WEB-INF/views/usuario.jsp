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
            <h3>Cadastro de Usuário</h3>
            <div class="col-md-6">
                <form:form method="post" action="add.html" commandName="usuario"
                    class="form-horizontal" role="form"
                >
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">E-mail:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email"
                                placeholder="E-mail" required="required" autofocus="autofocus"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nome" class="col-sm-2 control-label">Nome:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nome" name="nome"
                                placeholder="Nome" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="cpf" class="col-sm-2 control-label">Cpf:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cpf" name="cpf"
                                placeholder="Cpf" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="senha" class="col-sm-2 control-label">Senha:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="senha" name="senha"
                                placeholder="Senha" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="repetesenha" class="col-sm-2 control-label">Repete
                            senha:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="repetesenha"
                                name="repetesenha" placeholder="Repete senha" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Salvar</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>

        <div class="row">
            <div class=".col-md-1">
                <c:if test="${!empty usuarioList}">
                    <h3>Usuários</h3>
                    <table class="table">
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
                                        src="./resources/img/icons/delete.png"
                                        class="img-responsive" alt="Apagar"
                                    ></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </div>
    </div>

    <jsp:include page="./includes/footer.jsp" />

</body>
</html>