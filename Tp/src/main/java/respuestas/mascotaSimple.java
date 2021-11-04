package respuestas;

import Business.Foto;
import Business.Mascota;
import dominioBD.FotoAnimales;
import dominioBD.MascotaBD;

import java.util.List;

public class mascotaSimple extends claseJSon{

    String nombre;
    String sexo;
    int edad;
    List<Foto> fotoAnimales;

    public mascotaSimple(Mascota mascota) {
        this.nombre = mascota.getNombre();
        this.sexo = mascota.getSexo();
        this.edad = mascota.getEdad();
        this.fotoAnimales = mascota.getFotos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Foto> getFotoAnimales() {
        return fotoAnimales;
    }

    public void setFotoAnimales(List<Foto> fotoAnimales) {
        this.fotoAnimales = fotoAnimales;
    }
}
