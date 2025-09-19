public class Main {
    public static void main(String[] args) {
        // Creamos una tabla hash con 5 posiciones
        TablaHash tabla = new TablaHash(5);

        // Crear libros
        Libro libro1 = new Libro(1, "El Quijote", "Cervantes");
        Libro libro2 = new Libro(7, "Cien años de soledad", "García Márquez");
        Libro libro3 = new Libro(14, "La Odisea", "Homero");

        // Insertar libros en la tabla hash
        tabla.insertar(libro1);
        tabla.insertar(libro2);
        tabla.insertar(libro3);

        // Mostramos su estado inicial
        tabla.mostrarTabla();

        System.out.println("\nBuscando libro con id=7...");
        Libro encontrado = tabla.buscarPorId(7);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("\nBuscando libro con id=10...");
        Libro noExiste = tabla.buscarPorId(10);
        if (noExiste != null) {
            System.out.println("Encontrado: " + noExiste);
        } else {
            System.out.println("No encontrado");
        }
    }
}
