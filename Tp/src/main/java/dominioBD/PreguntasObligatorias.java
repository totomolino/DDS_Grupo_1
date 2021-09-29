package dominioBD;

import javax.persistence.*;

@Table(name = "preguntas_obligatorias")
@Entity
public class PreguntasObligatorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prob_id;

    private String prob_pregunta;

    public Long getProb_id() {
        return prob_id;
    }

    public void setProb_id(Long prob_id) {
        this.prob_id = prob_id;
    }

    public String getProb_pregunta() {
        return prob_pregunta;
    }

    public void setProb_pregunta(String prob_pregunta) {
        this.prob_pregunta = prob_pregunta;
    }
}