import java.util.LinkedList;

public class TablaHashEncadenada {
    private LinkedList<Libro>[] tabla;
    private int capacidad;
    private int colisiones = 0;

    @SuppressWarnings("unchecked")
    public TablaHashEncadenada(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int funcionHash(int id) {
        return id % capacidad;
    }

    public void insertar(Libro libro) {
        int indice = funcionHash(libro.getId());
        if (!tabla[indice].isEmpty()){
            colisiones++;
        }
        tabla[indice].add(libro);
    }

    public Libro buscarPorId(int id) {
        int indice = funcionHash(id);
        for (Libro libro : tabla[indice]) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarTabla() {
        for (int i = 0; i < capacidad; i++) {
            System.out.println("Posición " + i + ": " + (tabla[i].isEmpty() ? "[vacío]" : tabla[i]));
        }
    }
    public void eliminar(int id) {
        int indice = funcionHash(id);
        for (Libro libro : tabla[indice]) {
            if (libro.getId() == id) {
                System.out.println("Eliminando: " + libro);
                tabla[indice].remove(libro);
                return;
            }
        }
        System.out.println("Libro con id " + id + " no encontrado.");
    }
    public int getColisiones() {
        return colisiones;
    }
}