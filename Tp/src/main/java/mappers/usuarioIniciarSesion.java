package mappers;

public class usuarioIniciarSesion {

    String usuario_Email;
    String contrasenia;

    public usuarioIniciarSesion(String usuarioOEmail, String contrasenia) {
        this.usuario_Email = usuarioOEmail;
        this.contrasenia = contrasenia;
    }

    public String getUsuario_Email() {
        return usuario_Email;
    }

    public void setUsuario_Email(String usuario_Email) {
        this.usuario_Email = usuario_Email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
