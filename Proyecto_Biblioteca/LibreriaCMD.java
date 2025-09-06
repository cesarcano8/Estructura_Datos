package Proyecto_Biblioteca;

import java.util.Scanner;

public class LibreriaCMD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria();
        LibreriaTest.llenarDatosLibrera(libreria);
        int opcion = 0;

        do{
            System.out.println("\n Menú Biblioteca virtual UCC ");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Eliminar libro por posición");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

             opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    libreria.addBook(new Libro(titulo, autor, isbn));
                    break;

                case 2:
                    System.out.print("Introduce el título a buscar: ");
                    String buscar = scanner.nextLine();
                    Libro libro = libreria.searchByTitle(buscar);
                    if (libro != null) {
                        System.out.println("Libro encontrado: " + libro);
                    } else {
                        System.out.println("No se encontró el libro.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce la posición a eliminar: ");
                    int pos = scanner.nextInt();
                    libreria.removeBook(pos);
                    break;

                case 4:
                    libreria.displayAllBooks();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, intenta otra vez.");
            }
        }while (opcion != 5);
            
        }

}