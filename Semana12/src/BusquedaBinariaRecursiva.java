public class BusquedaBinariaRecursiva {

    // 🔢 Buscar por ID (recursivo)
    public static Libro buscarPorId(Libro[] libros, int idBuscado, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return null; // no encontrado
        }

        int medio = (izquierda + derecha) / 2;
        int idMedio = libros[medio].getId();

        if (idMedio == idBuscado) {
            return libros[medio];
        } else if (idMedio < idBuscado) {
            return buscarPorId(libros, idBuscado, medio + 1, derecha);
        } else {
            return buscarPorId(libros, idBuscado, izquierda, medio - 1);
        }
    }

    // 🔤 Buscar por título (recursivo)
    public static Libro buscarPorTitulo(Libro[] libros, String tituloBuscado, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return null; // no encontrado
        }

        int medio = (izquierda + derecha) / 2;
        String tituloMedio = libros[medio].getTitulo();

        int comparacion = tituloMedio.compareToIgnoreCase(tituloBuscado);

        if (comparacion == 0) {
            return libros[medio];
        } else if (comparacion < 0) {
            return buscarPorTitulo(libros, tituloBuscado, medio + 1, derecha);
        } else {
            return buscarPorTitulo(libros, tituloBuscado, izquierda, medio - 1);
        }
    }
}

