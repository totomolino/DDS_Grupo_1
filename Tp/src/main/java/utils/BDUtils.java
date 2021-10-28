package utils;

import Business.Contacto;
import Business.Foto;
import Business.publicaciones.Publicacion;
import Business.publicaciones.PublicacionDarEnAdopcion;
import Notificar.notificarStrategy;
import dominioBD.*;
import mappers.caracteristicasMasc;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<MascotaBD> dameMascotas(){
        EntityManager em = BDUtils.getEntityManager();

        return em.createQuery("from MascotaBD").getResultList();
    }


    public static List<PublicacionDarEnAdopcion> damePublicacionesAdopcion() {

        EntityManager em = BDUtils.getEntityManager();

        List<PublicacionDarEnAdopcionBD> publicaciones = em.createQuery("from PublicacionDarEnAdopcionBD ").getResultList();

        return publicaciones.stream().map(publi -> publi.transformar()).collect(Collectors.toList());
    }

    public static List<notificarStrategy> dameListaNotif(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        List<FormaNotifPers> formaNotifPers = em.createQuery("from FormaNotifPers where fonop_persona.pers_id = '"+id+"'").getResultList();

        return formaNotifPers.stream().map(forma -> forma.transformar()).collect(Collectors.toList());

    }

    public static List<Contacto> dameContactos(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        List<ContactoBD> contactoBDS = em.createQuery("from ContactoBD where cont_persona.pers_id = '"+id+"'").getResultList();

        return contactoBDS.stream().map(contactoBD -> contactoBD.transformar()).collect(Collectors.toList());


    }

    public static List<notificarStrategy> dameListaNotifCont(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        List<FormaNotifPers> formaNotifPers = em.createQuery("from FormaNotifCont where fonoc_contacto.cont_id = '"+id+"'").getResultList();

        return formaNotifPers.stream().map(forma -> forma.transformar()).collect(Collectors.toList());


    }

    public static List<Foto> dameFotosMasc(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        List<FotoAnimales> fotos = em.createQuery("from FotoAnimales where fani_masc.masc_id = '"+id+"'").getResultList();

        return fotos.stream().map(foto -> foto.transformar()).collect(Collectors.toList());


    }

    public static HashMap<String,String> dameHashCaracteristicasMasc(Long id) {
        EntityManager em = BDUtils.getEntityManager();

        List<caracteristicasMasc> unaLista = em.createQuery("select CaracteristicaMascota.carmas_clave as pregunta , CarMasXMas.carMasMas_valor as respuesta " +
                "                                               from CarMasXMas " +
                "                                               join CaracteristicaMascota " +
                "                                               on CaracteristicaMascota.carmas_id = CarMasXMas.carMasMas_carmas.carmas_id " +
                "                                               where CarMasXMas.carMasMas_mascota.masc_id = '"+id+"'").getResultList();

        HashMap<String, String> res = new HashMap<String,String>();

        unaLista.stream().map(p -> res.put(p.getPregunta(), p.getRespuesta())).collect(Collectors.toList());

        return res;
    }


    public static HashMap<String, String> dameHashPreguntasPubli(Long id) {
        EntityManager em = BDUtils.getEntityManager();

        List<pregPublicacionDarEnAdopcion> preguntas = em.createQuery("from pregPublicacionDarEnAdopcion where preg_publi = '"+id+"'").getResultList();

        HashMap<String, String> res = new HashMap<String,String>();
        preguntas.stream().map(p -> res.put(p.getPregunta(), p.getRespuesta())).collect(Collectors.toList());
        return res;

    }
}