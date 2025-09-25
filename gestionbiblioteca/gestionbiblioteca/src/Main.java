import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidad = 50; // subimos la capacidad porque vamos a insertar 100 libros

        System.out.println("=== Menú de Métodos de Resolución de Colisiones ===");
        System.out.println("1. Exploración Lineal");
        System.out.println("2. Exploración Cuadrática");
        System.out.println("3. Direccionamiento Encadenado");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        // Variables de tablas
        TablaHash tablaLineal = null;
        TablaHashCuadratica tablaCuadratica = null;
        TablaHashEncadenada tablaEncadenada = null;

        switch (opcion) {
            case 1:
                tablaLineal = new TablaHash(capacidad);
                System.out.println("\nUsando EXPLORACIÓN LINEAL\n");
                break;
            case 2:
                tablaCuadratica = new TablaHashCuadratica(capacidad);
                System.out.println("\nUsando EXPLORACIÓN CUADRÁTICA\n");
                break;
            case 3:
                tablaEncadenada = new TablaHashEncadenada(capacidad);
                System.out.println("\nUsando DIRECCIONAMIENTO ENCADENADO\n");
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // ---- Generar 100 libros aleatorios ----
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            int id = random.nextInt(1000); // IDs aleatorios entre 0 y 999
            String titulo = "Libro " + id;
            String autor = "Autor " + (char) ('A' + random.nextInt(26));

            Libro libro = new Libro(id, titulo, autor);

            if (tablaLineal != null) {
                tablaLineal.insertar(libro);
            } else if (tablaCuadratica != null) {
                tablaCuadratica.insertar(libro);
            } else if (tablaEncadenada != null) {
                tablaEncadenada.insertar(libro);
            }
        }

        // ---- Mostrar estado final de la tabla ----
        System.out.println("\nEstado final de la tabla con 100 libros aleatorios:");
        if (tablaLineal != null) tablaLineal.mostrarTabla();
        if (tablaCuadratica != null) tablaCuadratica.mostrarTabla();
        if (tablaEncadenada != null) tablaEncadenada.mostrarTabla();

        sc.close();
    }
}



