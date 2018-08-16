package prueba2

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PruebaServiceSpec extends Specification {

    PruebaService pruebaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Prueba(...).save(flush: true, failOnError: true)
        //new Prueba(...).save(flush: true, failOnError: true)
        //Prueba prueba = new Prueba(...).save(flush: true, failOnError: true)
        //new Prueba(...).save(flush: true, failOnError: true)
        //new Prueba(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //prueba.id
    }

    void "test get"() {
        setupData()

        expect:
        pruebaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Prueba> pruebaList = pruebaService.list(max: 2, offset: 2)

        then:
        pruebaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pruebaService.count() == 5
    }

    void "test delete"() {
        Long pruebaId = setupData()

        expect:
        pruebaService.count() == 5

        when:
        pruebaService.delete(pruebaId)
        sessionFactory.currentSession.flush()

        then:
        pruebaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Prueba prueba = new Prueba()
        pruebaService.save(prueba)

        then:
        prueba.id != null
    }
}
