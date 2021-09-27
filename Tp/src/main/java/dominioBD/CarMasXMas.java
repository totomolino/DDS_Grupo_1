package dominioBD;

import javax.persistence.*;

@Table(name = "car_mas_x_mas")
@Entity
public class CarMasXMas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carac_id;

    private String clave;

}