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
                        <label for="principioAtivo" class="col-sm-3 control-label">Princípio ativo:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="principioAtivo" name="principioAtivo"
                                placeholder="Nome" required="required" autofocus="autofocus"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dosagem" class="col-sm-3 control-label">Dosagem:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-sm" id="dosagem" name="dosagem"
                                placeholder="Dosagem" required="required"
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