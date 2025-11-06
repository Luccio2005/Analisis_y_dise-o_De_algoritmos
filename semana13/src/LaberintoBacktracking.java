public class LaberintoBacktracking {

    // 0 = camino libre, 1 = pared, 9 = salida
    private static int[][] laberinto = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 9}
    };

    private static boolean[][] visitado = new boolean[5][5];

    public static void ejecutar() {
        System.out.println("\n=== DÍA 4: BACKTRACKING - LABERINTO ===");
        System.out.println("Laberinto (0=libre, 1=pared, 9=salida):\n");
        imprimirLaberinto();

        System.out.println("\nBuscando camino...\n");
        if (resolver(0, 0)) {
            System.out.println("✅ ¡Salida encontrada!");
        } else {
            System.out.println("❌ No hay salida posible.");
        }
    }

    // Backtracking principal
    private static boolean resolver(int fila, int col) {
        // Si está fuera de límites o es pared o ya visitado → retroceder
        if (fila < 0 || col < 0 || fila >= 5 || col >= 5 || laberinto[fila][col] == 1 || visitado[fila][col]) {
            return false;
        }

        // Si encontramos la salida
        if (laberinto[fila][col] == 9) {
            System.out.println("Salida encontrada en [" + fila + "," + col + "]");
            return true;
        }

        // Marcar como visitado
        visitado[fila][col] = true;
        System.out.println("Visitando [" + fila + "," + col + "]");

        // Explorar en 4 direcciones: abajo, derecha, arriba, izquierda
        if (resolver(fila + 1, col) || resolver(fila, col + 1) ||
                resolver(fila - 1, col) || resolver(fila, col - 1)) {
            return true;
        }

        // Si no se encontró camino, retroceder
        System.out.println("Retrocediendo desde [" + fila + "," + col + "]");
        return false;
    }

    // Método auxiliar para mostrar el laberinto
    private static void imprimirLaberinto() {
        for (int[] fila : laberinto) {
            for (int celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}

