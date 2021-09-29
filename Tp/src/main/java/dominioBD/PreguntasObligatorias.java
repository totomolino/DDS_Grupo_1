package dominioBD;

import javax.persistence.*;

@Table(name = "preguntas_obligatorias")
@Entity
public class PreguntasObligatorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prob_id;

    private String prob_pregunta;

}