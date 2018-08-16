package prueba2

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


class PruebaController {

    PruebaService pruebaService


    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)


        def query=Prueba.where{
            nombre=="Edi"
        }

        respond query.findAll(), model:[pruebaCount: pruebaService.count()]
        //respond pruebaService.list(params), model:[pruebaCount: pruebaService.count()]
    }

    def show(Long id) {
        respond pruebaService.get(id)
    }
    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Prueba(params)
    }

    def save(Prueba prueba) {
        if (prueba == null) {
            notFound()
            return
        }

        try {
            pruebaService.save(prueba)
        } catch (ValidationException e) {
            respond prueba.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'prueba.label', default: 'Prueba'), prueba.id])
                redirect prueba
            }
            '*' { respond prueba, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pruebaService.get(id)
    }

    def update(Prueba prueba) {
        if (prueba == null) {
            notFound()
            return
        }

        try {
            pruebaService.save(prueba)
        } catch (ValidationException e) {
            respond prueba.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'prueba.label', default: 'Prueba'), prueba.id])
                redirect prueba
            }
            '*'{ respond prueba, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pruebaService.delete(id)

        redirect action: "index", controller: "prueba", params: [mensaje: "Se elimino correctamente"]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'prueba.label', default: 'Prueba'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
