public class ShellSort {

    // Ordena los libros por id usando Shell Sort
    public static void ordenarPorId(Libro[] libros) {
        int n = libros.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Libro temp = libros[i];
                int j;
                for (j = i; j >= gap && libros[j - gap].getId() > temp.getId(); j -= gap) {
                    libros[j] = libros[j - gap];
                }
                libros[j] = temp;
            }
        }
    }

    // Ordena los libros por título alfabéticamente
    public static void ordenarPorTitulo(Libro[] libros) {
        int n = libros.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Libro temp = libros[i];
                int j;
                for (j = i; j >= gap && libros[j - gap].getTitulo().compareToIgnoreCase(temp.getTitulo()) > 0; j -= gap) {
                    libros[j] = libros[j - gap];
                }
                libros[j] = temp;
            }
        }
    }
}
