public class PilaDeLlamadas {

    // Método auxiliar para generar espacios (compatible con Java 8)
    private static String generarEspacios(int cantidad) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidad; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int factorialConTraza(int n, int nivel) {
        String espacios = generarEspacios(nivel * 2);
        System.out.println(espacios + "→ Entrando a factorial(" + n + ")");

        if (n == 0 || n == 1) {
            System.out.println(espacios + "← Caso base alcanzado, retorno 1");
            return 1;
        }

        int resultado = n * factorialConTraza(n - 1, nivel + 1);

        System.out.println(espacios + "← Retornando " + resultado + " desde factorial(" + n + ")");
        return resultado;
    }

    public static void ejecutar() {
        System.out.println("\n=== DÍA 2: PILA DE LLAMADAS ===");
        int resultado = factorialConTraza(5, 0);
        System.out.println("\nResultado final: " + resultado);
    }
}

