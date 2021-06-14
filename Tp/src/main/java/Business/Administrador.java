package Business;

public class Administrador
{

    Organizacion miOrganizacion;

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
