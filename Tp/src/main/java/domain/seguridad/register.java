package domain.seguridad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class register {
    /*
    public static boolean existeUsuario(String usuario){

    }
    */


    public static boolean esFacil(String unaContrasenia){

    String[] contras = {"picture1" , "password" , "senha" , "qwerty" };

    List<String> contraseniasFaciles = new ArrayList<String>(Arrays.asList(contras));

    return contraseniasFaciles.contains(unaContrasenia);
}

public static boolean validarContrasenia(String unaContrasenia, String unUsuario){

    return reglasNist.cumpleLasReglas(unaContrasenia, unUsuario) && !(register.esFacil(unaContrasenia));
}



    public static void main(String[] args) {
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

    /*
    ----------------------------------------------------------------------------------------
    char clave;
    byte  contNumero = 0, contLetraMay = 0, contLetraMin=0;
    for (byte i = 0; i < password.length(); i++) {
        clave = password.charAt(i);
        String passValue = String.valueOf(clave);
        if (passValue.matches("[A-Z]")) {
            contLetraMay++;
        } else if (passValue.matches("[a-z]")) {
            contLetraMin++;
        } else if (passValue.matches("[0-9]")) {
            contNumero++;
        }
    }
    */


}
}

class reglasNist {

    private static int largoMinimo = 8;
    private static int largoMaximo = 64;

    static boolean cumpleLasReglas(String unaContrasenia, String unUsuario){

        return reglasNist.cumpleLargo(unaContrasenia) && reglasNist.usuarioYContraDistintos(unaContrasenia, unUsuario);
    }

    static boolean cumpleLargo(String unaContrasenia){

        int longitud = unaContrasenia.length();

        return (largoMinimo <= longitud && longitud <= largoMaximo);
    }

    static boolean usuarioYContraDistintos(String unaContrasenia,String unUsuario ){
        return !(unUsuario.equals(unaContrasenia));
    }


}


