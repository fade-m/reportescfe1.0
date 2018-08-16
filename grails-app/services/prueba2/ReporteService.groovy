package prueba2

import grails.gorm.services.Service

@Service(Reporte)
interface ReporteService {

    Reporte get(Serializable id)

    List<Reporte> list(Map args)

    Long count()

    void delete(Serializable id)

    Reporte save(Reporte reporte)

}