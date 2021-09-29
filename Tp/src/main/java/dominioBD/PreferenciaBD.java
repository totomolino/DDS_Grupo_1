package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "preferencia_bd")
@Entity
public class PreferenciaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pref_id;

    private String pref_clave;

    @OneToMany (mappedBy = "prefXado_pref")
    private List<PreferenciaXAdoptante> preferenciaXAdoptantes;

    public Long getPref_id() {
        return pref_id;
    }

    public void setPref_id(Long pref_id) {
        this.pref_id = pref_id;
    }

    public String getPref_clave() {
        return pref_clave;
    }

    public void setPref_clave(String pref_clave) {
        this.pref_clave = pref_clave;
    }

    public List<PreferenciaXAdoptante> getPreferenciaXAdoptantes() {
        return preferenciaXAdoptantes;
    }

    public void setPreferenciaXAdoptantes(List<PreferenciaXAdoptante> preferenciaXAdoptantes) {
        this.preferenciaXAdoptantes = preferenciaXAdoptantes;
    }
}

