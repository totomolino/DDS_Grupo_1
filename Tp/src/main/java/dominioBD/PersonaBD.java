package dominioBD;

import javax.persistence.*;

@Table(name = "persona")
@Entity
public class PersonaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pers_id;

}
