package dominioBD;

import javax.persistence.*;

@Table(name = "rescate_bd")
@Entity
public class RescateBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resc_id;

    @ManyToOne
    @JoinColumn(name = "pers_id") //No se si sacar rescatista o que mierda
    private PersonaBD rescatista;


    private int id_Mascota;

    //fotos faltan ah

    private String descripcionEstado;

    private float lugarEncuentroX;
    private float lugarEncuentroY;



}