package dominioBD;

import javax.persistence.*;

@Table(name = "carac_org_xmascota")
@Entity
public class CaracOrgXmascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caorXmas_id;

    @ManyToOne
    @JoinColumn (name = "caor_id")
    private CaracteristicaOrg caorXmas_caor;

    @ManyToOne
    @JoinColumn(name = "masc_id")
    private MascotaBD caorXmas_mascota;


    private String caorXmas_valor;

    public Long getCaorXmas_id() {
        return caorXmas_id;
    }

    public void setCaorXmas_id(Long caorXmas_id) {
        this.caorXmas_id = caorXmas_id;
    }

    public CaracteristicaOrg getCaorXmas_caor() {
        return caorXmas_caor;
    }

    public void setCaorXmas_caor(CaracteristicaOrg caorXmas_caor) {
        this.caorXmas_caor = caorXmas_caor;
    }

    public MascotaBD getCaorXmas_mascota() {
        return caorXmas_mascota;
    }

    public void setCaorXmas_mascota(MascotaBD caorXmas_mascota) {
        this.caorXmas_mascota = caorXmas_mascota;
    }

    public String getCaorXmas_valor() {
        return caorXmas_valor;
    }

    public void setCaorXmas_valor(String caorXmas_valor) {
        this.caorXmas_valor = caorXmas_valor;
    }
}