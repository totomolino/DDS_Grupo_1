package seguridad;

public class reglasNist {

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
