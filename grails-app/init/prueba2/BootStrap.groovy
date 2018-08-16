package prueba2

class BootStrap {


    def init = { servletContext ->


        def p = new Permiso(estado: true).save()


        def cpto1 = new Concepto(nombre:'Circuito Limpio en Propiedad' ,descripcion: 'Circuito Limpio en Propiedad',codigo: '001').save(flush:true)
        def cpto2 = new Concepto(nombre:'Termografia' ,descripcion: 'Termografia',codigo: '002').save(flush:true)
        def cpto3 = new Concepto(nombre:'Remplazo de Aislamiento' ,descripcion: 'Remplazo de Aislamiento',codigo: '003').save(flush:true)
        def cpto4 = new Concepto(nombre:'Remplazo de Apartarrayo' ,descripcion: 'Remplazo de Apartarrayo',codigo: '004').save(flush:true)
        def cpto5 = new Concepto(nombre:'PODA' ,descripcion: 'PODA',codigo: '005').save(flush:true)
        def cpto6 = new Concepto(nombre:'Modificacion de Puentes' ,descripcion: 'Modificacion de Puentes',codigo: '006').save(flush:true)
        def cpto7 = new Concepto(nombre:'Instalacion de Cinta Elastomerica' ,descripcion: 'Instalacion de Cinta Elastomerica',codigo: '007').save(flush:true)
        def cpto8 = new Concepto(nombre:'Subestaciones Limpias' ,descripcion: 'Subestaciones Limpias',codigo: '008').save(flush:true)

        print cpto1

        Date fecha = new Date()
        print fecha

        def enero = new Mes(fechaCreacion: fecha , mes : 'Enero',semanas : null).save(flush:true)
        def febrero = new Mes(fechaCreacion: fecha, mes : 'Febrero',semanas : null).save(flush:true)
        def marzo = new Mes(fechaCreacion: fecha, mes : 'Marzo',semanas : null).save(flush:true)
        def abril = new Mes(fechaCreacion: fecha, mes : 'Abril',semanas : null).save(flush:true)
        def mayo = new Mes(fechaCreacion: fecha, mes : 'Mayo',semanas : null).save(flush:true)
        def junio = new Mes(fechaCreacion: fecha, mes : 'Junio',semanas : null).save(flush:true)
        def julio = new Mes(fechaCreacion: fecha, mes : 'Julio',semanas : null).save(flush:true)
        def agosto = new Mes(fechaCreacion: fecha, mes : 'Agosto',semanas : null).save(flush:true)
        def septiembre = new Mes(fechaCreacion: fecha, mes : 'Septiembre',semanas : null).save(flush:true)
        def octubre = new Mes(fechaCreacion: fecha, mes : 'Octubre',semanas : null).save(flush:true)
        def noviembre = new Mes(fechaCreacion: fecha, mes : 'Noviembre',semanas : null).save(flush:true)
        def diciembre = new Mes(fechaCreacion: fecha, mes : 'Diciembre',semanas : null).save(flush:true)

        print enero

        def semana1 = new Semana(mes : enero ,numeroSemana: 1, descripcion: 'Semana 1').save(flush:true)
        def semana2 = new Semana(mes : enero ,numeroSemana: 2, descripcion: 'Semana 2').save(flush:true)
        def semana3 = new Semana(mes : enero ,numeroSemana: 3, descripcion: 'Semana 3').save(flush:true)
        def semana4 = new Semana(mes : enero ,numeroSemana: 4, descripcion: 'Semana 4').save(flush:true)
        def semana5 = new Semana(mes : enero ,numeroSemana: 5, descripcion: 'Semana 5').save(flush:true)

        print semana1


        def RoleAdmin = new Rol(authority: 'ROLE_ADMIN').save()
        def RoleZona = new Rol(authority: 'ROLE_ZONA').save()
        def RoleSuper = new Rol(authority: 'ROLE_SUPER').save()

        def testUser = new Usuario(username: 'admin', password: 'admin', nombre: 'Admin', apellidoPaterno: 'admin', apellidoMaterno: 'admin').save()
        def testUser2 = new Usuario(username: 'zonaScr', password: '9MNF6', nombre: 'Orlando de Jesus', apellidoPaterno: 'Jimenez', apellidoMaterno: 'Perez').save()
        def testUser3 = new Usuario(username: 'zonaTux', password: '9DP0D', nombre: 'Luis Antonio', apellidoPaterno: 'Cervanes', apellidoMaterno: 'Meza').save()
        def testUser4 = new Usuario(username: 'zonaOax', password: '9DM0W', nombre: 'Eden', apellidoPaterno: 'Vasquez', apellidoMaterno: 'Sibaja').save()
        def testUser5 = new Usuario(username: 'zonaHco', password: '9L0K7', nombre: 'Ruben', apellidoPaterno: 'Bautista', apellidoMaterno: 'Arroyo').save()
        def testUser6 = new Usuario(username: 'zonaHjp', password: '9DL0M', nombre: 'Luis Rey', apellidoPaterno: 'Fuentevilla', apellidoMaterno: 'Altamirano').save()
        def testUser7 = new Usuario(username: 'zonaTap', password: '9AMJN', nombre: 'Salomon', apellidoPaterno: 'Garcia', apellidoMaterno: 'Garcia').save()
        def testUser8 = new Usuario(username: 'zonaTeh', password: '9L0KB', nombre: 'Miguel Angel', apellidoPaterno: 'Velazquez', apellidoMaterno: 'Valencia').save()
        def testUser9 = new Usuario(username: 'zonaVsa', password: '9FKFP', nombre: 'Alberto', apellidoPaterno: 'Hernandez', apellidoMaterno: 'Perez').save()
        def testUser10 = new Usuario(username: 'zonaCho', password: '9B56G', nombre: 'Enrique', apellidoPaterno: 'Gonzalez', apellidoMaterno: 'Alejandro').save()
        def testUser11 = new Usuario(username: 'zonaLrs', password: '9L0EN', nombre: 'Josue', apellidoPaterno: 'Lopez', apellidoMaterno: 'Romero').save()
        def testUser12 = new Usuario(username: 'super', password: 'super', nombre: 'super', apellidoPaterno: 'super', apellidoMaterno: 'super').save()

        UsuarioRol.create testUser, RoleAdmin
        UsuarioRol.create testUser2, RoleZona
        UsuarioRol.create testUser3, RoleZona
        UsuarioRol.create testUser4, RoleZona
        UsuarioRol.create testUser5, RoleZona
        UsuarioRol.create testUser6, RoleZona
        UsuarioRol.create testUser7, RoleZona
        UsuarioRol.create testUser8, RoleZona
        UsuarioRol.create testUser9, RoleZona
        UsuarioRol.create testUser10, RoleZona
        UsuarioRol.create testUser11, RoleZona
        UsuarioRol.create testUser12, RoleSuper



        Concepto.withSession {
          it.flush()
          it.clear()
        }

        Semana.withSession {
          it.flush()
          it.clear()
        }

        Mes.withSession {
          it.flush()
          it.clear()
        }

        UsuarioRol.withSession {
            it.flush()
            it.clear()
        }

        assert Usuario.count() == 12
        assert Rol.count() == 3
        assert UsuarioRol.count() == 12

    }
    def destroy = {
    }
}
