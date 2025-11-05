public class RecursividadIndirecta {

        public static void ejecutar() {
            System.out.println("\n=== DÍA 3: RECURSIVIDAD INDIRECTA ===");
            System.out.println("Contando pares e impares hasta 10...\n");
            contarPar(1);
        }

        // Método A
        public static void contarPar(int n) {
            if (n > 10) return;
            System.out.println("Número par: " + n);
            contarImpar(n + 1); // Llama al método B
        }

        // Método B
        public static void contarImpar(int n) {
            if (n > 10) return;
            System.out.println("Número impar: " + n);
            contarPar(n + 1); // Llama nuevamente al método A
        }
}


