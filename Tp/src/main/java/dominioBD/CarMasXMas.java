package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "car_mas_x_mas")
@Entity
public class CarMasXMas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carMasMas_id;

    @ManyToOne
    @JoinColumn(name = "carmas_id")
    private CaracteristicaMascota carMasMas_carmas;

    @ManyToOne
    @JoinColumn(name = "masc_id")
    private MascotaBD carMasMas_mascota;

    private String carMasMas_valor;

    public Long getCarMasMas_id() {
        return carMasMas_id;
    }

    public void setCarMasMas_id(Long carMasMas_id) {
        this.carMasMas_id = carMasMas_id;
    }

    public CaracteristicaMascota getCarMasMas_carmas() {
        return carMasMas_carmas;
    }

    public void setCarMasMas_carmas(CaracteristicaMascota carMasMas_carmas) {
        this.carMasMas_carmas = carMasMas_carmas;
    }

    public MascotaBD getCarMasMas_mascota() {
        return carMasMas_mascota;
    }

    public void setCarMasMas_mascota(MascotaBD carMasMas_mascota) {
        this.carMasMas_mascota = carMasMas_mascota;
    }

    public String getCarMasMas_valor() {
        return carMasMas_valor;
    }

    public void setCarMasMas_valor(String carMasMas_valor) {
        this.carMasMas_valor = carMasMas_valor;
    }
}