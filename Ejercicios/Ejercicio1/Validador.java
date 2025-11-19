package Ejercicios.Ejercicio1;

public class Validador {
    public static boolean esValido(String contrasena){
        if(contrasena.length() < 8)
            return false;

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        String especiales = "!@#$%^&*";

        for(int i = 0; i < contrasena.length(); i++){
            char c = contrasena.charAt(i);

            if(Character.isUpperCase(c)){
                tieneMayuscula = true;
            } else if(Character.isLowerCase(c)){
                tieneMinuscula = true;
            } else if(Character.isDigit(c)){
                tieneNumero = true;
            } else if(especiales.indexOf(c) != -1){
                tieneEspecial = true;
            }
        }

        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneEspecial;
        }



    public static void main(String[] args) {
        
        System.out.println("Ingresa una contrasena para validar:");
        String contrasena = System.console().readLine();

        if(esValido(contrasena)){
            System.out.println("La contrasena es valida.");
        } else {
            System.out.println("La contrasena no es valida.");
        }
    }
}
