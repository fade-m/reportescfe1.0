package prueba2

import grails.gorm.services.Service

@Service(Semana)
interface SemanaService {

    Semana get(Serializable id)

    List<Semana> list(Map args)

    Long count()

    void delete(Serializable id)

    Semana save(Semana semana)

}