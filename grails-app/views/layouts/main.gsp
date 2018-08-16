<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="${createLink(uri: '/')}">Reportes CFE</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <label class="text-white"><sec:ifLoggedIn>Bienvenido: <sec:username/></sec:ifLoggedIn></label>
    </div>


    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">

        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
                <sec:ifLoggedIn>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Cerrar sesión</a>
                    </div>
                </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <g:link class="btn text-blue" uri="/login/auth">Iniciar sesión</g:link>
                </div>
            </sec:ifNotLoggedIn>
        </li>
    </ul>

</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <sec:access expression="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-user"></i>
                    <span>Usuario</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="${createLink(uri: '/usuario')}">Lista de usuarios</a>
                    <a class="dropdown-item" href="${createLink(uri: '/usuario/create')}">Crear usuario</a>
                </div>
            </li>
        </sec:access>
        <sec:access expression="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-calendar-alt"></i>
                    <span>Mes</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="${createLink(uri: '/mes')}">Lista de meses</a>
                    <a class="dropdown-item" href="${createLink(uri: '/mes/create')}">Crear Meses</a>
                </div>
            </li>
        </sec:access>

        <sec:access expression="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-calendar-minus"></i>
                    <span>Semana</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="${createLink(uri: '/semana')}">Lista de semanas</a>
                    <a class="dropdown-item" href="${createLink(uri: '/semana/create')}">Crear Semana</a>
                </div>
            </li>
        </sec:access>

        <sec:access expression="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Reportes</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="${createLink(uri: '/reporte')}">Lista de reportes</a>
                    <a class="dropdown-item" href="${createLink(uri: '/reporte/create')}">Crear Reporte</a>
                </div>
            </li>
        </sec:access>

        <sec:access expression="hasRole('ROLE_ZONA')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Reportes</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="${createLink(uri: '/reporte')}">Lista de reportes</a>
                    <a class="dropdown-item" href="${createLink(uri: '/reporte/create')}">Crear Reporte</a>
                </div>
            </li>
        </sec:access>

        <sec:access expression="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Concepto</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <a class="dropdown-item" href="${createLink(uri: '/concepto')}">Lista de conceptos</a>
                    <a class="dropdown-item" href="${createLink(uri: '/concepto/create')}">Crear Concepto</a>
                </div>
            </li>
        </sec:access>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">


            <!-- Main content -->
            <g:layoutBody />
            <!-- /.content -->

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright © CFE 2018</span>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">¿Estas seguro de que deseas salir?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Selecciona "Cerrar sesión" si estas listo para terminar tu sesión.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <g:form controller="logout">
                    <button type="submit" name="logout" class="btn btn-danger btn-flat">
                        Cerrar sesión
                    </button>
                </g:form>

            </div>
        </div>
    </div>
</div>

    <asset:javascript src="application.js"/>
<script>
    $(function () {
        $('#dataTable').dataTable({
            "lengthMenu": [[10, 30, -1], [10, 30, "Todos"]],
            "lengthChange": true,
            "paging": true,
            "searching": true,
            "length": true,
            "autoWidth": true,
            "order": [[0, "asc"]],
            "language": {
                "emptyTable": "Sin registros",
                "info": "Registros _START_ a _END_. Total: _TOTAL_",
                "infoEmpty": "Sin registros por mostrar",
                "infoFiltered": "(_MAX_ registros filtrados)",
                "lengthMenu": "Mostrar _MENU_ registros",
                "loadingRecords": "Cargando...",
                "processing": "Procesando...",
                "search": "Buscar:",
                "zeroRecords": "No se encontraron resultados",
                "paginate": {
                    "first": "Inicio",
                    "last": "Fin",
                    "next": "Siguiente",
                    "previous": "Anterior"
                }
            }
        });
    });
</script>

</body>
</html>
