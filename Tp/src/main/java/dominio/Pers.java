package dominio;

import javax.persistence.*;

@Entity
public class Pers {
    @Id
    @GeneratedValue
    private Long pers_codigo;

    private String pers_nombre;

    private String pers_apellido;

    private String pers_telefono;

    private String pers_fechaNac;

    private String pers_tipoDoc;

    private Long pers_numeroDoc;

    public Pers(String pers_nombre, String pers_apellido, String pers_telefono, String pers_fechaNac, String pers_tipoDoc, Long pers_numeroDoc) {
        this.pers_nombre = pers_nombre;
        this.pers_apellido = pers_apellido;
        this.pers_telefono = pers_telefono;
        this.pers_fechaNac = pers_fechaNac;
        this.pers_tipoDoc = pers_tipoDoc;
        this.pers_numeroDoc = pers_numeroDoc;
    }

    @OneToOne
    @JoinColumn(name = "usu_codigo", referencedColumnName = "Id")
    private user usuario;


    // getters, setters
}
