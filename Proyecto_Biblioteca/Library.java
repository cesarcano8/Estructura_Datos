package Proyecto_Biblioteca;

import java.util.*;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private LinkedList<Loan> loans;
    private Queue<User> waitList;
    private Stack<Action> undoStack;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new LinkedList<>();
        waitList = new LinkedList<>();
        undoStack = new Stack<>();
    }

    // ------------------ Libros ------------------

    public void addBook(Book book) {
        books.add(book);
        undoStack.push(new Action("add", book, null));
    }

     public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            Book eliminado = books.remove(index);
            undoStack.push(new Action("remove", eliminado, null));
        }
    }

    public Book searchBook(String titulo) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getTitulo().equalsIgnoreCase(titulo)) {
                return b;
            }
        }
        return null;
    }

   

    public void displayAllBooks() {
    if (books.isEmpty()) {
        System.out.println("No hay libros registrados.");
        return;
    }

    Iterator<Book> it = books.iterator();
    int i = 0;
    while (it.hasNext()) {
        System.out.println((i + 1) + ". " + it.next());
        i++;
        }
    }

    // ------------------ Usuarios ------------------

    public void addUser(User user) {
        users.add(user);
        undoStack.push(new Action("addUser", null, user));
    }

    public User searchUser(String id) {
        for (User u : users) {
            if (u.getId().equalsIgnoreCase(id)) {
                return u;
            }
        }
        return null;
    }

    public void displayUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }

    // ------------------ Préstamos ------------------

    public void loanBook(User user, Book book) {
        if (book == null || user == null) {
            System.out.println("Datos inválidos.");
            return;
        }

        // Si el libro ya está prestado, agregar usuario a cola de espera
        for (Loan l : loans) {
            if (l.getLibro().equals(book) && !l.isDevuelto()) {
                waitList.add(user);
                System.out.println("Libro en préstamo. Se añadió a la cola de espera.");
                return;
            }
        }

        Loan nuevo = new Loan(user, book);
        loans.add(nuevo);
        undoStack.push(new Action("loan", book, user));
    }

    public void returnBook(String tituloLibro) {
        for (Loan l : loans) {
            if (l.getLibro().getTitulo().equalsIgnoreCase(tituloLibro) && !l.isDevuelto()) {
                l.devolver();
                undoStack.push(new Action("return", l.getLibro(), l.getUsuario()));
                System.out.println("Libro devuelto con éxito.");

                if (!waitList.isEmpty()) {
                    User siguiente = waitList.poll();
                    loanBook(siguiente, l.getLibro());
                }
                return;
            }
        }
        System.out.println("No se encontró préstamo activo de ese libro.");
    }

    public void showLoans() {
        Iterator<Loan> it = loans.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // ------------------ Función deshacer ------------------

    public void undoLastAction() {
    if (undoStack.isEmpty()) {
        System.out.println("No hay acciones para deshacer.");
        return;
    }

    Action last = undoStack.pop();

    switch (last.type) {
        case "add":
            books.remove(last.book);
            System.out.println("Deshecho: se eliminó el libro " + last.book.getTitulo());
            break;
        case "remove":
            books.add(last.book);
            System.out.println("Deshecho: se volvió a agregar el libro " + last.book.getTitulo());
            break;
        case "loan":
            loans.removeIf(l -> l.getLibro().equals(last.book) && l.getUsuario().equals(last.user));
            System.out.println("Deshecho: préstamo cancelado de " + last.user.getNombre());
            break;

        case "addUser":
            users.remove(last.user);
            System.out.println("Deshecho: se eliminó el usuario " + last.user.getNombre());
            break;

        case "return":
            loans.add(new Loan(last.user, last.book)); // simula que se devolvió
            System.out.println("Deshecho: devolución revertida del libro " + last.book.getTitulo());
            break;


        default:
            System.out.println("Tipo de acción desconocida.");
        }
    }


    // ------------------ Reportes ------------------

    public void showReports() {
        System.out.println("\n📊 Reporte general:");
        System.out.println("Total de libros: " + books.size());
        System.out.println("Total de usuarios: " + users.size());
        System.out.println("Total de préstamos realizados: " + loans.size());
        long activos = loans.stream().filter(l -> !l.isDevuelto()).count();
        System.out.println("Libros actualmente prestados: " + activos);
        System.out.println("Usuarios en cola de espera: " + waitList.size());
    }
}
