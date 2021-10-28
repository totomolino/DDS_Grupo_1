package Business;

public class Administrador
{
    Organizacion miOrganizacion;
    Usuario usuario;

    public Administrador(Organizacion miOrganizacion, String nombreUsuario, String contrasenia, String email) {
        this.miOrganizacion = miOrganizacion;
        //usuario = new Usuario(TipoDeUsuario.ADMIN, nombreUsuario, contrasenia, email);
    }

    public void setOrganizacion(Organizacion organizacion){
        this.miOrganizacion = organizacion;
    }

    public void agregarCaracteristica(String unaCaracteristica) {
        miOrganizacion.agregarCaracteristica(unaCaracteristica);
    }

    public void Administrador(Administrador unAdmin) {
        unAdmin.setOrganizacion(miOrganizacion);
        miOrganizacion.agregarAdmin(unAdmin);
    }
}
