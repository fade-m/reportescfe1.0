package prueba2

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class ZonaController {

    ZonaService zonaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond zonaService.list(params), model:[zonaCount: zonaService.count()]
    }

    def show(Long id) {
        respond zonaService.get(id)
    }

    def create() {
        respond new Zona(params)
    }

    def save(Zona zona) {
        if (zona == null) {
            notFound()
            return
        }

        try {
            zonaService.save(zona)
        } catch (ValidationException e) {
            respond zona.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'zona.label', default: 'Zona'), zona.id])
                redirect zona
            }
            '*' { respond zona, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond zonaService.get(id)
    }

    def update(Zona zona) {
        if (zona == null) {
            notFound()
            return
        }

        try {
            zonaService.save(zona)
        } catch (ValidationException e) {
            respond zona.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'zona.label', default: 'Zona'), zona.id])
                redirect zona
            }
            '*'{ respond zona, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        zonaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'zona.label', default: 'Zona'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'zona.label', default: 'Zona'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
