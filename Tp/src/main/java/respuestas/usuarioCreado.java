package respuestas;

import dominioBD.UsuarioBD;


public class usuarioCreado extends claseJSon{
    String mensaje = "El usuario fue creado correctamente";
    UsuarioBD usuario;



    public void setUsuario(UsuarioBD usuario) {
        this.usuario = usuario;
    }

    public usuarioCreado(UsuarioBD usuario) {
        this.usuario = usuario;
    }
}
