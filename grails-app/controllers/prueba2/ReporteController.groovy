package prueba2

import org.springframework.context.MessageSource
import pl.touk.excel.export.WebXlsxExporter
import pl.touk.excel.export.getters.LongToDatePropertyGetter
import pl.touk.excel.export.getters.MessageFromPropertyGetter
import pl.touk.excel.export.XlsxExporter
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN' , 'ROLE_ZONA'])
class ReporteController {

    ReporteService reporteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {

      String usr;

        params.max = Math.min(max ?: 10, 100)

        if (isLoggedIn()) {
         usr = getAuthenticatedUser().username
         print usr

      }

      def queryAdmin = Reporte.findAll()
      def query = Reporte.where{usuario==usr}
      def lista;
      if(usr=='admin'){
        lista = queryAdmin
      }else {
        lista = query
      }

      respond lista.findAll(), model:[reporteCount: reporteService.count()]

    }

    def exportarExcel() {

      List<Reporte> reporte = Reporte.list()
      print reporte
      def headers = ['mes', 'semanas', 'concepto', 'cantidadRealizada', 'usuario']
      def withProperties = ['mes', 'semanas', 'concepto', 'cantidadRealizada', 'usuario']

      new WebXlsxExporter().with {
          setResponseHeaders(response)
          fillHeader(headers)
          add(reporte, withProperties)
          save(response.outputStream)
      }

    }


    def darPermiso() {
      def p = Permiso.first()
      p.estado = true
      p.save(flush:true)
      redirect(controller: "reporte", action: "create")
    }

    def quitarPermiso() {
      def p = Permiso.first()
      p.estado = false
      p.save(flush:true)
      redirect(controller: "reporte", action: "create")
    }

    def show(Long id) {
        respond reporteService.get(id)
    }

    def create() {
        def p = Permiso.first()
        def c = Concepto.findAll()
        def m = Mes.findAll()
        def s = Semana.findAll()
        def mapa = [:]
        mapa.put('conceptosLista', c)
        mapa.put('mesesLista', m)
        mapa.put('semanasLista', s)
        mapa.put('estado', p.estado)
        respond new Reporte(params), model: mapa
    }

    def save(Reporte reporte) {
        if (reporte == null) {
            notFound()
            return
        }

        try {
            reporteService.save(reporte)
        } catch (ValidationException e) {
            respond reporte.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reporte.label', default: 'Reporte'), reporte.id])
                redirect reporte
            }
            '*' { respond reporte, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reporteService.get(id)
    }

    def update(Reporte reporte) {
        if (reporte == null) {
            notFound()
            return
        }

        try {
            reporteService.save(reporte)
        } catch (ValidationException e) {
            respond reporte.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reporte.label', default: 'Reporte'), reporte.id])
                redirect reporte
            }
            '*'{ respond reporte, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reporteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reporte.label', default: 'Reporte'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reporte.label', default: 'Reporte'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
