public class BusquedaBinaria {

    // 🔢 Buscar por ID (iterativo)
    public static Libro buscarPorId(Libro[] libros, int idBuscado) {
        int izquierda = 0;
        int derecha = libros.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int idMedio = libros[medio].getId();

            if (idMedio == idBuscado) {
                return libros[medio]; // encontrado
            } else if (idMedio < idBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null; // no encontrado
    }

    // 🔤 Buscar por título (iterativo)
    public static Libro buscarPorTitulo(Libro[] libros, String tituloBuscado) {
        int izquierda = 0;
        int derecha = libros.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            String tituloMedio = libros[medio].getTitulo();

            int comparacion = tituloMedio.compareToIgnoreCase(tituloBuscado);

            if (comparacion == 0) {
                return libros[medio]; // encontrado
            } else if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null; // no encontrado
    }
}
