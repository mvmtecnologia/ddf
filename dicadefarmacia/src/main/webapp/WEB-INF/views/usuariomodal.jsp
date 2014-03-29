<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
    aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form method="post" action="add.html" commandName="usuario" class="form-horizontal"
                role="form"
            >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Usuário</h4>
                </div>
                <div class="modal-body">
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
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
            </form:form>
        </div>
    </div>
</div>