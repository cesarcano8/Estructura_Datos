package Ejercicios.Ejercicio2;

public class ClasificacionImportancia {
    public static String clasificarImportancia(String CI){
        if(CI.equals("A")){
            return "Alta importancia";
        } else if(CI.equals("B")){
            return "Importancia media";
        } else if(CI.equals("C")){
            return "Baja importancia";
        } else {
            return "Clasificación desconocida";
        }
    }

    public static String AgregarTarea(String nombre, String CI){
        String importancia = clasificarImportancia(CI);
        return "Tarea: " + nombre  + "\nImportancia: " + importancia;
    }

    public static String CompletarTarea(String nombre, String CI){
        String importancia = clasificarImportancia(CI);
        return "Tarea completada: " + nombre  + "\nImportancia: " + importancia;
    }

    public static String VerTarea(String nombre, String CI){
        String importancia = clasificarImportancia(CI);
        return "Tarea: " + nombre  + "\nImportancia: " + importancia;
    }

    public static String ContarTareas(String[] tareas){
        return "Número total de tareas: " + tareas.length;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println(AgregarTarea("Comprar víveres", "A"));
        System.out.println(CompletarTarea("Lavar el coche", "B"));
        System.out.println(VerTarea("Estudiar para el examen", "C"));
        
    }
}
