public class Main {
    public static void main(String[] args) {
        Libro[] libros = {
                new Libro(3, "Clean Code", "Robert C. Martin"),
                new Libro(1, "El Quijote", "Cervantes"),
                new Libro(5, "Cien años de soledad", "García Márquez"),
                new Libro(2, "La Odisea", "Homero"),
                new Libro(4, "1984", "George Orwell")
        };

        System.out.println("📚 Lista original:");
        for (Libro l : libros) {
            System.out.println(l);
        }

        // Ordenar por ID con Shell Sort
        System.out.println("\n🔢 Ordenando por ID con Shell Sort...");
        long inicio = System.nanoTime();
        ShellSort.ordenarPorId(libros);
        long fin = System.nanoTime();
        System.out.println("⏱️ Tiempo de ejecución: " + (fin - inicio) + " ns");

        System.out.println("\n📚 Lista ordenada por ID:");
        for (Libro l : libros) {
            System.out.println(l);
        }

        // Ordenar por título con Shell Sort
        System.out.println("\n🔤 Ordenando por Título con Shell Sort...");
        inicio = System.nanoTime();
        ShellSort.ordenarPorTitulo(libros);
        fin = System.nanoTime();
        System.out.println("⏱️ Tiempo de ejecución: " + (fin - inicio) + " ns");

        System.out.println("\n📚 Lista ordenada por Título:");
        for (Libro l : libros) {
            System.out.println(l);
        }

        // Ordenar por ID con Quick Sort
        System.out.println("\n⚡ Ordenando por ID con Quick Sort...");
        inicio = System.nanoTime();
        QuickSort.ordenarPorId(libros, 0, libros.length - 1);
        fin = System.nanoTime();
        System.out.println("⏱️ Tiempo de ejecución: " + (fin - inicio) + " ns");

        System.out.println("\n📚 Lista ordenada por ID (Quick Sort):");
        for (Libro l : libros) {
            System.out.println(l);
        }

        // Ordenar por Título con Quick Sort
        System.out.println("\n⚡ Ordenando por Título con Quick Sort...");
        inicio = System.nanoTime();
        QuickSort.ordenarPorTitulo(libros, 0, libros.length - 1);
        fin = System.nanoTime();
        System.out.println("⏱️ Tiempo de ejecución: " + (fin - inicio) + " ns");

        System.out.println("\n📚 Lista ordenada por Título (Quick Sort):");
        for (Libro l : libros) {
            System.out.println(l);
        }

        // ====================================
        // 📖 DÍA 3: Prueba con 1000 libros
        // ====================================
        System.out.println("\n\n📖 Día 3: Prueba con 1000 libros aleatorios");

        Libro[] milLibros1 = generarLibrosAleatorios(1000);
        Libro[] milLibros2 = milLibros1.clone(); // Copia exacta para comparar métodos

        // 🔤 Ordenar por Título con Shell Sort
        System.out.println("\n🔤 Ordenando 1000 libros por Título con Shell Sort...");
        inicio = System.nanoTime();
        ShellSort.ordenarPorTitulo(milLibros1);
        fin = System.nanoTime();
        System.out.println("⏱️ Tiempo Shell Sort: " + (fin - inicio) + " ns");

        // ⚡ Ordenar por Título con Quick Sort
        System.out.println("\n⚡ Ordenando 1000 libros por Título con Quick Sort...");
        inicio = System.nanoTime();
        QuickSort.ordenarPorTitulo(milLibros2, 0, milLibros2.length - 1);
        fin = System.nanoTime();
        System.out.println("⏱️ Tiempo Quick Sort: " + (fin - inicio) + " ns");

        System.out.println("\n✅ Ordenación completada para los 1000 libros.");

        // Mostrar los primeros 10 libros ordenados para verificar
        System.out.println("\n📘 Primeros 10 títulos (Quick Sort):");
        for (int i = 0; i < 10; i++) {
            System.out.println(milLibros2[i]);
        }

        // Repetimos 3 veces para obtener un promedio más fiable
        long[] tiemposShell = new long[3];
        long[] tiemposQuick = new long[3];

        for (int rep = 0; rep < 3; rep++) {
            Libro[] arrayShell = generarLibrosAleatorios(2000);
            Libro[] arrayQuick = arrayShell.clone();

            // Shell Sort
            inicio = System.nanoTime();
            ShellSort.ordenarPorTitulo(arrayShell);
            fin = System.nanoTime();
            tiemposShell[rep] = fin - inicio;

            // Quick Sort
            inicio = System.nanoTime();
            QuickSort.ordenarPorTitulo(arrayQuick, 0, arrayQuick.length - 1);
            fin = System.nanoTime();
            tiemposQuick[rep] = fin - inicio;
        }

// Calcular promedios
        long promedioShell = (tiemposShell[0] + tiemposShell[1] + tiemposShell[2]) / 3;
        long promedioQuick = (tiemposQuick[0] + tiemposQuick[1] + tiemposQuick[2]) / 3;

// Mostrar tabla en consola
        System.out.println("\n\n📊 Comparación de tiempos (2000 libros)");
        System.out.println("┌───────────────┬────────────────────────┐");
        System.out.println("│ Algoritmo     │ Tiempo promedio (ns)   │");
        System.out.println("├───────────────┼────────────────────────┤");
        System.out.println("│ Shell Sort    │ " + promedioShell + " │");
        System.out.println("│ Quick Sort    │ " + promedioQuick + " │");
        System.out.println("└───────────────┴────────────────────────┘");

        if (promedioShell > promedioQuick) {
            System.out.println("\n✅ Quick Sort fue más rápido ");
        } else {
            System.out.println("\n✅ Shell Sort fue más rápido ");
        }
    }

    // ==============================
    // Método para generar libros aleatorios
    // ==============================
    public static Libro[] generarLibrosAleatorios(int cantidad) {
        Libro[] libros = new Libro[cantidad];
        String[] palabras = {"Luz", "Sombra", "Destino", "Eterno", "Camino", "Silencio", "Tiempo", "Fuego", "Alma", "Cielo"};

        for (int i = 0; i < cantidad; i++) {
            String titulo = palabras[(int) (Math.random() * palabras.length)] + " " + (int) (Math.random() * 10000);
            String autor = "Autor " + (i + 1);
            libros[i] = new Libro(i + 1, titulo, autor);
        }
        return libros;
    }
}

