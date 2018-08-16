package prueba2

class Prueba {

    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;

    static constraints = {
        nombre nullable: true, maxSize: 255, minSize: 3
        apellidoMaterno nullable: true, maxSize: 255
        apellidoPaterno nullable: true, maxSize: 255
    }
}
