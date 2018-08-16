package prueba2

class Mes {

    Date fechaCreacion
    String mes

    static hasMany = [semanas: Semana]


    static constraints = {
      fechaCreacion nullable : false
      mes nullable : false
      semanas nullable : true
    }

    public String toString () {
      return mes;
    }
}
