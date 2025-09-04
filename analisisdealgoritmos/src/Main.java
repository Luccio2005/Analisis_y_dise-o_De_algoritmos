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
            System.out.println("6. Ordenar con Mezcla Equilibrada Múltiple (O(n log n))");
            System.out.println("7. Ordenar con Método Polifásico (O(n log n))");
            System.out.println("8. Cambiar datos");
            System.out.println("9. Salir");


            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingresa un número válido.");
                continue;
            }

            if (opcion == 9) break;

            if (opcion == 8) {
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

            if (opcion < 1 || opcion > 7) {
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
                case 6:
                    mergeSortEquilibradaMultiple(arreglo, 3); // ejemplo con 3 archivos auxiliares
                    break;
                case 7:
                    mergeSortPolifasico(arreglo);
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
    // 6) Mezcla Equilibrada Múltiple — Simulada en memoria
    public static void mergeSortEquilibradaMultiple(int[] arr, int m) {
        if (arr.length <= 1) return;

        List<List<Integer>> runs = detectarRuns(arr);

        // Mientras haya más de una run, seguimos mezclando
        while (runs.size() > 1) {
            List<List<Integer>> nuevasRuns = new ArrayList<>();

            for (int i = 0; i < runs.size(); i += (m - 1)) {
                List<Integer> mezcla = new ArrayList<>(runs.get(i));

                // fusionar hasta m-1 runs
                for (int j = 1; j < m - 1 && (i + j) < runs.size(); j++) {
                    mezcla = fusionarListas(mezcla, runs.get(i + j));
                }
                nuevasRuns.add(mezcla);
            }

            runs = nuevasRuns; // siguiente pasada
        }

        // copiar resultado al arreglo original
        List<Integer> ordenado = runs.get(0);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ordenado.get(i);
        }
    }
    // 7) Método Polifásico de Ordenación Externa (simulado en memoria)
    public static void mergeSortPolifasico(int[] arr) {
        if (arr.length <= 1) return;

        // 1. Detectar runs naturales
        List<List<Integer>> runs = detectarRuns(arr);

        // 2. Distribuir runs usando serie de Fibonacci
        List<List<Integer>> A = new ArrayList<>();
        List<List<Integer>> B = new ArrayList<>();
        List<List<Integer>> C = new ArrayList<>();

        distribuirFibonacci(runs, A, B);

        // 3. Proceso de mezcla polifásica
        while (A.size() + B.size() + C.size() > 1) {
            if (A.isEmpty()) {
                // rotar roles: B->A, C->B, A->C
                List<List<Integer>> tmp = A;
                A = B;
                B = C;
                C = tmp;
            } else if (B.isEmpty()) {
                // rotar roles: A->B, C->A, B->C
                List<List<Integer>> tmp = B;
                B = A;
                A = C;
                C = tmp;
            }

            // fusionar el primer run de A y de B
            if (!A.isEmpty() && !B.isEmpty()) {
                List<Integer> runA = A.remove(0);
                List<Integer> runB = B.remove(0);
                List<Integer> fusion = fusionarListas(runA, runB);
                C.add(fusion);
            }
        }

        // 4. Copiar resultado final
        List<Integer> ordenado;
        if (!A.isEmpty()) ordenado = A.get(0);
        else if (!B.isEmpty()) ordenado = B.get(0);
        else ordenado = C.get(0);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ordenado.get(i);
        }
    }

    // Distribuye los runs entre dos archivos según serie de Fibonacci
    private static void distribuirFibonacci(List<List<Integer>> runs,
                                            List<List<Integer>> A,
                                            List<List<Integer>> B) {
        // Calcular números de Fibonacci hasta cubrir la cantidad de runs
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        while (fibs.get(fibs.size() - 1) < runs.size()) {
            int n = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            fibs.add(n);
        }

        // Tomar el último valor válido
        int total = fibs.get(fibs.size() - 1);

        // Distribuir runs: A recibe F(k-1), B recibe F(k-2)
        int cantidadA = fibs.get(fibs.size() - 2);
        int cantidadB = total - cantidadA;

        int index = 0;
        for (int i = 0; i < cantidadA && index < runs.size(); i++) {
            A.add(runs.get(index++));
        }
        for (int i = 0; i < cantidadB && index < runs.size(); i++) {
            B.add(runs.get(index++));
        }
    }


    // Detecta runs crecientes en el arreglo
    private static List<List<Integer>> detectarRuns(int[] arr) {
        List<List<Integer>> runs = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        actual.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            comparaciones++;
            if (arr[i] >= arr[i - 1]) {
                actual.add(arr[i]);
            } else {
                runs.add(actual);
                actual = new ArrayList<>();
                actual.add(arr[i]);
            }
        }
        runs.add(actual);
        return runs;
    }

    // Fusiona dos listas ordenadas
    private static List<Integer> fusionarListas(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            comparaciones++;
            if (a.get(i) <= b.get(j)) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
            intercambios++;
        }
        while (i < a.size()) {
            res.add(a.get(i++));
            intercambios++;
        }
        while (j < b.size()) {
            res.add(b.get(j++));
            intercambios++;
        }
        return res;
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

