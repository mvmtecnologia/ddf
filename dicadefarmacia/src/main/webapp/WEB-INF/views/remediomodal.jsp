<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Modal -->
<div class="modal fade" id="remedioModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
    aria-hidden="true"
>
    <form:form method="post" action="remedio/add.html" commandName="remedio" class="form-horizontal"
        role="form"
    >
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Remédio</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nome" class="col-sm-3 control-label">Nome:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="nome" name="nome"
                                placeholder="Nome" required="required" autofocus="autofocus"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefone1" class="col-sm-3 control-label">Telefone 1:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="telefone1" name="telefone1"
                                placeholder="Telefone 1" required="required"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefone2" class="col-sm-3 control-label">Telefone 2:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="telefone2" name="telefone2"
                                placeholder="Telefone 2" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="logradouro" class="col-sm-3 control-label">Logradouro:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="logradouro" name="logradouro"
                                placeholder="Logradouro" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="numero" class="col-sm-3 control-label">Número:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="numero" name="numero"
                                placeholder="Número" required="required"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="complemento" class="col-sm-3 control-label">Complemento:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="complemento" name="complemento"
                                placeholder="Complemento" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cep" class="col-sm-3 control-label">Cep:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="cep" name="cep"
                                placeholder="Cep" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bairro" class="col-sm-3 control-label">Bairro:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="bairro" name="bairro"
                                placeholder="Bairro" required="required"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cidade" class="col-sm-3 control-label">Cidade:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="cidade" name="cidade"
                                placeholder="Cidade" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="estado" class="col-sm-3 control-label">Estado:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="estado" name="estado"
                                placeholder="Estado" required="required"
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