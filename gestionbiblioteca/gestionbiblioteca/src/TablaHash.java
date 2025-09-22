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

    // ---- Día 8: Inserción con exploración lineal ----
    public void insertar(Libro libro){
        int indiceOriginal = funcionHash(libro.getId());
        int indice = indiceOriginal;

        // Mientras haya colisión, avanza a la siguiente posición
        int intentos = 0;
        while (tabla[indice] != null && intentos < capacidad) {
            intentos++;
            indice = (indiceOriginal + intentos * intentos)% capacidad;
        }

        if (intentos == capacidad) {
            System.out.println("Error: la tabla está llena, no se pudo insertar " + libro);
        } else {
            tabla[indice] = libro;
        }
    }

    // ---- Día 8: Búsqueda con exploración lineal ----
    public Libro buscarPorId(int id) {
        int indiceOriginal = funcionHash(id);
        int indice = indiceOriginal;

        int intentos = 0;
        while (tabla[indice] != null && intentos < capacidad) {
            if (tabla[indice].getId() == id) {
                return tabla[indice]; // encontrado
            }
            intentos++;
            indice = (indiceOriginal + intentos * intentos) % capacidad;
        }
        return null; // no encontrado
    }

    // Método para mostrar el contenido de la tabla
    public void mostrarTabla() {
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null) {
                System.out.println("Posición " + i + ": " + tabla[i]);
            } else {
                System.out.println("Posición " + i + ": [vacío]");
            }
        }
    }
    public void mostrarPosicion(int i) {
        if (tabla[i] != null) {
            System.out.println("Posición " + i + ": " + tabla[i]);
        } else {
            System.out.println("Posición " + i + ": [vacío]");
        }
    }
}

