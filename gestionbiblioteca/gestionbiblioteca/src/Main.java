import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacidad = 101; // número primo cercano a 100
        Random random = new Random();

        // Crear las 3 tablas
        TablaHash tablaLineal = new TablaHash(capacidad);
        TablaHashCuadratica tablaCuadratica = new TablaHashCuadratica(capacidad);
        TablaHashEncadenada tablaEncadenada = new TablaHashEncadenada(capacidad);

        // ---- Insertar 100 libros aleatorios en cada tabla y medir tiempos ----
        long inicioLineal = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);
            tablaLineal.insertar(libro);
        }
        long finLineal = System.nanoTime();

        long inicioCuadratica = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);
            tablaCuadratica.insertar(libro);
        }
        long finCuadratica = System.nanoTime();

        long inicioEncadenada = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);
            tablaEncadenada.insertar(libro);
        }
        long finEncadenada = System.nanoTime();

        // ---- Comparar eficiencia ----
        System.out.println("\n--- Comparación de eficiencia ---");
        System.out.println("Colisiones (lineal): " + tablaLineal.getColisiones());
        System.out.println("Tiempo (lineal): " + (finLineal - inicioLineal) / 1_000_000.0 + " ms");

        System.out.println("Colisiones (cuadrática): " + tablaCuadratica.getColisiones());
        System.out.println("Tiempo (cuadrática): " + (finCuadratica - inicioCuadratica) / 1_000_000.0 + " ms");

        System.out.println("Colisiones (encadenada): " + tablaEncadenada.getColisiones());
        System.out.println("Tiempo (encadenada): " + (finEncadenada - inicioEncadenada) / 1_000_000.0 + " ms");

        // ---- Mostrar tablas ----
        System.out.println("\nTabla Lineal:");
        tablaLineal.mostrarTabla();

        System.out.println("\nTabla Cuadrática:");
        tablaCuadratica.mostrarTabla();

        System.out.println("\nTabla Encadenada:");
        tablaEncadenada.mostrarTabla();

        // ---- Buscar libro ----
        System.out.print("\nIngresa el ID de un libro para buscar: ");
        int idBuscar = sc.nextInt();

        Libro encontradoLineal = tablaLineal.buscarPorId(idBuscar);
        Libro encontradoCuadratica = tablaCuadratica.buscarPorId(idBuscar);
        Libro encontradoEncadenada = tablaEncadenada.buscarPorId(idBuscar);

        System.out.println("\nResultado búsqueda:");
        System.out.println("Lineal -> " + (encontradoLineal != null ? encontradoLineal : "No encontrado"));
        System.out.println("Cuadrática -> " + (encontradoCuadratica != null ? encontradoCuadratica : "No encontrado"));
        System.out.println("Encadenada -> " + (encontradoEncadenada != null ? encontradoEncadenada : "No encontrado"));

        // ---- Eliminar libro ----
        System.out.print("\nIngresa el ID de un libro para eliminar: ");
        int idEliminar = sc.nextInt();

        tablaLineal.eliminar(idEliminar);
        tablaCuadratica.eliminar(idEliminar);
        tablaEncadenada.eliminar(idEliminar);

        // ---- Mostrar tablas después de eliminar ----
        System.out.println("\nTabla Lineal después de eliminar:");
        tablaLineal.mostrarTabla();

        System.out.println("\nTabla Cuadrática después de eliminar:");
        tablaCuadratica.mostrarTabla();

        System.out.println("\nTabla Encadenada después de eliminar:");
        tablaEncadenada.mostrarTabla();

        sc.close();
    }
}






