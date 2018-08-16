<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'reporte.label', default: 'Reporte')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>

        <a href="#create-reporte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>


        <div id="create-reporte" class="content scaffold-create" role="main">

          <sec:ifLoggedIn>
              <sec:access expression="hasRole('ROLE_ADMIN')">

              <g:form method="post" action="darPermiso" controller="reporte">
                <input type="submit" value="Dar permiso"/>
              </g:form>

              <g:form method="post" action="quitarPermiso" controller="reporte">
                <input type="submit" value="Quitar permiso"/>
              </g:form>

            

              </sec:access>
          </sec:ifLoggedIn>

            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.reporte}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.reporte}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>


            <g:form method="POST" action="save" controller="reporte">
                <label>
                  Mes
                </label>
                <select name="mes">
                  <g:each in="${mesesLista}">
                    <option value="${it.id}">${it.mes}</option>
                  </g:each>
                </select>

                <label>
                  Semana
                </label>
                <select name="semanas">
                  <g:each in="${semanasLista}">
                    <option value="${it.id}">${it.numeroSemana}</option>
                  </g:each>
                </select>

                <label>
                  Concepto
                </label>
                <select name="concepto">
                  <g:each in="${conceptosLista}">
                    <option value="${it.id}">${it.nombre}</option>
                  </g:each>
                </select>

                <label>
                  Cantidad realizada
                </label>
                <input type="text" name="cantidadRealizada"/>

                <input name="usuario" type="text" value="${sec.username()}" readonly />

                <g:if test="${estado}">
                  <input type="submit"/>
                </g:if>

            </g:form>

        </div>
    </body>

</html>
