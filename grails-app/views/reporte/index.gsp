<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'reporte.label', default: 'Reporte')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

        <sec:ifLoggedIn>
            <sec:access expression="hasRole('ROLE_ADMIN')">
            <g:form method="post" action="exportarExcel" controller="reporte">
              <input type="submit" value="Exportar excel"/>
            </g:form>
            </sec:access>
        </sec:ifLoggedIn>

        <a href="#list-reporte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>

        <div id="list-reporte" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${reporteList}" />

            <div class="pagination">
                <g:paginate total="${reporteCount ?: 0}" />
            </div>
        </div>

        
    </body>
</html>
