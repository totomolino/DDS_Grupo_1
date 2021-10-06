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

        List<UsuarioBD> usuarioBDS = (List<UsuarioBD>) manager.createQuery("FROM UsuarioBD").getResultList();

        System.out.println("Hay " + usuarioBDS.size() + " usuarios");
    }
}
