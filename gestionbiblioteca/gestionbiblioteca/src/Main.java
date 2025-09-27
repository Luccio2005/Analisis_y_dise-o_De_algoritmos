import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---- Menú de selección ----
        System.out.println("Elige la estrategia de tabla hash:");
        System.out.println("1. Exploración lineal");
        System.out.println("2. Exploración cuadrática");
        System.out.println("3. Encadenamiento separado");
        int opcion = sc.nextInt();

        int capacidad = 101; // número primo cercano a 100
        Random random = new Random();

        TablaHash tablaLineal = null;
        TablaHashCuadratica tablaCuadratica = null;
        TablaHashEncadenada tablaEncadenada = null;

        // ---- Crear tabla según opción ----
        if (opcion == 1) {
            tablaLineal = new TablaHash(capacidad);
        } else if (opcion == 2) {
            tablaCuadratica = new TablaHashCuadratica(capacidad);
        } else if (opcion == 3) {
            tablaEncadenada = new TablaHashEncadenada(capacidad);
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        // ---- Insertar 100 libros aleatorios ----
        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1;
            Libro libro = new Libro(id, "Libro" + id, "Autor" + id);

            if (tablaLineal != null) tablaLineal.insertar(libro);
            else if (tablaCuadratica != null) tablaCuadratica.insertar(libro);
            else if (tablaEncadenada != null) tablaEncadenada.insertar(libro);
        }
        // ---- Comparar eficiencia ----
        System.out.println("\n--- Comparación de eficiencia ---");
        if (tablaLineal != null) {
            System.out.println("Colisiones (lineal): " + tablaLineal.getColisiones());
        }
        if (tablaCuadratica != null) {
            System.out.println("Colisiones (cuadrática): " + tablaCuadratica.getColisiones());
        }
        if (tablaEncadenada != null) {
            System.out.println("Colisiones (encadenada): " + tablaEncadenada.getColisiones());
        }

        // ---- Mostrar tabla inicial ----
        System.out.println("\nTabla inicial:");
        if (tablaLineal != null) tablaLineal.mostrarTabla();
        if (tablaCuadratica != null) tablaCuadratica.mostrarTabla();
        if (tablaEncadenada != null) tablaEncadenada.mostrarTabla();

        // ---- Buscar libro ----
        System.out.print("\nIngresa el ID de un libro para buscar: ");
        int idBuscar = sc.nextInt();
        Libro encontrado = null;

        if (tablaLineal != null) encontrado = tablaLineal.buscarPorId(idBuscar);
        else if (tablaCuadratica != null) encontrado = tablaCuadratica.buscarPorId(idBuscar);
        else if (tablaEncadenada != null) encontrado = tablaEncadenada.buscarPorId(idBuscar);

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró el libro con id " + idBuscar);
        }

        // ---- Eliminar libro ----
        System.out.print("\nIngresa el ID de un libro para eliminar: ");
        int idEliminar = sc.nextInt();

        if (tablaLineal != null) tablaLineal.eliminar(idEliminar);
        else if (tablaCuadratica != null) tablaCuadratica.eliminar(idEliminar);
        else if (tablaEncadenada != null) tablaEncadenada.eliminar(idEliminar);

        // ---- Mostrar tabla final ----
        System.out.println("\nTabla después de eliminación:");
        if (tablaLineal != null) tablaLineal.mostrarTabla();
        if (tablaCuadratica != null) tablaCuadratica.mostrarTabla();
        if (tablaEncadenada != null) tablaEncadenada.mostrarTabla();

        sc.close();
    }
}




