## 📘 Clases y Métodos

### `Libro`
- **Atributos:** `titulo`, `autor`, `isbn`.
- **Métodos principales:**
  - Getters y Setters.
  - `toString()` → representación legible de un libro.

### `Libreria`
- Usa `ArrayList<Libro>` en vez de un arreglo fijo.
- **Métodos:**
  - `addBook(Libro libro)` → agrega un libro.
  - `searchByTitle(String titulo)` → busca un libro por su título.
  - `removeBook(int posicion)` → elimina un libro en una posición.
  - `displayAllBooks()` → muestra todos los libros.

### `LibreriaTest`
- Contiene un `main` para probar la librería.
- Método `llenarDatosLiberia()` agrega libros de ejemplo.

### `LibreriaCMD`
- Clase principal para interactuar con el usuario.
- Muestra un menú con opciones:
  1. Agregar libro.
  2. Buscar libro.
  3. Eliminar libro.
  4. Mostrar libros.
  5. Salir.

---

Opción 1 → addBook(Libro libro)

Este método agrega un nuevo libro a la librería usando un objeto de la clase Libro.
Internamente, simplemente usa libros.add(libro) para añadirlo al ArrayList.
Luego muestra un mensaje en consola confirmando la operación:
Libro agregado: Libro{titulo='...', autor='...', isbn='...'}


Ejemplo de uso en código:
Libro nuevo = new Libro("Harry Potter", "J.K. Rowling", "1234");
libreria.addBook(nuevo);


Salida en consola:
Libro agregado: Libro{titulo='Harry Potter', autor='J.K. Rowling', isbn='1234'}


Desde el menú interactivo (LibreriaCMD):
El usuario selecciona la opción 1.
El programa pide:

Título del libro
Autor del libro
ISBN

Crea un objeto Libro con esos datos y lo pasa a addBook.

Opcion 2 → Buscar libro

Qué hace
Busca un libro en la librería comparando el título proporcionado por el usuario con el título de cada Libro almacenado y devuelve el primer Libro que coincida (o null si no encuentra ninguno).

Implementación (ejemplo actual)

public Libro searchByTitle(String titulo) {
    for (Libro libro : libros) {
        if (libro != null && libro.getTitulo().equalsIgnoreCase(titulo)) {
            return libro;
        }
    }
    return null;
}


Puntos importantes

Usa equalsIgnoreCase(...) → no distingue mayúsculas/minúsculas (por ejemplo, "el principito" = "El Principito").
Devuelve el primer libro que coincida exactamente con el título.
Si hay varios libros con el mismo título, los demás no se devuelven.
Si no encuentra coincidencia, devuelve null. En la interfaz (LibreriaCMD) se comprueba if (foundBook != null) para informar al usuario.
Complejidad temporal: O(n) (recorre la lista hasta encontrar coincidencia).
Uso desde LibreriaCMD 

Usuario elige la opción 2.
Programa lee la línea con scanner.nextLine() y lo pasa a searchByTitle(...).
Si devuelve un objeto Libro, se imprime Libro encontrado: .... Si devuelve null, se imprime Libro no encontrado.

Ejemplo real

Seleccione una opción: 2
Ingrese el título del libro a buscar: Don Quijote de la Mancha
Libro encontrado: Libro{titulo='Don Quijote de la Mancha', autor='Miguel de Cervantes', isbn='978-1-56619-909-4'}

Si no existe:

Seleccione una opción: 2
Ingrese el título del libro a buscar: Harry Potter
Libro no encontrado.

Opción 3 → removeBook

Este método elimina un libro de la librería usando su índice en el ArrayList.
Primero valida si la posición es correcta (no negativa y menor al tamaño de la lista).
Si es válida:

Recupera el libro en esa posición.
Lo muestra por consola como “Libro eliminado”.
Lo elimina del ArrayList con libros.remove(posicion).
Si la posición no existe, muestra:

Posición inválida.

Opción 4 → displayAllBooks()

Este método recorre el ArrayList y muestra todos los libros registrados.
Si la lista está vacía, imprime:
No hay libros disponibles en la librería.
Si hay libros, los muestra con su posición en la lista y su representación toString().

Ejemplo:

libreria.displayAllBooks();


Salida:

Posición 0: Libro{titulo='Cien Años de Soledad', autor='Gabriel García Márquez', isbn='978-3-16-148410-0'}
Posición 1: Libro{titulo='La Sombra del Viento', autor='Carlos Ruiz Zafón', isbn='978-0-7432-7356-5'}