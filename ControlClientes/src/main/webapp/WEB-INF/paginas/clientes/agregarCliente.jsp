<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>    
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input required type="text" name="nombre" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input required type="text" name="apellido" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input required type="email" name="email" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input required type="tel" name="telefono" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input required type="number" name="saldo" step="0.01" class="form-control"/>
                    </div>
                    
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>