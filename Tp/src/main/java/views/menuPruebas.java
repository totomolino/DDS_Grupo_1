package views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Business.Contacto;
import Business.TipoDeUsuario;
import Business.Usuario;
import Notificar.EMAIL;
import Notificar.SMS;
import Notificar.WHATSAPP;
import Notificar.notificarStrategy;
import Sistema.Sistema;

public class menuPruebas {
    Usuario usuario;
    public void iniciarMenu() throws IOException{

        Scanner sn = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        String respuestaCompleja;   // Guardaremos la respuesta compleja del usuario
        Sistema miSistema = Sistema.getInstancia();

        while (!salir) {

            System.out.println("1. registrar mascota");
            System.out.println("2. crear usuario");
            System.out.println("3. iniciar sesion");
            System.out.println("4. mostrar usuarios");
            System.out.println("99. Salir");


            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:

                        break;
                    case 2:
                        System.out.println("Has seleccionado Crear Usuario");
                        System.out.println("Ingrese Usuario");
                        String usuarioProvisorio = str.nextLine();
                        while (Sistema.usuarioNoValido(usuarioProvisorio)) {
                            System.out.println("Nombre de usuario no valido, vuelva a intentarlo");
                            usuarioProvisorio = str.nextLine();
                        }
                        System.out.println("Ingrese Contrasena");
                        String contrasenaProvisoria = str.nextLine();
                        while (!(miSistema.validarContrasenia(contrasenaProvisoria, usuarioProvisorio))) {
                            System.out.println("Contrasena no valida, vuelva a intentarlo");
                            contrasenaProvisoria = str.nextLine();
                        }
                        TipoDeUsuario tipoDeUsuario = this.recibirTipo();
                        System.out.println("Ingrese email");
                        String mailUsuario = str.nextLine();
                     //   usuario = miSistema.crearUsuario(usuarioProvisorio, contrasenaProvisoria, tipoDeUsuario, mailUsuario);
                        this.pedirDatosExtra(usuario, miSistema);
                        System.out.println("Usuario creado exitosamente!!");
                        break;
                    case 3:

                        break;
                    case 4:
                        Sistema.mostrarUsuarios();
                        break;
                    case 99:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        System.out.println("Finalizado con exito! Nos vemos broustoun!");
    }

    private void pedirDatosExtra(Usuario usuario, Sistema miSistema) {

        if(usuario.getTipo() == TipoDeUsuario.DUENIO || usuario.getTipo() == TipoDeUsuario.RESCATISTA || usuario.getTipo() == TipoDeUsuario.ADOPTANTE) {
            this.crearPersona(usuario, miSistema);
        } else if (usuario.getTipo() == TipoDeUsuario.VOLUNTARIO) {
            this.crearVoluntario(usuario);
        } else if(usuario.getTipo() == TipoDeUsuario.ADMIN) {
            this.crearAdmin(usuario);
        }
    }

    private void crearVoluntario(Usuario usuario) {
    }

    private void crearAdmin(Usuario usuario) {
    }

    private boolean puedoAgregar(List<notificarStrategy> lista, notificarStrategy notificar) {
        return !(lista.contains(notificar));
    }

    private void crearPersona(Usuario usuario, Sistema miSistema) {
        Scanner st = new Scanner(System.in);
        Scanner intSc = new Scanner(System.in);

        System.out.println("Ingrese nombre");
        String nombre = st.nextLine();
        System.out.println("Ingrese apellido");
        String apellido = st.nextLine();
        System.out.println("Ingrese telefono");
        String telefono = st.nextLine();
        System.out.println("Ingrese fecha nacimiento");
        String fechaNacimiento = st.nextLine();
        System.out.println("Ingrese tipo de documento");
        String tipoDoc = st.nextLine();
        System.out.println("Ingrese numero documento");
        int numDocumento = intSc.nextInt();
        List<notificarStrategy> formasDeNotificacion = this.obtenerMediosDeNotificacion();
        List<Contacto> contactos = new ArrayList<>();
        this.agregarContacto(contactos);
        if(usuario.getTipo() == TipoDeUsuario.DUENIO ) {
            miSistema.agregarDuenio(nombre,apellido, telefono, fechaNacimiento, tipoDoc, numDocumento, formasDeNotificacion, contactos, usuario);
        } else if(usuario.getTipo() == TipoDeUsuario.RESCATISTA) {
            miSistema.agregarRescatista(nombre,apellido, telefono, fechaNacimiento, tipoDoc, numDocumento, formasDeNotificacion, contactos, usuario);
        } else if (usuario.getTipo() == TipoDeUsuario.ADOPTANTE) {
            miSistema.agregarAdoptante(nombre,apellido, telefono, fechaNacimiento, tipoDoc, numDocumento, formasDeNotificacion, contactos, usuario);
        }

    }

    private void agregarContacto(List<Contacto> lista){
        Scanner st = new Scanner(System.in);
        System.out.println("Ingrese un contacto: ");
        System.out.println("Ingrese nombre");
        String nombreC = st.nextLine();
        System.out.println("Ingrese apellido");
        String apellidoC = st.nextLine();
        System.out.println("Ingrese telefono");
        String telefonoC = st.nextLine();
        List<notificarStrategy> notifC = this.obtenerMediosDeNotificacion();
        System.out.println("Ingrese telefono");
        String mailC = st.nextLine();
       // Contacto unContacto = new Contacto(nombreC, apellidoC, telefonoC, notifC, mailC);
        //lista.add(unContacto);
    }

    private List<notificarStrategy> obtenerMediosDeNotificacion() {
        boolean quieroOtro = true;
        int opcion;
        Scanner sn = new Scanner(System.in);
        Scanner snn = new Scanner(System.in);
        List<notificarStrategy> lista = new ArrayList<>();

        while(quieroOtro) {
            System.out.println("MEDIOS DE NOTIFICACION");
            System.out.println("1. WHATSAPP");
            System.out.println("2. EMAIL");
            System.out.println("3. SMS");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:
                        WHATSAPP notificar = new WHATSAPP();
                        if(this.puedoAgregar(lista, notificar)) {
                            lista.add(notificar);
                        }
                        break;
                    case 2:
                        EMAIL notificar2 = new EMAIL();
                        if(this.puedoAgregar(lista, notificar2)) {
                            lista.add(notificar2);
                        }
                        break;
                    case 3:
                        SMS notificar3 = new SMS();
                        if(this.puedoAgregar(lista, notificar3)) {
                            lista.add(notificar3);
                        }
                        break;
                    case 4:
                        quieroOtro = false;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
            System.out.println("Presione 1 para agregar otro medio de notificacion");
            String respuesta = snn.nextLine();
            if(!(respuesta.equals("1"))){
                quieroOtro = false;
            }
        }
        return lista;
}


    private TipoDeUsuario recibirTipo() {
        Scanner sn = new Scanner(System.in);
        int opcion; //Guardaremos la opcion del usuario
        boolean noTermine = true;
        TipoDeUsuario miUsuario = null;

        while (noTermine) {

            System.out.println("1. ADMINISTRADOR");
            System.out.println("2. VOLUNTARIO");
            System.out.println("3. DUENIO");
            System.out.println("4. RESCATISTA");
            System.out.println("5. ADOPTANTE");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:
                        noTermine = false;
                        miUsuario = TipoDeUsuario.ADMIN;
                        break;
                    case 2:
                        noTermine = false;
                        miUsuario = TipoDeUsuario.VOLUNTARIO;
                        break;
                    case 3:
                        noTermine = false;
                        miUsuario = TipoDeUsuario.DUENIO;
                        break;
                    case 4:
                        noTermine = false;
                        miUsuario = TipoDeUsuario.RESCATISTA;
                        break;
                    case 5:
                        noTermine = false;
                        miUsuario = TipoDeUsuario.ADOPTANTE;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        return miUsuario;
    }
}
