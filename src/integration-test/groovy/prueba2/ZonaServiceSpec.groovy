package prueba2

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ZonaServiceSpec extends Specification {

    ZonaService zonaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Zona(...).save(flush: true, failOnError: true)
        //new Zona(...).save(flush: true, failOnError: true)
        //Zona zona = new Zona(...).save(flush: true, failOnError: true)
        //new Zona(...).save(flush: true, failOnError: true)
        //new Zona(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //zona.id
    }

    void "test get"() {
        setupData()

        expect:
        zonaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Zona> zonaList = zonaService.list(max: 2, offset: 2)

        then:
        zonaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        zonaService.count() == 5
    }

    void "test delete"() {
        Long zonaId = setupData()

        expect:
        zonaService.count() == 5

        when:
        zonaService.delete(zonaId)
        sessionFactory.currentSession.flush()

        then:
        zonaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Zona zona = new Zona()
        zonaService.save(zona)

        then:
        zona.id != null
    }
}
