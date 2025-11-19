package PBFinal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Libreria {
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private Stack<Accion> historial = new Stack<Accion>();
    private LinkedList<Prestamo> prestamos = new LinkedList<Prestamo>();

    public void agregarLibro(String titulo, String autor, String isbn){
        Libro libro = consultarLibro(isbn);
        if (libro == null){
            libro = new Libro(titulo, autor, isbn);
            libros.add(libro);
            Accion accion = new Accion(libro, "Libro", "Insertar");
            historial.add(accion);
        }
    }

    public void modificarLibro(String titulo, String autor, String isbn){
        Libro libro = consultarLibro(isbn);
        if (libro != null){
            Libro libroOld = new Libro(libro.getTitulo(),libro.getAutor(),libro.getIsbn());
            libro.setAutor(autor);
            libro.setTitulo(titulo);
            Accion accion = new Accion(libroOld, "Libro", "Modificar");
            historial.add(accion);
        }
    }

    public Libro consultarLibro(String isbn){
        Iterator<Libro> iter = libros.iterator();
        while(iter.hasNext()){
            Libro libro = iter.next();
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public void eliminarLibro(String isbn){
        Iterator<Libro> iter = libros.iterator();
        while(iter.hasNext()){
            Libro libro = iter.next();
            if (libro.getIsbn().equals(isbn)){
                iter.remove();
                Accion accion = new Accion(libro, "Libro", "Eliminar");
                historial.add(accion);
                break;
            }
        }
    }

    public void agregarUsuario(String id, String nombre){
        Usuario usuario = consultarUsuario(id);
        if(usuario == null){
            usuario = new Usuario(nombre, id);
            usuarios.add(usuario);
            Accion accion = new Accion(usuario,"Usuario","Insertar");
            historial.add(accion);
        }
    }

    public void eliminarUsuario(String id){
        Iterator<Usuario> iter = usuarios.iterator();
        while(iter.hasNext()){
            Usuario usuario = iter.next();
            if (usuario.getId().equals(id)){
                iter.remove();
                Accion accion = new Accion(usuario, "Usuario", "Eliminar");
                historial.add(accion);
                break;
            }
        }
    }

    public Usuario consultarUsuario(String id){
        Iterator<Usuario> iter = usuarios.iterator();
        while(iter.hasNext()){
            Usuario usuario = iter.next();
            if (usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }

    public void modificarUsuario(String id, String nombre){
        Usuario usuario = consultarUsuario(id);
        if (usuario != null){
            Usuario userOld = new Usuario(usuario.getNombre(), usuario.getId());
            usuario.setNombre(nombre);
            Accion accion = new Accion(userOld, "Usuario", "Modificar");
            historial.add(accion);
        }
    }

    public void agregarPrestamo(String idUsuario, String isbnLibro){
        Usuario user = consultarUsuario(idUsuario);
        Libro libro = consultarLibro(isbnLibro);
        if (user != null && libro != null){
            Prestamo prestamo = new Prestamo(user, libro);
            prestamos.add(prestamo);
            Accion accion = new Accion(prestamo, "Prestamo", "Insertar");
            historial.add(accion);
        }
    }

    public Prestamo consultarPrestamo(String idUsuario, String isbnLibro){
        Iterator<Prestamo> iter = prestamos.iterator();
        while(iter.hasNext()){
            Prestamo prestamo = iter.next();
            if (prestamo.getUsuario().getId().equals(idUsuario) && prestamo.getLibro().getIsbn().equals(isbnLibro)){
                return prestamo;
            }
        }
        return null;
    }

    public void regresarPrestamo(String idUsuario, String isbnLibro){
        Prestamo prestamo = consultarPrestamo(idUsuario, isbnLibro);
        if (prestamo != null){
            prestamos.remove(prestamo);
            Accion accion = new Accion(prestamo, "Prestamo", "Eliminar");
            historial.add(accion);
        }

    }

    public void deshacer(){
        Accion accion = historial.pop();
        switch (accion.getTipo()) {
            case "Usuario":
                deshacerUsuario((Usuario)accion.getObjeto(), accion.getOperacion());
                break;
            case "Libro":
                deshacerLibro((Libro)accion.getObjeto(), accion.getOperacion());
                break;
            case "Prestamo":
                deshacerPrestamo((Prestamo)accion.getObjeto(), accion.getOperacion());
                break;
            
        }
    }

    public void deshacerUsuario(Usuario user, String operacion){
        switch (operacion){
            case "Insertar":
            Iterator<Usuario> iter = usuarios.iterator();
            while(iter.hasNext()){
                Usuario userActual = iter.next();
                if (userActual.getId().equals(user.getId())){
                    iter.remove();
                }
            }
                break;
            case "Eliminar":
                usuarios.add(user);
                break;
            case "Modificar":
                Usuario userActual = consultarUsuario(user.getId());
                    userActual.setNombre(user.getNombre());
                break;
            default:
                break;
        }
    }

    public void deshacerLibro(Libro libro, String operacion){
        switch (operacion){
            case "Insertar":
            Iterator<Libro> iter = libros.iterator();
            while(iter.hasNext()){
                Libro libroActual = iter.next();
                if (libroActual.getIsbn().equals(libro.getIsbn())){
                    iter.remove();
                    break;
                }
            }
                break;
            case "Eliminar":
                libros.add(libro);
                break;
            case "Modificar":
                Libro libroActual = consultarLibro(libro.getIsbn());
                    libroActual.setTitulo(libro.getTitulo());
                    libroActual.setAutor(libro.getAutor());
            default:
                break;
        }
    }

    public void deshacerPrestamo(Prestamo prestamo, String operacion){
        switch (operacion){
            case "Insertar":
            Iterator<Prestamo> iter = prestamos.iterator();
            while(iter.hasNext()){
                Prestamo prestamoActual = iter.next();
                if (prestamoActual.getUsuario().getId().equals(prestamo.getUsuario().getId()) &&
                    prestamoActual.getLibro().getIsbn().equals(prestamo.getLibro().getIsbn())){
                    iter.remove();
                    break;
                }
            }
                break;
            case "Eliminar":
                prestamos.add(prestamo);
                break;
            default:
                break;
        }
    }




}
