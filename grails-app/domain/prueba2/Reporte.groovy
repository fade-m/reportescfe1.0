package prueba2

class Reporte {

    Mes mes
    Semana semanas
    Concepto concepto
    int cantidadRealizada
    String usuario

    static constraints = {
      cantidadRealizada nullable : false
      concepto nullable : true
      semanas nullable : true
      mes nullable : true
      usuario nullable : true
    }
}
