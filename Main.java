import java.util.Scanner;

public class Main {

    public static int busquedaBinaria(int[] array, int x) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (array[medio] == x) {
                return medio;
            }
            if (array[medio] < x) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 8, 10, 12, 14};

        Scanner sc = new Scanner(System.in);

        System.out.println("Array disponible:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.print("¿Cuántos números desea buscar? ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el número a buscar: ");
            int buscar = sc.nextInt();

            int resultado = busquedaBinaria(numeros, buscar);
            if (resultado != -1) {
                System.out.println("✔ Elemento " + buscar + " encontrado en el índice: " + resultado);
            } else {
                System.out.println("✘ Elemento " + buscar + " no encontrado.");
            }
        }
    }
}

