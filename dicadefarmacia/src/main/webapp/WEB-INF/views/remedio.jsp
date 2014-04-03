<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin page content -->
<div class="container col-md-12">
    <div class="row">
        <div>
            <h3>Cadastro de Remédio</h3>

            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#remedioModal">Incluir</button>

            <!-- Modal -->
            <jsp:include page="remediomodal.jsp" />
        </div>
    </div>
    <br>
    <div class="row">
        <div class=".col-md-1">
            <table class="table table-bordered">
                <tr>
                    <th>Nome</th>
                    <th>Contato</th>
                    <th>Endereço</th>
                    <th class="col-md-1">Ações</th>
                </tr>
                <c:forEach items="${remedioLista}" var="remedio">
                    <tr>
                        <td>${remedio.nome}</td>
                        <td>${remedio.contato}</td>
                        <td>${remedio.endereco}</td>
                        <td>
                            <a href="#">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <a href="remedio/delete/${remedio.id}">
                                <span class="glyphicon glyphicon-remove"></span>
                            </a>
                        </td>
                        <!-- <td><a href="${pageContext.request.contextPath}/remedio/edit/${remedio.id}">editar</a></td> -->
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>