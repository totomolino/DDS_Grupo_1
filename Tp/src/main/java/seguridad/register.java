package seguridad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class register {

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

        System.out.println("Ingrese una contrasenia: ");
        String contra = entrada.nextLine();

        while(!(register.validarContrasenia(contra, usuario))){
            System.out.println("Ingrese una nueva contrasenia, la anterior no cumple las condiciones: ");
            contra = entrada.nextLine();
        }
    }
}
















