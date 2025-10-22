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

        // Ordenar por ID
        System.out.println("\n🔢 Ordenando por ID con Shell Sort...");
        long inicio = System.nanoTime();
        ShellSort.ordenarPorId(libros);
        long fin = System.nanoTime();
        System.out.println("⏱️ Tiempo de ejecución: " + (fin - inicio) + " ns");

        System.out.println("\n📚 Lista ordenada por ID:");
        for (Libro l : libros) {
            System.out.println(l);
        }

        // Ordenar por título
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
    }
}
