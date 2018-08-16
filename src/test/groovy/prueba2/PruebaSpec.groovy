package prueba2

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PruebaSpec extends Specification implements DomainUnitTest<Prueba> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
