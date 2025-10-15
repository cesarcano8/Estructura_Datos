package Proyecto_Biblioteca;

public class Book {
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private boolean prestado; // para saber si está en préstamo o disponible

    public Book(String titulo, String autor, String isbn, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Título='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", Categoría='" + categoria + '\'' +
                ", Estado=" + (prestado ? "Prestado" : "Disponible") +
                '}';
    }
}
