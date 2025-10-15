package Proyecto_Biblioteca;

import java.util.Scanner;

public class LibraryCMD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library libreria = new Library();
        int opcion;

        do {
            System.out.println("\n📚 Menú Biblioteca Virtual UCC");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Mostrar usuarios");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Mostrar préstamos");
            System.out.println("8. Reportes");
            System.out.println("9. Deshacer última acción");
            System.out.println("10. Salir");
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    System.out.print("ISBN: ");
                    String i = sc.nextLine();
                    System.out.print("Categoría: ");
                    String c = sc.nextLine();
                    libreria.addBook(new Book(t, a, i, c));
                    break;

                case 2:
                    libreria.displayAllBooks();
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Correo: ");
                    String co = sc.nextLine();
                    libreria.addUser(new User(n, id, co));
                    break;

                case 4:
                    libreria.displayUsers();
                    break;

                case 5:
                    System.out.print("ID del usuario: ");
                    String idU = sc.nextLine();
                    System.out.print("Título del libro: ");
                    String tituloL = sc.nextLine();
                    libreria.loanBook(libreria.searchUser(idU), libreria.searchBook(tituloL));
                    break;

                case 6:
                    System.out.print("Título del libro a devolver: ");
                    String tituloD = sc.nextLine();
                    libreria.returnBook(tituloD);
                    break;

                case 7:
                    libreria.showLoans();
                    break;

                case 8:
                    libreria.showReports();
                    break;

                case 9:
                    libreria.undoLastAction();
                    break;

                case 10:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 10);

        sc.close();
    }
}
