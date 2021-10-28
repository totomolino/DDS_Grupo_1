package dominioBD;

import Business.TipoDeUsuario;
import Business.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_id;

    private String usu_nombre;

    private String usu_contrasena;

    private String usu_email;

    private String usu_tipo;


    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_contrasena() {
        return usu_contrasena;
    }

    public void setUsu_contrasena(String usu_contrasena) {
        this.usu_contrasena = usu_contrasena;
    }

    public String getUsu_mail() {
        return usu_email;
    }

    public void setUsu_mail(String usu_mail) {
        this.usu_email = usu_mail;
    }

    public String getUsu_tipo() {
        return usu_tipo;
    }

    public void setUsu_tipo(String usu_tipo) {
        this.usu_tipo = usu_tipo;
    }

    public Usuario transformar() {
        TipoDeUsuario tipo = TipoDeUsuario.valueOf(usu_tipo);
        Usuario usuario = new Usuario(usu_id,tipo,usu_nombre,usu_contrasena,usu_email);
        return usuario;
    }
}