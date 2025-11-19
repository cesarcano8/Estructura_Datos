package PBFinal;

import java.time.LocalDate;

public class Prestamo {
    
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public void devolver() {
        this.fechaDevolucion = LocalDate.now();
    }

    public boolean isDevuelto() {
        return fechaDevolucion != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario.getNombre() +  
                ", libro=" + libro.getTitulo() +
                ", prestado=" + fechaPrestamo +
                ", devuelto=" + (fechaDevolucion != null ? fechaDevolucion : "En curso") +
                '}';
    }
}
