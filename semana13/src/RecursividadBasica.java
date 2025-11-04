public class RecursividadBasica {

    // Factorial: n! = n * (n-1)!
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // caso base
        } else {
            return n * factorial(n - 1); // llamada recursiva
        }
    }

    // Suma: 1 + 2 + ... + n
    public static int sumaHasta(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaHasta(n - 1);
        }
    }

    // Potencia: aⁿ
    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    public static void ejecutar() {
        System.out.println("\n=== DÍA 1: RECURSIVIDAD BÁSICA ===");
        System.out.println("Factorial de 5 = " + factorial(5));
        System.out.println("Suma hasta 5 = " + sumaHasta(5));
        System.out.println("2 elevado a la 5 = " + potencia(2, 5));
    }
}
