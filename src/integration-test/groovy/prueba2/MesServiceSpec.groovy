package prueba2

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MesServiceSpec extends Specification {

    MesService mesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mes(...).save(flush: true, failOnError: true)
        //new Mes(...).save(flush: true, failOnError: true)
        //Mes mes = new Mes(...).save(flush: true, failOnError: true)
        //new Mes(...).save(flush: true, failOnError: true)
        //new Mes(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mes.id
    }

    void "test get"() {
        setupData()

        expect:
        mesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mes> mesList = mesService.list(max: 2, offset: 2)

        then:
        mesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mesService.count() == 5
    }

    void "test delete"() {
        Long mesId = setupData()

        expect:
        mesService.count() == 5

        when:
        mesService.delete(mesId)
        sessionFactory.currentSession.flush()

        then:
        mesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mes mes = new Mes()
        mesService.save(mes)

        then:
        mes.id != null
    }
}
