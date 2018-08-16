package prueba2

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class MesController {

    MesService mesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mesService.list(params), model:[mesCount: mesService.count()]
    }

    def show(Long id) {
        respond mesService.get(id)
    }

    def create() {
        respond new Mes(params)
    }

    def save(Mes mes) {
        if (mes == null) {
            notFound()
            return
        }

        try {
            mesService.save(mes)
        } catch (ValidationException e) {
            respond mes.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mes.label', default: 'Mes'), mes.id])
                redirect mes
            }
            '*' { respond mes, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mesService.get(id)
    }

    def update(Mes mes) {
        if (mes == null) {
            notFound()
            return
        }

        try {
            mesService.save(mes)
        } catch (ValidationException e) {
            respond mes.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mes.label', default: 'Mes'), mes.id])
                redirect mes
            }
            '*'{ respond mes, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mes.label', default: 'Mes'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mes.label', default: 'Mes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
