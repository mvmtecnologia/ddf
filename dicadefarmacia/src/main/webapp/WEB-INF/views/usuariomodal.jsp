<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Modal -->
<div class="modal fade" id="usuarioModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
    aria-hidden="true"
>
    <form:form method="post" action="usuario/add.html" commandName="usuario" class="form-horizontal"
        role="form"
    >
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Usu�rio</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">E-mail:</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control input-sm" id="email" name="email"
                                placeholder="E-mail" required="required" autofocus="autofocus"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nome" class="col-sm-3 control-label">Nome:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="nome" name="nome"
                                placeholder="Nome" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="cpf" class="col-sm-3 control-label">Cpf:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="cpf" name="cpf"
                                placeholder="Cpf" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="senha" class="col-sm-3 control-label">Senha:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control input-sm" id="senha" name="senha"
                                placeholder="Senha" required="required"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="repetesenha" class="col-sm-3 control-label">Repete
                            senha:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control input-sm" id="repetesenha"
                                name="repetesenha" placeholder="Repete senha" required="required"
                            >
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Fechar</button>
                    <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                </div>
            </div>
        </div>
    </form:form>
</div>