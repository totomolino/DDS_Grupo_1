package respuestas;

import dominioBD.MascotaBD;

public class devolverMascota extends claseJSon{

    private String masc_nombre;
    private String masc_apodo;
    private int masc_edad;
    private String masc_sexo;
    private String masc_especie;
    private String masc_descripcion;
    private Boolean masc_tieneChapita;
    private Long orga_id;
    private Long pers_id;

    public devolverMascota(MascotaBD mascota) {
        this.masc_nombre = mascota.getMasc_nombre();
        this.masc_apodo = mascota.getMasc_apodo();
        this.masc_edad = mascota.getMasc_edad();
        this.masc_sexo = mascota.getMasc_sexo();
        this.masc_especie = mascota.getMasc_especie();
        this.masc_descripcion = mascota.getMasc_descripcion();
        this.masc_tieneChapita = mascota.getMasc_tieneChapita();
        this.orga_id = mascota.getMasc_organizacion().getOrga_id();
        this.pers_id = mascota.getMasc_duenio().getPers_id();
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

    public Long getOrga_id() {
        return orga_id;
    }

    public void setOrga_id(Long orga_id) {
        this.orga_id = orga_id;
    }

    public Long getPers_id() {
        return pers_id;
    }

    public void setPers_id(Long pers_id) {
        this.pers_id = pers_id;
    }
}
