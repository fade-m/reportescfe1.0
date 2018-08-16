package prueba2

class Semana {

    int numeroSemana
    String descripcion


    static belongsTo = [mes: Mes]

    static constraints = {
      numeroSemana nullable : false
      numeroSemana nullable : false
      numeroSemana nullable : true
    }

    public String toString() {
      return descripcion;
    }
}
