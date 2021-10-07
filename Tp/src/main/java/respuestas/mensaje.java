package respuestas;

import utils.JsonTransformer;

public class mensaje {
    String mensaje;


    public mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String transformar(){
        return JsonTransformer.transformar(this);
    }

}
