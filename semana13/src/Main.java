import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== PROYECTO RECURSIVIDAD ===");
            System.out.println("1. Recursividad básica");
            System.out.println("2. Pila de llamadas");
            System.out.println("3. Recursividad indirecta (próximo)");
            System.out.println("4. Laberinto con backtracking");
            System.out.println("5. Recursión vs Iteración");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    RecursividadBasica.ejecutar();
                    break;
                case 2:
                    PilaDeLlamadas.ejecutar();
                    break;
                case 3:
                    RecursividadIndirecta.ejecutar();
                    break;
                case 4:
                    System.out.println("Backtracking aún no implementado.");
                    break;
                case 5:
                    System.out.println("Comparación aún no implementada.");
                    break;
                case 6:
                    System.out.println(" Saliendo del programa...");
                    break;
                default:
                    System.out.println(" Opción no válida");
            }
        } while (opcion != 6);
    }
}


