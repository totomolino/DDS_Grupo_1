package dominioBD;

import javax.persistence.*;

@Table(name = "forma_notif_cont")
@Entity
public class FormaNotifCont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fonoc_id;

    @ManyToOne
    @JoinColumn(name = "cont_id")
    private ContactoBD fonoc_contacto;

    private String fonoc_forma;


}