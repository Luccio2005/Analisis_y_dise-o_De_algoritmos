public class Main {
    public static void main(String[] args) {
        // Creamos una tabla hash con 5 posiciones
        TablaHash tabla = new TablaHash(5);

        // Crear libros
        Libro libro1 = new Libro(1, "El Quijote", "Cervantes");
        Libro libro2 = new Libro(7, "Cien años de soledad", "García Márquez");
        Libro libro3 = new Libro(12, "Clean Code", "Robert C. Martin");

        // Insertar libros en la tabla hash
        tabla.insertar(libro1);
        tabla.insertar(libro2);
        tabla.insertar(libro3);

        // Mostramos su estado inicial
        tabla.mostrarTabla();
    }
}
