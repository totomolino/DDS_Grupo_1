package dominioBD;

import utils.BDUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class prueba {

    private static EntityManager manager;

    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

    }
}
