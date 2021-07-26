package Business;

import Sistema.Sistema;

import java.io.FileNotFoundException;

public class Usuario {

    TipoDeUsuario tipoDeUsuario;
    String nombre;
    String contrasenia;
    String email;

    public void validarContrasenia() throws FileNotFoundException {
        Sistema.validarContrasenia(contrasenia, nombre);
    }

    public Usuario(TipoDeUsuario tipoDeUsuario, String nombre, String contrasenia, String email){
        this.tipoDeUsuario = tipoDeUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    private String getContrasenia() {
        return contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void mostrarUsuario() {
        System.out.println("El nombre de usuario es: " + nombre);
        System.out.println("La contrasenia es: " + contrasenia);
        System.out.println("El mail es: " + email);
        System.out.println("__________________________________________________________________________");
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public TipoDeUsuario getTipo() {
        return tipoDeUsuario;
    }
}
