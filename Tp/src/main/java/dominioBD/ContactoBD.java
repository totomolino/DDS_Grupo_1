package dominioBD;

import javax.persistence.*;

@Table(name = "contacto_bd")
@Entity
public class ContactoBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cont_id;

    private String cont_nombre;
    private String cont_apellido;
    private String cont_telefono;
    private String cont_email;

    @ManyToOne
    @JoinColumn (name = "id_persona")
        private PersonaBD persona;




}