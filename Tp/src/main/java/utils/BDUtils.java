package utils;

import Business.*;
import Business.publicaciones.PublicacionDarEnAdopcion;
import Notificar.notificarStrategy;
import dominioBD.*;


import javax.persistence.*;
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

        String consulta = "select usu_contrasena from UsuarioBD where usu_nombre = '" + emailOusuario +"' or usu_email = '" + emailOusuario +"'";

        Query query1 = em.createQuery(consulta);

        Object contra1 = (String) query1.getResultList().get(0);


        return contra1.equals(contrasenia) ;
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

        List<FormaNotifCont> formaNotifCont = em.createQuery("from FormaNotifCont where fonoc_contacto.cont_id = '"+id+"'").getResultList();

        return formaNotifCont.stream().map(forma -> forma.transformar()).collect(Collectors.toList());


    }

    public static List<Foto> dameFotosMasc(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        List<FotoAnimales> fotos = em.createQuery("from FotoAnimales where fani_masc.masc_id = '"+id+"'").getResultList();

        return fotos.stream().map(foto -> foto.transformar()).collect(Collectors.toList());


    }

    public static HashMap<String,String> dameHashCaracteristicasMasc(Long id) {
        EntityManager em = BDUtils.getEntityManager();

        MascotaBD mascota = em.find(MascotaBD.class, id);

        HashMap<String, String> res = new HashMap<String,String>();

        mascota.getCarMasXMas().stream().map(carMasXMas -> res.put(carMasXMas.getCarMasMas_carmas().getClave(), carMasXMas.getCarMasMas_valor())).collect(Collectors.toList());

        return res;
    }


    public static HashMap<String, String> dameHashPreguntasPubli(Long id) {
        EntityManager em = BDUtils.getEntityManager();

        List<pregPublicacionDarEnAdopcion> preguntas = em.createQuery("from pregPublicacionDarEnAdopcion where preg_publi = '"+id+"'").getResultList();

        HashMap<String, String> res = new HashMap<String,String>();
        preguntas.stream().map(p -> res.put(p.getPregunta(), p.getRespuesta())).collect(Collectors.toList());
        return res;

    }

    public static Adoptante buscarAdoptante(Long personaID) {

        EntityManager em = BDUtils.getEntityManager();

        AdoptanteBD adoptanteBD = em.find(AdoptanteBD.class,personaID);

        return adoptanteBD.transformar();



    }

    public static HashMap<String, String> dameComodidadesAdoptante(Long id) {


        EntityManager em = BDUtils.getEntityManager();

        AdoptanteBD adoptanteBD = em.find(AdoptanteBD.class,id);

        HashMap<String, String> res = new HashMap<String,String>();

        adoptanteBD.getComodidades().stream().map(comodidadesXadoptante -> res.put(comodidadesXadoptante.getComoXad_como().getComo_clave(), comodidadesXadoptante.getComXado_valor())).collect(Collectors.toList());

        return res;


    }

    public static HashMap<String, String> damePreferenciasAdoptante(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        AdoptanteBD adoptanteBD = em.find(AdoptanteBD.class,id);

        HashMap<String, String> res = new HashMap<String,String>();

        adoptanteBD.getPreferencias().stream().map(preferenciaXAdoptante -> res.put(preferenciaXAdoptante.getPrefXado_pref().getPref_clave(), preferenciaXAdoptante.getPrefXado_valor())).collect(Collectors.toList());

        return res;

    }

    public static Usuario dameUsuario(String usuario_email, String contrasenia) {

        EntityManager em = BDUtils.getEntityManager();

        UsuarioBD usuarioBD = (UsuarioBD) em.createQuery("from UsuarioBD where usu_nombre = '" + usuario_email +"' or usu_email = '" + usuario_email +"' and usu_contrasena = '" + contrasenia + "'").getResultList().get(0);


        return usuarioBD.transformar();
    }

    public static DuenioBD dameDuenio(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        DuenioBD duenio = (DuenioBD) em.createQuery("from DuenioBD where pers_usuario.usu_id = '"+id+"'").getResultList().get(0);

        return duenio;

    }

    public static boolean puedoEsteMail(String email) {

        EntityManager em = BDUtils.getEntityManager();

        String hola = "select usu_email from UsuarioBD where usu_email = '" + email + "'";

        return em.createQuery(hola).getResultList().isEmpty();
    }

    public static PersonaBD dameIdPersona(Long id) {

        EntityManager em = BDUtils.getEntityManager();

        PersonaBD persona = (PersonaBD) em.createQuery("from PersonaBD where pers_usuario = '" + id + "'").getResultList().get(0);

        return persona;

    }

    public static List<CaracteristicaOrg> dameCarateristicasOrg(int id) {

        EntityManager em = BDUtils.getEntityManager();

        List<CaracteristicaOrg> caracteristicas = em.createQuery("from CaracteristicaOrg where caor_organizacion = '" + id + "'").getResultList();

        return caracteristicas;

    }
}