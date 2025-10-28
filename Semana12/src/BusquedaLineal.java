public class BusquedaLineal {

    // Buscar por ID
    public static Libro buscarPorId(Libro[] libros, int idBuscado) {
        for (Libro libro : libros) {
            if (libro.getId() == idBuscado) {
                return libro;
            }
        }
        return null; // No encontrado
    }

    // Buscar por título
    public static Libro buscarPorTitulo(Libro[] libros, String tituloBuscado) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                return libro;
            }
        }
        return null; // No encontrado
    }
}

