public class TablaHash {
    private Libro[] tabla;  // Arreglo que almacena los libros
    private int capacidad;  // Tamaño de la tabla

    // Constructor
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Libro[capacidad];
    }

    private int funcionHash(int id){
        return id % capacidad;
    }

    public void insertar(Libro libro){
        int indice = funcionHash(libro.getId());
        tabla[indice] = libro;
    }

    // ---- Día 5: Buscar libro por id ----
    public Libro buscarPorId(int id) {
        int indice = funcionHash(id);
        return tabla[indice];  // puede devolver null si no hay nada
    }

    // Método para mostrar el contenido de la tabla (solo para pruebas iniciales)
    public void mostrarTabla() {
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                System.out.println("Posición " + i + ": " + tabla[i]);
            } else {
                System.out.println("Posición " + i + ": [vacío]");
            }
        }
    }
}
