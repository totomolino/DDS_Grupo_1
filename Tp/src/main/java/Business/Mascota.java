package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mascota {
    
    Long id;
    List<Foto> fotos = new ArrayList<>();
    Especie especie;
    String nombre;
    String apodo;
    int edad;
    String sexo;
    String descripcion;
    boolean tieneChapita;
    Duenio duenio;
    HashMap<String, String> caracteristicas;

    

    
    public Mascota(Long id, List<Foto> fotos, Especie especie, String nombre, String apodo, int edad, String sexo, String descripcion, boolean tieneChapita, HashMap<String, String> caracteristicas, Duenio duenio) {
        this.id = id;
        this.fotos = fotos;
        this.especie = especie;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.tieneChapita = tieneChapita;
        this.caracteristicas = caracteristicas;
        this.duenio= duenio;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTieneChapita() {
        return tieneChapita;
    }

    public void setTieneChapita(boolean tieneChapita) {
        this.tieneChapita = tieneChapita;
    }

    public void serRescatado() {
        duenio.notificarMascotaEncontrada(this);
    }
}

