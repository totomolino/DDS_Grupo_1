package dominioBD;

import javax.persistence.*;

@Table(name = "caracteristica_mascota")
@Entity
public class CaracteristicaMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long como_id;


}