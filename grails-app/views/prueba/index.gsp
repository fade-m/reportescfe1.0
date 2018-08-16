<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'prueba.label', default: 'Prueba')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-prueba" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-prueba" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            ${params?.mensaje}
            <g:each in="${pruebaList}">
                ${it.nombre}
                ${it.apellidoPaterno}
                ${it.apellidoMaterno}
                <g:link controller="prueba" action="edit" id="${it.id}">
                    Editar
                </g:link>
                <g:link controller="prueba" action="delete" params="[id: it.id]">
                    Eliminar
                </g:link>
                <br>

            </g:each>

            <div class="pagination">
                <g:paginate total="${pruebaCount ?: 0}" />
            </div>
        </div>
    </body>
</html>