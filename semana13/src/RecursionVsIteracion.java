public class RecursionVsIteracion {

    // Método principal del día 5
    public static void ejecutar() {
        System.out.println("\n=== DÍA 5: RECURSIÓN VS ITERACIÓN ===");

        int n = 10;
        System.out.println("Mostrando los primeros " + n + " números de Fibonacci:\n");

        System.out.print("🌀 Recursivo: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursivo(i) + " ");
        }

        System.out.print("\n🔁 Iterativo: ");
        fibonacciIterativo(n);

        // Comparación de tiempos
        long inicioR = System.nanoTime();
        fibonacciRecursivo(n - 1);
        long finR = System.nanoTime();

        long inicioI = System.nanoTime();
        fibonacciIterativo(n);
        long finI = System.nanoTime();

        System.out.println("\n\n⏱️ Tiempo Recursivo: " + (finR - inicioR) + " ns");
        System.out.println("⚡ Tiempo Iterativo: " + (finI - inicioI) + " ns");
        System.out.println("\nConclusión: la recursión es más elegante, pero la iteración es más rápida y eficiente.");
    }

    // --- Fibonacci recursivo ---
    private static int fibonacciRecursivo(int n) {
        if (n <= 1) return n;
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

    // --- Fibonacci iterativo ---
    private static void fibonacciIterativo(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}
