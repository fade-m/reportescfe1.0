package prueba2

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class ConceptoController {

    ConceptoService conceptoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond conceptoService.list(params), model:[conceptoCount: conceptoService.count()]
    }

    def show(Long id) {
        respond conceptoService.get(id)
    }

    def create() {
        respond new Concepto(params)
    }

    def save(Concepto concepto) {
        if (concepto == null) {
            notFound()
            return
        }

        try {
            conceptoService.save(concepto)
        } catch (ValidationException e) {
            respond concepto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'concepto.label', default: 'Concepto'), concepto.id])
                redirect concepto
            }
            '*' { respond concepto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond conceptoService.get(id)
    }

    def update(Concepto concepto) {
        if (concepto == null) {
            notFound()
            return
        }

        try {
            conceptoService.save(concepto)
        } catch (ValidationException e) {
            respond concepto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'concepto.label', default: 'Concepto'), concepto.id])
                redirect concepto
            }
            '*'{ respond concepto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        conceptoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'concepto.label', default: 'Concepto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'concepto.label', default: 'Concepto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
