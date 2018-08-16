<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <g:each in="${usuarioList}" var="item">
        <div class="modal fade" id="modal${item.id}" tabindex="-1"
             role="dialog" aria-labelledby="tituloModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <h5 class="modal-title" id="tituloModal">
                            <strong>Advertencia</strong>
                        </h5>
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body text-center bg-danger text-white">
                        ¿Está seguro que desea Eliminar este registro?<br>
                        "<strong> ${item.id} ${item.nombre}</strong>"?
                        <br />
                        <br />

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-dismiss="modal">Cancelar</button>
                        <g:link action="delete" id="${item.id}" controller="usuario"
                                params="['usuario': item.id]"
                                class="btn btn-danger">
                            Eliminar
                        </g:link>
                    </div>

                </div>
            </div>
        </div>
    </g:each>

    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Lista de usuarios
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Opciones</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Opciones</th>
                    </tr>
                    </tfoot>
                    <tbody>

                        <g:each in="${usuarioList}">
                            <tr>
                                <th scope="row">${it.id}</th>
                                <td>${it.nombre}</td>
                                <td>${it.apellidoPaterno}</td>
                                <td>${it.apellidoMaterno}</td>
                                <td>
                                    <buton class="btn btn-secondary ">
                                        <g:link controller="usuario" class="text-white" action="edit" id="${it.id}">
                                            Editar
                                        </g:link>
                                    </buton>
                                    <a class="btn btn-danger text-dark" data-toggle="modal" data-target="#modal${it.id}">
                                        <span class="oi oi-circle-x text-info"></span>
                                        <i class="text-white">Eliminar</i>
                                    </a>
                                </td>
                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Lista de usuarios</div>
    </div>
    </body>
</html>