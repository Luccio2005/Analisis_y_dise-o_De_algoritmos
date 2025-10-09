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

        Runtime runtime = Runtime.getRuntime(); // para medir memoria

        // ---- Insertar 100 libros en la tabla Lineal ----
        runtime.gc();
        long memoriaAntesLineal = runtime.totalMemory() - runtime.freeMemory();
        long inicioLineal = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);
            tablaLineal.insertar(libro);
        }

        long finLineal = System.nanoTime();
        long memoriaDespuesLineal = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsadaLineal = memoriaDespuesLineal - memoriaAntesLineal;

        // ---- Insertar 100 libros en la tabla Cuadrática ----
        runtime.gc();
        long memoriaAntesCuadratica = runtime.totalMemory() - runtime.freeMemory();
        long inicioCuadratica = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);
            tablaCuadratica.insertar(libro);
        }

        long finCuadratica = System.nanoTime();
        long memoriaDespuesCuadratica = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsadaCuadratica = memoriaDespuesCuadratica - memoriaAntesCuadratica;

        // ---- Insertar 100 libros en la tabla Encadenada ----
        runtime.gc();
        long memoriaAntesEncadenada = runtime.totalMemory() - runtime.freeMemory();
        long inicioEncadenada = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);
            tablaEncadenada.insertar(libro);
        }

        long finEncadenada = System.nanoTime();
        long memoriaDespuesEncadenada = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsadaEncadenada = memoriaDespuesEncadenada - memoriaAntesEncadenada;

        // ---- Comparar eficiencia ----
        System.out.println("\n--- Comparación de eficiencia ---");
        System.out.println("Lineal -> Colisiones: " + tablaLineal.getColisiones() +
                " | Tiempo: " + (finLineal - inicioLineal) / 1_000_000.0 + " ms" +
                " | Memoria: " + memoriaUsadaLineal / 1024.0 + " KB");

        System.out.println("Cuadrática -> Colisiones: " + tablaCuadratica.getColisiones() +
                " | Tiempo: " + (finCuadratica - inicioCuadratica) / 1_000_000.0 + " ms" +
                " | Memoria: " + memoriaUsadaCuadratica / 1024.0 + " KB");

        System.out.println("Encadenada -> Colisiones: " + tablaEncadenada.getColisiones() +
                " | Tiempo: " + (finEncadenada - inicioEncadenada) / 1_000_000.0 + " ms" +
                " | Memoria: " + memoriaUsadaEncadenada / 1024.0 + " KB");

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







