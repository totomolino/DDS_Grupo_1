package respuestas;

import dominioBD.UsuarioBD;
import utils.JsonTransformer;

public class usuarioCreado {
    String mensaje = "El usuario fue creado correctamente";
    UsuarioBD usuario;

    public String transformar(){
        return JsonTransformer.transformar(this);
    }

    public void setUsuario(UsuarioBD usuario) {
        this.usuario = usuario;
    }

    public usuarioCreado(UsuarioBD usuario) {
        this.usuario = usuario;
    }
}
