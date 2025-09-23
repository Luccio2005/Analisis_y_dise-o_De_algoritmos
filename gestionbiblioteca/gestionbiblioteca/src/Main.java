public class Main {
    public static void main(String[] args) {
        int capacidad = 5; // pequeña para que haya colisiones

        // ---- Creamos las tres tablas ----
        TablaHash tablaLineal = new TablaHash(capacidad);
        TablaHashCuadratica tablaCuadratica = new TablaHashCuadratica(capacidad);
        TablaHashEncadenada tablaEncadenada = new TablaHashEncadenada(capacidad);

        // ---- Libros con colisiones ----
        // Todos tienen id que da el mismo índice con % 5 = 1
        Libro libro1 = new Libro(1, "Libro 1", "Autor A");
        Libro libro2 = new Libro(6, "Libro 2", "Autor B");
        Libro libro3 = new Libro(11, "Libro 3", "Autor C");

        // Insertar en las tres tablas
        tablaLineal.insertar(libro1);
        tablaLineal.insertar(libro2);
        tablaLineal.insertar(libro3);

        tablaCuadratica.insertar(libro1);
        tablaCuadratica.insertar(libro2);
        tablaCuadratica.insertar(libro3);

        tablaEncadenada.insertar(libro1);
        tablaEncadenada.insertar(libro2);
        tablaEncadenada.insertar(libro3);

        // ---- Mostrar estados ----
        System.out.println("=== Tabla Hash (Exploración Lineal) ===");
        tablaLineal.mostrarTabla();

        System.out.println("\n=== Tabla Hash (Exploración Cuadrática) ===");
        tablaCuadratica.mostrarTabla();

        System.out.println("\n=== Tabla Hash (Encadenada) ===");
        tablaEncadenada.mostrarTabla();
    }
}

