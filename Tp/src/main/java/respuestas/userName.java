package respuestas;

public class userName {

    String nombre;

    Long persId;

    public userName(String nombre, Long persId) {
        this.nombre = nombre;
        this.persId = persId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPersId() {
        return persId;
    }

    public void setPersId(Long persId) {
        this.persId = persId;
    }
}
