package dominioBD;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_id;

    private String usu_nombre;

    private String usu_contrasena;

    private String usu_mail;


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
        return usu_mail;
    }

    public void setUsu_mail(String usu_mail) {
        this.usu_mail = usu_mail;
    }
}