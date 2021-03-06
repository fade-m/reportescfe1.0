package prueba2

import grails.plugin.springsecurity.annotation.Secured
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)

class Usuario implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Rol> getAuthorities() {
        (UsuarioRol.findAllByUsuario(this) as List<UsuarioRol>)*.rol as Set<Rol>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        nombre nullable: false
        apellidoPaterno nullable: false
        apellidoMaterno nullable: false
    }

    static mapping = {
	    password column: '`password`'
    }
}
