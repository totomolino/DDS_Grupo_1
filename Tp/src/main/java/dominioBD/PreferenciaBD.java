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

    @OneToMany (mappedBy = "preferencia_bd")
    private List<PreferenciaXAdoptante> preferenciaXAdoptantes;


}

