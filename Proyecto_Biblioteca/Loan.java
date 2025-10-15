package Proyecto_Biblioteca;

import java.time.LocalDate;

public class Loan {
    private User usuario;
    private Book libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Loan(User usuario, Book libro) {
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

    public User getUsuario() {
        return usuario;
    }

    public Book getLibro() {
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

