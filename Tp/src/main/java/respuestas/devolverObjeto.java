package respuestas;

public class devolverObjeto extends claseJSon{

    Object objeto;

    String mensaje;

    public devolverObjeto(Object objeto, String mensaje) {
        this.objeto = objeto;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
