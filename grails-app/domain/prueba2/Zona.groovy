package prueba2

class Zona {

    String nombre
    String descripcion
    String division

    static belongsTo = [usuario: Usuario]

    static constraints = {
    }


    public String toString() {
      return nombre;
    }
}
