package ProyectoBibliotecaPROFE;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryUI {
    public static void main (String[] args) {
        try {
            Library myLibrary = new Library();
            Scanner input = new Scanner(System.in);
            String opst = "";
            do{
                opst = showMainMenu(input, myLibrary);


            }while (!opst.equalsIgnoreCase("z"));
        }catch (Exception e) {
        }
    }

    public static String showMainMenu(Scanner input, Library myLibrary) {
        System.out.println("Welcome to my library");
        System.out.println("pick an option:");
        System.out.println("a -> Books");
        System.out.println("b -> Users (not implement yet)");
        System.out.println("c -> whatever");
        System.out.println("z -> Exit");
        String opts = "";
        boolean isValidOption = false;
        do{
            opts = input.nextLine();
            switch (opts) {
                case "a":
                    
                    showMainMenu(input,myLibrary);
                    break;
            
                default:
                    System.out.println("Input a valid option");
                    break;
            }
            
        }while(opts.equalsIgnoreCase("z"));
        return opts;
    }

        public static String showBooksMenu(Scanner input, Library myLibrary) {
            System.out.println("Books Menu");
            System.out.println("pick an option:");
            System.out.println("a -> add Books");
            System.out.println("b -> search Book");
            System.out.println("c -> list Books");
            System.out.println("d -> update Book");
            System.out.println("e -> delete Book");
            System.out.println("f -> Back");
            System.out.println("z -> Exit");
            String opts = "";
            boolean isValidOption = false;
            do{
                opts = input.nextLine();
                switch (opts) {
                    case "a":
                        Book newBook = getBookInformation(input, myLibrary);
                        myLibrary.addBook(newBook);
                        break;
                    case "b":
                        System.out.println("Enter book ISBN to search: ");
                        String isbn = input.nextLine();
                        Book foundBook = myLibrary.searchBook(isbn);
                        if (foundBook != null) {
                            System.out.println("Book found: " + foundBook);
                        } else {
                            System.out.println("No book found with that ISBN.");
                        }
                        break;
                    case "c":
                        Book[] allBooks = myLibrary.listBooks();
                        System.out.println(Arrays.toString(allBooks));
                        break;
                    case "d":
                        System.out.println("Enter book ISBN to delete: ");
                        String delIsbn = input.nextLine();
                        myLibrary.deleteBook(delIsbn);
                        break;
                    case "e":
                        Book updateBook = getBookInformation(input, myLibrary);
                        myLibrary.updateBook(updateBook);
                        break;
                    case "f":
                        showMainMenu(input, myLibrary);
                        break;
                    case "z":
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Input a valid option");
                        break;
                }
                
            }while(!opts.equalsIgnoreCase("z") && !opts.equalsIgnoreCase("f"));
            return opts;
         }

       public static Book getBookInformation (Scanner input, Library myLibrary){
        System.out.println("Enter book name: ");
        String name = input.nextLine();
        System.out.println("Enter book author: ");
        String author = input.nextLine();
        System.out.println("Enter book ISBN: ");
        String isbn = input.nextLine();
        System.out.println("Enter book category: ");
        String category = input.nextLine();

        Book newBook = new Book(name, author, isbn, category);
        return newBook;
       }
}

