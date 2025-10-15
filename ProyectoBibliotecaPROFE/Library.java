package ProyectoBibliotecaPROFE;
import java.util.ArrayList;

public class Library {
    private ArrayList <Book> books;


    /*
    Constructor
    */

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(String book, String name, String author, String isbn, String category) {
        Book newBook = new Book(name, author, isbn, category);
        books.add(newBook);
    }

    public void addBook(Book newbook) {
        if (searchBook(newbook.isbn) != null) {
            books.add(newbook);
        }
        books.add(newbook);
    }

    public Book searchBook (String isbn){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).isbn.equalsIgnoreCase(isbn)){
                return books.get(i);
            }
        }
        return null;
    }

    public Book[] listBooks(){
        Book [] myBooks = (Book[])books.toArray();
        return myBooks;
    }

    public void deleteBook(String isbn){
       for (int i = 0; i < books.size(); i++){
        if (books.get(i).isbn.equalsIgnoreCase(isbn)){
            books.remove(i);
            return;
        }
       }
    }

    public void updateBook(Book updateBook){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).isbn.equalsIgnoreCase(updateBook.isbn)){
                books.set(i, updateBook);
                break;
            }
        }
    }

    
}
