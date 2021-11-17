package dominioBD;

import Business.Foto;

import javax.persistence.*;
import java.util.List;

@Table(name = "foto_animales")
@Entity
public class FotoAnimales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fani_id;

    @ManyToOne
    @JoinColumn(name = "masc_id")
    private MascotaBD fani_masc;

    @Column(columnDefinition="longtext")
    private String fani_direccion;

    public Long getFani_id() {
        return fani_id;
    }

    public void setFani_id(Long fani_id) {
        this.fani_id = fani_id;
    }

    public MascotaBD getFani_masc() {
        return fani_masc;
    }

    public void setFani_masc(MascotaBD fani_masc) {
        this.fani_masc = fani_masc;
    }

    public String getFani_direccion() {
        return fani_direccion;
    }

    public void setFani_direccion(String fani_direccion) {
        this.fani_direccion = fani_direccion;
    }

    public Foto transformar(){
        return new Foto(fani_id,fani_direccion);
    }

}