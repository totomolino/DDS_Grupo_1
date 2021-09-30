package dominioBD;

import javax.persistence.*;

@Table(name = "preferencia_x_adoptante")
@Entity
public class PreferenciaXAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prefXado_id;

    private String prefXado_valor;

    @ManyToOne
    @JoinColumn(name = "pref_id")
    private PreferenciaBD prefXado_pref;

    @ManyToOne
    @JoinColumn(name = "pers_id")
    private AdoptanteBD prefXado_adoptante;

    public Long getPrefXado_id() {
        return prefXado_id;
    }

    public void setPrefXado_id(Long prefXado_id) {
        this.prefXado_id = prefXado_id;
    }

    public String getPrefXado_valor() {
        return prefXado_valor;
    }

    public void setPrefXado_valor(String prefXado_valor) {
        this.prefXado_valor = prefXado_valor;
    }

    public PreferenciaBD getPrefXado_pref() {
        return prefXado_pref;
    }

    public void setPrefXado_pref(PreferenciaBD prefXado_pref) {
        this.prefXado_pref = prefXado_pref;
    }

    public AdoptanteBD getPrefXado_adoptante() {
        return prefXado_adoptante;
    }

    public void setPrefXado_adoptante(AdoptanteBD prefXado_adoptante) {
        this.prefXado_adoptante = prefXado_adoptante;
    }
}