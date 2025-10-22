public class QuickSort {

    // Ordenar por ID
    public static void ordenarPorId(Libro[] libros, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particionPorId(libros, izquierda, derecha);
            ordenarPorId(libros, izquierda, indiceParticion - 1);
            ordenarPorId(libros, indiceParticion + 1, derecha);
        }
    }

    private static int particionPorId(Libro[] libros, int izquierda, int derecha) {
        int pivote = libros[derecha].getId();
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (libros[j].getId() <= pivote) {
                i++;
                Libro temp = libros[i];
                libros[i] = libros[j];
                libros[j] = temp;
            }
        }
        Libro temp = libros[i + 1];
        libros[i + 1] = libros[derecha];
        libros[derecha] = temp;
        return i + 1;
    }

    // Ordenar por Título
    public static void ordenarPorTitulo(Libro[] libros, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particionPorTitulo(libros, izquierda, derecha);
            ordenarPorTitulo(libros, izquierda, indiceParticion - 1);
            ordenarPorTitulo(libros, indiceParticion + 1, derecha);
        }
    }

    private static int particionPorTitulo(Libro[] libros, int izquierda, int derecha) {
        String pivote = libros[derecha].getTitulo().toLowerCase();
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (libros[j].getTitulo().toLowerCase().compareTo(pivote) <= 0) {
                i++;
                Libro temp = libros[i];
                libros[i] = libros[j];
                libros[j] = temp;
            }
        }
        Libro temp = libros[i + 1];
        libros[i + 1] = libros[derecha];
        libros[derecha] = temp;
        return i + 1;
    }
}
