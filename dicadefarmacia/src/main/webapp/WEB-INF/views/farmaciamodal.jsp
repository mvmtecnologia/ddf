<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Modal -->
<div class="modal fade" id="usuarioModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
    aria-hidden="true"
>
    <form:form method="post" action="add.html" commandName="farmacia" class="form-horizontal"
        role="form"
    >
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Farmácia</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nome" class="col-sm-2 control-label">Nome:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nome" name="nome"
                                placeholder="Nome" required="required" autofocus="autofocus"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefone1" class="col-sm-2 control-label">Telefone 1:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="telefone1" name="telefone1"
                                placeholder="Telefone 1" required="required"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefone2" class="col-sm-2 control-label">Telefone 2:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="telefone2" name="telefone2"
                                placeholder="Telefone 2" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="logradouro" class="col-sm-2 control-label">Logradouro:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="logradouro" name="logradouro"
                                placeholder="Logradouro" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="numero" class="col-sm-2 control-label">Número:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="numero" name="numero"
                                placeholder="Número" required="required"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="complemento" class="col-sm-2 control-label">Complemento:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="complemento" name="complemento"
                                placeholder="Complemento" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cep" class="col-sm-2 control-label">Cep:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cep" name="cep"
                                placeholder="Cep" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bairro" class="col-sm-2 control-label">Bairro:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bairro" name="bairro"
                                placeholder="Bairro" required="required"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cidade" class="col-sm-2 control-label">Cidade:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cidade" name="cidade"
                                placeholder="Cidade" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="estado" class="col-sm-2 control-label">Estado:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="estado" name="estado"
                                placeholder="Estado" required="required"
                            >
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </div>
    </form:form>
</div>