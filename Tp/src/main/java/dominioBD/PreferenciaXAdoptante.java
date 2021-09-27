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
    private PreferenciaBD preferencia_bd;

}