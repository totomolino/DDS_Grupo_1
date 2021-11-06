package respuestas;

public class loginResponse extends claseJSon{

    String idSesion;
    String tipo;

    public loginResponse(String idSesion, String tipo) {
        this.idSesion = idSesion;
        this.tipo = tipo;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
