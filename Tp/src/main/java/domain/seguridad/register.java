package domain.seguridad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class register {
    /*
    public static boolean existeUsuario(String usuario){
    }
    */

    public static boolean esFacil(String unaContrasenia) throws FileNotFoundException {

        //LLENAMOS LA LISTA
        File file = new File("../contras.txt");
        Scanner scan = new Scanner(file);

        List<String> contraseniasFaciles = new ArrayList<>();

        while(scan.hasNextLine()){
            contraseniasFaciles.add(scan.nextLine());
        }
        return contraseniasFaciles.contains(unaContrasenia);
    }

    public static boolean validarContrasenia(String unaContrasenia, String unUsuario) throws FileNotFoundException {
        return reglasNist.cumpleLasReglas(unaContrasenia, unUsuario) && !(register.esFacil(unaContrasenia)) ;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //para leer la consola -> CIN
        Scanner entrada;
        entrada = new Scanner(System.in);

        System.out.println("Ingrese un Usuario: ");
        String usuario= entrada.nextLine();

        /*
        if(!register.existeUsuario(usuario)){

        }
        */

        System.out.println("Ingrese una contrasenia: ");
        String contra = entrada.nextLine();

        while(!(register.validarContrasenia(contra, usuario))){
            System.out.println("Ingrese una nueva contrasenia, la anterior no cumple las condiciones: ");
            contra = entrada.nextLine();
        }
    }
}

class reglasNist {

    static int largoMinimo = 8;
    static int largoMaximo = 64;

    static boolean cumpleLasReglas(String unaContrasenia, String unUsuario) {


        return reglasNist.cumpleLargo(unaContrasenia) &&
                reglasNist.usuarioYContraDistintos(unaContrasenia, unUsuario) &&
                !(reglasNist.mismoCaracterRepetido(unaContrasenia)) &&
                !(reglasNist.esIncremental(unaContrasenia)) &&
                !(reglasNist.esDecremental(unaContrasenia)) &&
                cumpleReglasSintacticas(unaContrasenia);
    }

    static boolean cumpleLargo(String unaContrasenia) {

        int longitud = unaContrasenia.length();

        return (largoMinimo <= longitud && longitud <= largoMaximo);
    }

    static boolean usuarioYContraDistintos(String unaContrasenia, String unUsuario) {
        return !(unUsuario.equals(unaContrasenia));
    }

    static boolean mismoCaracterRepetido(String unaContrasenia) {

        char[] ArrayContrasenia = unaContrasenia.toCharArray();
        char primerCaracter = ArrayContrasenia[0];
        int i = 0, largoContrasenia = unaContrasenia.length();


        while (i < largoContrasenia && primerCaracter == ArrayContrasenia[i]) {
            i++;
        }
        return largoContrasenia == i;
    }

    static boolean esIncremental(String unaContrasenia) {

        char[] ArrayContrasenia = unaContrasenia.toCharArray();
        char primerCaracter = ArrayContrasenia[0];
        int i = 0, largoContrasenia = unaContrasenia.length();


        while (i < largoContrasenia && (primerCaracter + i) == ArrayContrasenia[i]) {
            i++;
        }
        return largoContrasenia == i;
    }

    static boolean esDecremental(String unaContrasenia) {

        char[] ArrayContrasenia = unaContrasenia.toCharArray();
        char primerCaracter = ArrayContrasenia[0];
        int i = 0, largoContrasenia = unaContrasenia.length();


        while (i < largoContrasenia && (primerCaracter - i) == ArrayContrasenia[i]) {
            i++;
        }
        return largoContrasenia == i;
    }

    static boolean cumpleReglasSintacticas(String unaContrasenia) {
        char clave;
        int contNumero = 0, contLetraMay = 0, contLetraMin = 0;

        for (int i = 0; i < unaContrasenia.length(); i++) {
            clave = unaContrasenia.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[A-Z]")) {
                contLetraMay++;
            } else if (passValue.matches("[a-z]")) {
                contLetraMin++;
            } else if (passValue.matches("[0-9]")) {
                contNumero++;
            }
        }

        return (contNumero != 0) && (contLetraMay != 0) && (contLetraMin != 0);
    }

}
















