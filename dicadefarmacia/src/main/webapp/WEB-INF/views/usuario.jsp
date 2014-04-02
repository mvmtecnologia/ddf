<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin page content -->
<div class="container col-md-12">
    <div class="row">
        <div>
            <h3>Cadastro de Usuário</h3>

            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#usuarioModal">
                Incluir</button>

            <!-- Modal -->
            <jsp:include page="usuariomodal.jsp" />
        </div>
    </div>
    <br>
    <div class="row">
        <div>
            <table class="table table-bordered">
                <tr>
                    <th>Email</th>
                    <th>Nome</th>
                    <th>Cpf</th>
                    <th class="col-md-1">Ações</th>
                </tr>
                <c:forEach items="${usuarioList}" var="usuario">
                    <tr>
                        <td>${usuario.email}</td>
                        <td>${usuario.nome}</td>
                        <td>${usuario.cpf}</td>
                        <td><a href="usuario/delete/${usuario.id}"><img
                                src="resources/img/icons/delete.png" class="img-responsive"
                                alt="Apagar"
                            ></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>