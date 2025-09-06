package Proyecto_Biblioteca;

public class LibreriaTest {
    public static void main(String[] args){
        Libreria library = new Libreria();

        Libro book1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-3-16-148410-0");
        Libro book2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "978-1-56619-909-4");
        Libro book3 = new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", "978-0-7432-7356-5");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("\nBuscando libro por título 'Don Quijote de la Mancha':");
        Libro foundBook = library.searchByTitle("Don Quijote de la Mancha");
        if (foundBook != null) {
            System.out.println("Libro encontrado: " + foundBook);
        } else {
            System.out.println("Libro no encontrado.");
        }

        System.out.println("\nEliminando libro en posición 1:");
        library.removeBook(1);

        System.out.println("\nMostrando todos los libros en la librería:");
        library.displayAllBooks();
    }

    public static void llenarDatosLibrera(Libreria libreria){
        Libro book1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-3-16-148410-0");
        Libro book2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "978-1-56619-909-4");
        Libro book3 = new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", "978-0-7432-7356-5");

        libreria.addBook(book1); 
        libreria.addBook(book2); 
        libreria.addBook(book3);
    }
    



}