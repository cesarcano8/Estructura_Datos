package PBFinal;
import java.util.Scanner;

public class LibreriaCMD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria();
        
        String opcion;
        /*
         

        */

        boolean ejecutar = true;
        while (ejecutar) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Gestionar libros");
            System.out.println("2. Gestionar usuarios");
            System.out.println("3. Gestionar prestamos");
            System.out.println("4. Deshacer ultima accion)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1": // Gestionar libros
                    while (true) {
                        System.out.println("\n=== Gestionar libros ===");
                        System.out.println("1. Agregar libro");
                        System.out.println("2. Eliminar libro");
                        System.out.println("3. Modificar libro");
                        System.out.println("4. Consultar libro");
                        System.out.println("5. Volver al menú principal");
                        System.out.print("Seleccione una opcion: ");
                        String opcionLibro = scanner.nextLine();

                        switch (opcionLibro) {
                            case "1":
                                System.out.print("Titulo: ");
                                String titulo = scanner.nextLine();
                                System.out.print("Autor: ");
                                String autor = scanner.nextLine();
                                System.out.print("ISBN: ");
                                String isbn = scanner.nextLine();
                                libreria.agregarLibro(titulo, autor, isbn);
                                break;
                            case "2":
                                System.out.print("ISBN del libro a eliminar: ");
                                String isbnEli = scanner.nextLine();
                                libreria.eliminarLibro(isbnEli);
                                break;
                            case "3":
                                System.out.print("ISBN del libro a modificar: ");
                                String isbnMod = scanner.nextLine();
                                System.out.print("Nuevo titulo: ");
                                String nuevoTitulo = scanner.nextLine();
                                System.out.print("Nuevo autor: ");
                                String nuevoAutor = scanner.nextLine();
                                libreria.modificarLibro(nuevoTitulo, nuevoAutor, isbnMod);
                                break;
                                
                            case "4":
                                System.out.print("ISBN del libro a consultar: ");
                                String isbnCon = scanner.nextLine();
                                Libro libro = libreria.consultarLibro(isbnCon);
                                if (libro != null) {
                                    System.out.println(libro);
                                } else {
                                    System.out.println("Libro no encontrado.");
                                }
                                break;
                            case "5":
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opcion inválida.");
                        }

                        // Si eligió explícitamente volver, salir del bucle del submenú
                        if (opcionLibro != null && opcionLibro.equals("5")) {
                            break;
                        }

                        // Preguntar al usuario si desea permanecer en el submenú
                        System.out.print("¿Desea permanecer en el menú de libros? (si/no): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("no")) {
                            break;
                        }
                   
                    }
                    break;

                case "2": // Gestionar usuarios
                    while (true) {
                        System.out.println("\n=== Gestionar usuarios ===");
                        System.out.println("1. Agregar usuario");
                        System.out.println("2. Eliminar usuario");
                        System.out.println("3. Modificar usuario");
                        System.out.println("4. Consultar usuario");
                        System.out.println("5. Volver al menú principal");
                        System.out.print("Seleccione una opcion: ");
                        String opcionUsuario = scanner.nextLine();

                        switch (opcionUsuario) {
                            case "1":
                                System.out.print("Nombre: ");
                                String nombre = scanner.nextLine();
                                System.out.print("ID: ");
                                String id = scanner.nextLine();
                                libreria.agregarUsuario(id, nombre);
                                break;
                            case "2":
                                System.out.print("ID del usuario a eliminar: ");
                                String idEli = scanner.nextLine();
                                libreria.eliminarUsuario(idEli);
                                break;
                            case "3":
                                System.out.print("ID del usuario a modificar: ");
                                String idMod = scanner.nextLine();
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = scanner.nextLine();
                                libreria.modificarUsuario(idMod, nuevoNombre);
                                break;
                            case "4":
                                System.out.print("ID del usuario a consultar: ");
                                String idCon = scanner.nextLine();
                                Usuario usuario = libreria.consultarUsuario(idCon);
                                if (usuario != null) {
                                    System.out.println(usuario);
                                } else {
                                    System.out.println("Usuario no encontrado.");
                                }
                                break;
                            case "5":
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opcion invalida.");
                        }

                        if (opcionUsuario != null && opcionUsuario.equals("5")) {
                            break;
                        }

                        System.out.print("¿Desea permanecer en el menú de usuarios? (si/no): ");
                        String respUsu = scanner.nextLine();
                        if (respUsu.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                    break;

                case "3": // Gestionar prestamos
                    while (true) {
                        System.out.println("\n=== Gestionar prestamos ===");
                        System.out.println("1. Generar prestamo");
                        System.out.println("2. Devolver libro");
                        System.out.println("3. Consultar prestamo");
                        System.out.println("4. Volver al menú principal");
                        System.out.print("Seleccione una opcion: ");
                        String opcionPrestamo = scanner.nextLine();

                        switch (opcionPrestamo) {
                            case "1":
                                System.out.print("ID del usuario: ");
                                String idU = scanner.nextLine();
                                System.out.print("ISBN del libro: ");
                                String isbnL = scanner.nextLine();
                                libreria.agregarPrestamo(idU, isbnL);
                                break;
                            case "2":
                                System.out.print("ID del usuario: ");
                                String idUD = scanner.nextLine();
                                System.out.print("ISBN del libro: ");
                                String isbnLD = scanner.nextLine();
                                Prestamo prestamo = libreria.consultarPrestamo(idUD, isbnLD);
                                if (prestamo != null && !prestamo.isDevuelto()) {
                                    prestamo.devolver();
                                    System.out.println("Libro devuelto exitosamente.");
                                } else {
                                    System.out.println("Prestamo no encontrado o ya devuelto.");
                                }
                                break;
                            case "3":
                                System.out.print("ID del usuario: ");
                                String idUC = scanner.nextLine();
                                System.out.print("ISBN del libro: ");
                                String isbnLC = scanner.nextLine();
                                Prestamo prestamoC = libreria.consultarPrestamo(idUC, isbnLC);
                                if (prestamoC != null) {
                                    System.out.println(prestamoC);
                                } else {
                                    System.out.println("Prestamo no encontrado.");
                                }
                                break;
                            case "4":
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opcion invalida.");
                        }

                        if (opcionPrestamo != null && opcionPrestamo.equals("4")) {
                            break;
                        }

                        System.out.print("¿Desea permanecer en el menú de préstamos? (si/no): ");
                        String respPres = scanner.nextLine();
                        if (respPres.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                    break;


                case "4": 
                    libreria.deshacer();
                    break;

                case "5":
                    System.out.println("Saliendo... ¡hasta luego!");
                    ejecutar = false;
                    break;

                default:
                    System.out.println("Opcion invalida.");
            } // fin switch principal
        } // fin while principal

        scanner.close();
    } // fin main
} // fin clase
