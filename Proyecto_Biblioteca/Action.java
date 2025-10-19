package Proyecto_Biblioteca;

public class Action {
    public String type;
    public Book book;
    public User user;

    public Action(String type, Book book, User user) {
        this.type = type;
        this.book = book;
        this.user = user;
    }

    public Action(String type, Book book) {
        this(type, book, null);
    }
    public Action(String type, User user) {
        this(type, null, user);
    }

    @Override
    public String toString() {
        String info =  "Action: " + type;
        if (book != null) info += ", Libro: " + book.getTitulo();
        if (user != null) info += ", Usuario: " + user.getNombre();
        return info;
    }
        
}


