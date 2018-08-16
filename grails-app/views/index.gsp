<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>

<h1>Index</h1>

<sec:ifNotLoggedIn>
    No estas logeados
    <li class="dropdown user user-menu">
        <g:link class="btn text-blue" uri="/login/auth">Iniciar sesión</g:link>
    </li>
</sec:ifNotLoggedIn>

<sec:ifLoggedIn>
    <sec:access expression="hasRole('ROLE_ADMIN')">
        <h2>Bienvenido Admin</h2>
    </sec:access>
    <sec:access expression="hasRole('ROLE_SUPER')">
        <h2>Bienvenido SUPERUSUARIO</h2>
    </sec:access>
    <sec:access expression="hasRole('ROLE_ZONA')">
        <h2>Bienvenido ZONA</h2>
    </sec:access>

</sec:ifLoggedIn>

</body>
</html>
