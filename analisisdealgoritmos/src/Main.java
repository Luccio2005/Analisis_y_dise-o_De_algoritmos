import java.util.*;

public class Main {

    // Contadores globales
    static long comparaciones;
    static long intercambios; // en O(n^2) = swaps; en merge = movimientos/asignaciones

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de ejemplo (puedes cambiarlos con la opción 6)
        int[] datos = {34, 12, 5, 66, 1, 99, 23, 7};

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL (Java 8) ===");
            System.out.println("1. Ordenar con Burbuja (O(n^2))");
            System.out.println("2. Ordenar con Selección (O(n^2))");
            System.out.println("3. Ordenar con Inserción (O(n^2))");
            System.out.println("4. Ordenar con Merge Sort (O(n log n))");
            System.out.println("5. Ordenar con Merge Natural (O(n log n) aprox.)");
            System.out.println("6. Cambiar datos");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingresa un número válido.");
                continue;
            }

            if (opcion == 7) break;

            if (opcion == 6) {
                System.out.println("Ingresa enteros separados por espacio (ej: 5 3 8 1 2):");
                String linea = sc.nextLine();
                try {
                    datos = parsearEnteros(linea);
                    System.out.println("Datos cargados: " + Arrays.toString(datos));
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Mantengo los datos anteriores.");
                }
                continue;
            }

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción inválida.");
                continue;
            }

            int[] arreglo = Arrays.copyOf(datos, datos.length); // trabajar con copia
            comparaciones = 0;
            intercambios = 0;

            long inicio = System.nanoTime();
            switch (opcion) {
                case 1:
                    burbuja(arreglo);
                    break;
                case 2:
                    seleccion(arreglo);
                    break;
                case 3:
                    insercion(arreglo);
                    break;
                case 4:
                    mergeSort(arreglo, 0, arreglo.length - 1);
                    break;
                case 5:
                    mergeSortNatural(arreglo);
                    break;
                default:
                    // ya validado arriba
                    break;
            }
            long fin = System.nanoTime();

            System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
            System.out.println("Comparaciones: " + comparaciones);
            System.out.println("Intercambios / Movimientos: " + intercambios);
            System.out.println("Tiempo de ejecución: " + ((fin - inicio) / 1e6) + " ms");
        }

        sc.close();
        System.out.println("Fin del programa.");
    }

    // ===== Utilidad para cargar datos =====
    private static int[] parsearEnteros(String linea) {
        String[] partes = linea.trim().split("\\s+");
        int[] arr = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            arr[i] = Integer.parseInt(partes[i]);
        }
        return arr;
    }

    // ========================= ALGORITMOS =========================
    // 1) Burbuja — Complejidad: O(n^2)
    public static void burbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    intercambios++;
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    // 2) Selección — Complejidad: O(n^2)
    public static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparaciones++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                intercambios++;
                int t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;
            }
        }
    }

    // 3) Inserción — Complejidad: O(n^2)
    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparaciones++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    intercambios++; // movimiento (shift)
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    // 4) Merge Sort — Complejidad: O(n log n)
    public static void mergeSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(arr, izq, mid);
            mergeSort(arr, mid + 1, der);
            merge(arr, izq, mid, der);
        }
    }

    private static void merge(int[] arr, int izq, int mid, int der) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            comparaciones++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            intercambios++; // contamos la asignación al arreglo final como movimiento
        }
        while (i < n1) {
            arr[k++] = L[i++];
            intercambios++;
        }
        while (j < n2) {
            arr[k++] = R[j++];
            intercambios++;
        }
    }

    // 5) Merge Natural — Detecta runs naturales y los fusiona
    public static void mergeSortNatural(int[] arr) {
        boolean ordenado = false;
        int[] aux = new int[arr.length];

        while (!ordenado) {
            int inicio = 0;
            ordenado = true; // si no hacemos ninguna fusión, ya está ordenado

            while (inicio < arr.length - 1) {
                int medio = inicio;
                // primera run creciente
                while (medio + 1 < arr.length && arr[medio] <= arr[medio + 1]) {
                    medio++;
                }
                if (medio == arr.length - 1) break; // no hay segunda run

                int fin = medio + 1;
                // segunda run creciente
                while (fin + 1 < arr.length && arr[fin] <= arr[fin + 1]) {
                    fin++;
                }

                // fusionar [inicio..medio] y [medio+1..fin] en aux y devolver a arr
                mergeNatural(arr, aux, inicio, medio, fin);
                ordenado = false;
                inicio = fin + 1;
            }
        }
    }

    private static void mergeNatural(int[] arr, int[] aux, int inicio, int medio, int fin) {
        int i = inicio, j = medio + 1, k = inicio;

        while (i <= medio && j <= fin) {
            comparaciones++;
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
        while (i <= medio) aux[k++] = arr[i++];
        while (j <= fin) aux[k++] = arr[j++];

        for (i = inicio; i <= fin; i++) {
            arr[i] = aux[i];
            intercambios++; // contamos la escritura final en arr como movimiento
        }
    }
}

