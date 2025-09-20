public class Main {
    public static void main(String[] args) {
        // Creamos una tabla hash con 5 posiciones
        TablaHash tabla = new TablaHash(5);

        // ---- Libros con colisiones ----
        // 1 % 5 = 1
        // 6 % 5 = 1 -> colisiona con el 1
        // 11 % 5 = 1 -> vuelve a colisionar
        Libro libro1 = new Libro(1, "El Quijote", "Cervantes");
        Libro libro2 = new Libro(6, "Cien años de soledad", "García Márquez");
        Libro libro3 = new Libro(11, "La Odisea", "Homero");

        // Insertar libros en la tabla hash
        tabla.insertar(libro1);
        tabla.insertar(libro2);
        tabla.insertar(libro3);

        // Mostramos el estado de la tabla
        System.out.println("Estado de la tabla hash:");
        tabla.mostrarTabla();

        // ---- Búsquedas ----
        System.out.println("\nBuscando libro con id=6...");
        Libro encontrado = tabla.buscarPorId(6);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("\nBuscando libro con id=11...");
        Libro encontrado2 = tabla.buscarPorId(11);
        if (encontrado2 != null) {
            System.out.println("Encontrado: " + encontrado2);
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("\nBuscando libro con id=20...");
        Libro noExiste = tabla.buscarPorId(20);
        if (noExiste != null) {
            System.out.println("Encontrado: " + noExiste);
        } else {
            System.out.println("No encontrado");
        }
    }
}

