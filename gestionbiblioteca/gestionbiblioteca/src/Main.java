public class Main {
    public static void main(String[] args) {
        int capacidad = 23; // capacidad mayor para manejar colisiones
        TablaHash tabla = new TablaHash(capacidad);

        // ---- Crear 20 libros ----
        Libro[] libros = new Libro[20];
        for (int i = 0; i < 20; i++) {
            libros[i] = new Libro(i + 1, "Libro " + (i + 1), "Autor " + (i + 1));
        }

        // ---- Medir tiempo de inserción ----
        long inicioInsercion = System.nanoTime();
        for (Libro libro : libros) {
            tabla.insertar(libro);
        }
        long finInsercion = System.nanoTime();

        System.out.println("Tiempo total de inserción de 20 libros: " + (finInsercion - inicioInsercion) + " ns");

        // Mostrar parte de la tabla
        System.out.println("\nEstado de la tabla hash (primeras 10 posiciones):");
        for (int i = 0; i < 10; i++) {
            tabla.mostrarPosicion(i);
        }

        // ---- Medir tiempo de búsqueda ----
        int idBuscado = 15;
        long inicioBusqueda = System.nanoTime();
        Libro encontrado = tabla.buscarPorId(idBuscado);
        long finBusqueda = System.nanoTime();

        if (encontrado != null) {
            System.out.println("\nLibro con id=" + idBuscado + " encontrado: " + encontrado);
        } else {
            System.out.println("\nLibro con id=" + idBuscado + " no encontrado.");
        }

        System.out.println("Tiempo de búsqueda: " + (finBusqueda - inicioBusqueda) + " ns");
    }
}
