package prueba2

import grails.gorm.services.Service

@Service(Mes)
interface MesService {

    Mes get(Serializable id)

    List<Mes> list(Map args)

    Long count()

    void delete(Serializable id)

    Mes save(Mes mes)

}