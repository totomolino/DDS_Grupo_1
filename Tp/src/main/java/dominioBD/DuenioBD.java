package dominioBD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DuenioBD extends PersonaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long due_id;




}