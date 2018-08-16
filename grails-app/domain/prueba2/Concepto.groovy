package prueba2

class Concepto {

    String nombre
    String descripcion
    String codigo

    static constraints = {
      nombre nullable : false
      descripcion nullable : false
      codigo nullable : false
    }

    public String toString() {
      return nombre
    }

}
