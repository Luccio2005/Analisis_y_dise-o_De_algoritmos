public class Main {
    public static void main(String[] args) {

        // ================================
        // 🔹 Generar 10,000 libros
        // ================================
        Libro[] libros = GeneradorLibros.generarLibros(10_000);
        System.out.println("Se generaron " + libros.length + " libros.\n");

        int idBuscado = 9876; // valor aleatorio dentro del rango
        String tituloBuscado = "Libro 9876";

        // ================================
        // 🔹 Búsqueda lineal
        // ================================
        long inicio = System.nanoTime();
        Libro resultado1 = BusquedaLineal.buscarPorId(libros, idBuscado);
        long fin = System.nanoTime();
        System.out.println("🔍 Búsqueda lineal por ID tomó: " + (fin - inicio) + " ns");

        // ================================
        // 🔹 Búsqueda binaria iterativa
        // ================================
        inicio = System.nanoTime();
        Libro resultado2 = BusquedaBinaria.buscarPorId(libros, idBuscado);
        fin = System.nanoTime();
        System.out.println("⚙️  Búsqueda binaria iterativa tomó: " + (fin - inicio) + " ns");

        // ================================
        // 🔹 Búsqueda binaria recursiva
        // ================================
        inicio = System.nanoTime();
        Libro resultado3 = BusquedaBinariaRecursiva.buscarPorId(libros, idBuscado, 0, libros.length - 1);
        fin = System.nanoTime();
        System.out.println("🧠 Búsqueda binaria recursiva tomó: " + (fin - inicio) + " ns");

        System.out.println("\nResultado encontrado: " + resultado3);
    }
}


