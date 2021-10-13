package dominioBD;

import javax.persistence.*;

@Entity
public class pregPublicacionDarEnAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preg_id;


    @ManyToOne
    @JoinColumn(name = "pdar_mascota")
    PublicacionDarEnAdopcion preg_publi;

    private String pregunta;
    private String respuesta;

    public Long getPreg_id() {
        return preg_id;
    }

    public void setPreg_id(Long preg_id) {
        this.preg_id = preg_id;
    }

    public PublicacionDarEnAdopcion getPreg_publi() {
        return preg_publi;
    }

    public void setPreg_publi(PublicacionDarEnAdopcion preg_publi) {
        this.preg_publi = preg_publi;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
