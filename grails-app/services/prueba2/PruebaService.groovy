package prueba2

import grails.gorm.services.Service

@Service(Prueba)
interface PruebaService {

    Prueba get(Serializable id)

    List<Prueba> list(Map args)

    Long count()

    void delete(Serializable id)

    Prueba save(Prueba prueba)

}