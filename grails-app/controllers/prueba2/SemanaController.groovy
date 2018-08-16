package prueba2

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
class SemanaController {

    SemanaService semanaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond semanaService.list(params), model:[semanaCount: semanaService.count()]
    }

    def show(Long id) {
        respond semanaService.get(id)
    }

    def create() {
        respond new Semana(params)
    }

    def save(Semana semana) {
        if (semana == null) {
            notFound()
            return
        }

        try {
            semanaService.save(semana)
        } catch (ValidationException e) {
            respond semana.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'semana.label', default: 'Semana'), semana.id])
                redirect semana
            }
            '*' { respond semana, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond semanaService.get(id)
    }

    def update(Semana semana) {
        if (semana == null) {
            notFound()
            return
        }

        try {
            semanaService.save(semana)
        } catch (ValidationException e) {
            respond semana.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'semana.label', default: 'Semana'), semana.id])
                redirect semana
            }
            '*'{ respond semana, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        semanaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'semana.label', default: 'Semana'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'semana.label', default: 'Semana'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
