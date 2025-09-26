public class TablaHash {
    private Libro[] tabla;
    private int capacidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Libro[capacidad];
    }

    private int funcionHash(int id) {
        return id % capacidad;
    }

    public void insertar(Libro libro) {
        int indice = funcionHash(libro.getId());
        int intentos = 0;

        while (tabla[indice] != null && intentos < capacidad) {
            intentos++;
            indice = (indice + 1) % capacidad; // exploración lineal
        }

        if (intentos == capacidad) {
            System.out.println("Error: la tabla está llena.");
        } else {
            tabla[indice] = libro;
        }
    }

    public Libro buscarPorId(int id) {
        int indice = funcionHash(id);
        int intentos = 0;

        while (tabla[indice] != null && intentos < capacidad) {
            if (tabla[indice].getId() == id) {
                return tabla[indice];
            }
            intentos++;
            indice = (indice + 1) % capacidad;
        }
        return null;
    }

    public void mostrarTabla() {
        for (int i = 0; i < capacidad; i++) {
            System.out.println("Posición " + i + ": " + (tabla[i] != null ? tabla[i] : "[vacío]"));
        }
    }
    public void eliminar(int id) {
        int indice = funcionHash(id);
        int intentos = 0;

        while (tabla[indice] != null && intentos < capacidad) {
            if (tabla[indice].getId() == id) {
                System.out.println("Eliminando: " + tabla[indice]);
                tabla[indice] = null;
                return;
            }
            intentos++;
            indice = (indice + 1) % capacidad;
        }
        System.out.println("Libro con id " + id + " no encontrado.");
    }
}

