package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "mascota_bd")
@Entity
public class MascotaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long masc_id;
    private String masc_nombre;
    private String masc_apodo;
    private int masc_edad;
    private String masc_sexo;
    private String masc_especie;
    private String masc_descripcion;
    private Boolean masc_tieneChapita;


    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizacionBD organizacion;

    @ManyToOne
    @JoinColumn(name = "persona_pers_id")
    private PersonaBD persona;

    @OneToMany (mappedBy = "carMasMas_mascota")
    private List<CarMasXMas> carMasXMas;

    public PersonaBD getPersona() {
        return persona;
    }

    public void setPersona(PersonaBD persona) {
        this.persona = persona;
    }

    public Long getMasc_id() {
        return masc_id;
    }

    public void setMasc_id(Long masc_id) {
        this.masc_id = masc_id;
    }

    public String getMasc_nombre() {
        return masc_nombre;
    }

    public void setMasc_nombre(String masc_nombre) {
        this.masc_nombre = masc_nombre;
    }

    public String getMasc_apodo() {
        return masc_apodo;
    }

    public void setMasc_apodo(String masc_apodo) {
        this.masc_apodo = masc_apodo;
    }

    public int getMasc_edad() {
        return masc_edad;
    }

    public void setMasc_edad(int masc_edad) {
        this.masc_edad = masc_edad;
    }

    public String getMasc_sexo() {
        return masc_sexo;
    }

    public void setMasc_sexo(String masc_sexo) {
        this.masc_sexo = masc_sexo;
    }

    public String getMasc_especie() {
        return masc_especie;
    }

    public void setMasc_especie(String masc_especie) {
        this.masc_especie = masc_especie;
    }

    public String getMasc_descripcion() {
        return masc_descripcion;
    }

    public void setMasc_descripcion(String masc_descripcion) {
        this.masc_descripcion = masc_descripcion;
    }

    public Boolean getMasc_tieneChapita() {
        return masc_tieneChapita;
    }

    public void setMasc_tieneChapita(Boolean masc_tieneChapita) {
        this.masc_tieneChapita = masc_tieneChapita;
    }
}