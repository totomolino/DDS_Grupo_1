package dominioBD;

import utils.BDUtils;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;


public class pruebaBD {

    public static void main(String[] args) {
/*
        Curso unCurso = new Curso();
        unCurso.setCantidad(7);
        agregarObjeto(unCurso);*/
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);


    }
    public static void agregarObjeto(Object unObjeto) {
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        em.persist(unObjeto);

        BDUtils.commit(em);
    }
}