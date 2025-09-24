import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidad = 5;

        System.out.println("=== Menú de Métodos de Resolución de Colisiones ===");
        System.out.println("1. Exploración Lineal");
        System.out.println("2. Exploración Cuadrática");
        System.out.println("3. Direccionamiento Encadenado");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        // Variables de tablas (solo una se usará según la elección)
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

        // ---- Libros de prueba ----
        Libro libro1 = new Libro(1, "Libro 1", "Autor A");
        Libro libro2 = new Libro(6, "Libro 2", "Autor B"); // colisión con 1
        Libro libro3 = new Libro(11, "Libro 3", "Autor C"); // colisión con 1 y 6

        // ---- Insertar en la tabla elegida ----
        if (tablaLineal != null) {
            tablaLineal.insertar(libro1);
            tablaLineal.insertar(libro2);
            tablaLineal.insertar(libro3);
            tablaLineal.mostrarTabla();
        } else if (tablaCuadratica != null) {
            tablaCuadratica.insertar(libro1);
            tablaCuadratica.insertar(libro2);
            tablaCuadratica.insertar(libro3);
            tablaCuadratica.mostrarTabla();
        } else if (tablaEncadenada != null) {
            tablaEncadenada.insertar(libro1);
            tablaEncadenada.insertar(libro2);
            tablaEncadenada.insertar(libro3);
            tablaEncadenada.mostrarTabla();
        }

        sc.close();
    }
}


