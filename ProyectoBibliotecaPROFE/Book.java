package ProyectoBibliotecaPROFE;

public class Book {
    String name;
    String author;
    String isbn;
    String category;

    public Book(String name, String author, String isbn, String category){
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    public Book(){
        super();// Poner todos los atributos en null
    }

    public String toString(){
        return name + "Book name: " + author + "Author | " + isbn + "ISBN | " + category + "Category | ";
    
    }
}
