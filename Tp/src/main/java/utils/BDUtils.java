package utils;

import dominioBD.MascotaBD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BDUtils {

    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("aplicacion");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void comenzarTransaccion(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
    }

    public static void commit(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        if (tx.isActive()) {
            tx.commit();
        }
    }

    public static void rollback(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        if (tx.isActive()) {
            tx.rollback();
        }
    }

    public static void agregarObjeto(Object unObjeto) {
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        em.persist(unObjeto);

        BDUtils.commit(em);
    }

    public static boolean puedoEsteNombre(String nombre){
        EntityManager em = BDUtils.getEntityManager();

        String hola = "select usu_nombre from UsuarioBD where usu_nombre = '" + nombre + "'";

        return em.createQuery(hola).getResultList().isEmpty();
    }

    public static boolean verificarContrasenia(String emailOusuario, String contrasenia){
        EntityManager em = BDUtils.getEntityManager();

        String consultaUsuario = "select usu_contrasena from UsuarioBD where usu_nombre = '" + emailOusuario + "' and usu_contrasena = '" + contrasenia + "'";
        String consultaEmail = "select usu_contrasena from UsuarioBD where usu_email = '" + emailOusuario + "' and usu_contrasena = '" + contrasenia + "'";

        return !(em.createQuery(consultaEmail).getResultList().isEmpty() && em.createQuery(consultaUsuario).getResultList().isEmpty());
    }


    public static MascotaBD buscarMascota(int id) {
        EntityManager em = BDUtils.getEntityManager();

        return (MascotaBD) em.createQuery("from MascotaBD where masc_id= '"+id+"'").getResultList().get(0);

    }
}