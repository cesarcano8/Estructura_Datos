package Ejercicios.Ejercicio2;

public class Tareas {
    private String nombre;
    private String clasificacion;
    private boolean completada;

    public Tareas(String nombre, String clasificacion) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.completada = false;
    }

    public String getNombre() {
        return nombre;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public boolean isCompletada() {
        return completada;
    }

    public void completarTarea() {
        this.completada = true;
    }
    @Override
    public String toString() {
        String estado = completada ? "Completada" : "Pendiente";
        return "Tarea: " + nombre + "\nClasificación: " + clasificacion + "\nEstado: " + estado;
    }
}
