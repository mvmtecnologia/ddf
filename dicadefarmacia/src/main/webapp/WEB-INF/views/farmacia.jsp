<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin page content -->
<div class="container col-md-12">
    <div class="row">
        <div>
            <h3>Cadastro de Farm�cias</h3>

            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#farmaciaModal">Incluir</button>

            <!-- Modal -->
            <jsp:include page="farmaciamodal.jsp" />
        </div>
    </div>
    <br>
    <div class="row">
        <div class=".col-md-1">
            <table class="table table-bordered">
                <tr>
                    <th>Nome</th>
                    <th>Contato</th>
                    <th>Endere�o</th>
                    <th class="col-md-1">A��es</th>
                </tr>
                <c:forEach items="${farmaciaLista}" var="farma">
                    <tr>
                        <td>${farma.nome}</td>
                        <td>${farma.contato}</td>
                        <td>${farma.endereco}</td>
                        <td>
                            <a href="#">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <a href="farmacia/delete/${farma.id}">
                                <span class="glyphicon glyphicon-remove"></span>
                            </a>
                        </td>
                        <!-- <td><a href="${pageContext.request.contextPath}/farmacia/edit/${farma.id}">editar</a></td> -->
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>