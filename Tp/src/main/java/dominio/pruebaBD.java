package dominio;



import utils.BDUtils;
import javax.persistence.EntityManager;


public class pruebaBD {

    public static void main(String[] args) {
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        em.persist(new user((long)123,"nombre","contra","mail"));

        BDUtils.commit(em);
    }
}
