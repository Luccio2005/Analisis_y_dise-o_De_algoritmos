public class Main {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash(11); // capacidad pequeña para forzar colisiones

        // Estos 3 colisionan en la misma posición inicial (id % 11 = 1)
        Libro libro1 = new Libro(1, "El Quijote", "Cervantes");
        Libro libro2 = new Libro(12, "Cien años de soledad", "García Márquez");
        Libro libro3 = new Libro(23, "La Odisea", "Homero");

        tabla.insertar(libro1);
        tabla.insertar(libro2);
        tabla.insertar(libro3);

        // Mostrar estado
        System.out.println("Estado de la tabla hash (exploración cuadrática):");
        tabla.mostrarTabla();

        // Búsquedas
        System.out.println("\nBuscando libro con id=23...");
        Libro encontrado = tabla.buscarPorId(23);
        System.out.println(encontrado != null ? "Encontrado: " + encontrado : "No encontrado");

        System.out.println("\nBuscando libro con id=99...");
        Libro noExiste = tabla.buscarPorId(99);
        System.out.println(noExiste != null ? "Encontrado: " + noExiste : "No encontrado");
    }
}

