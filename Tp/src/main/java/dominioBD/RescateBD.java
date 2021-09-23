package dominioBD;

import javax.persistence.*;

@Table(name = "rescate_bd")
@Entity
public class RescateBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resc_id;

}