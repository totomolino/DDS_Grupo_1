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
}
