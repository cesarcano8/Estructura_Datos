package Proyecto_Biblioteca;

import java.util.ArrayList;

public class Libreria {

    private ArrayList<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public void addBook(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    public Libro searchByTitle(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public void removeBook(int posicion) {
        if (posicion < 0 || posicion >= libros.size()) {
            System.out.println("Posición inválida.");
            return;
        }
        System.out.println("Libro eliminado: " + libros.get(posicion));
        libros.remove(posicion);
    }

    public void displayAllBooks() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles en la librería.");
            return;
        }
        for (int i = 0; i < libros.size(); i++) {
            System.out.println("Posición " + i + ": " + libros.get(i));
        }
    }
}
