public class Main {
    public static void main(String[] args) {

        // =====================================
        // BÚSQUEDA LINEAL
        // =====================================
        Libro[] libros = {
                new Libro(1, "Clean Code", "Robert C. Martin"),
                new Libro(2, "El Quijote", "Cervantes"),
                new Libro(3, "Cien años de soledad", "García Márquez"),
                new Libro(4, "La Odisea", "Homero"),
                new Libro(5, "1984", "George Orwell")
        };

        System.out.println("=============================");
        System.out.println("BÚSQUEDA LINEAL");
        System.out.println("=============================");

        System.out.println("Buscando libro con ID = 3 (lineal)");
        Libro resultado1 = BusquedaLineal.buscarPorId(libros, 3);
        System.out.println(resultado1 != null ? resultado1 : "Libro no encontrado");

        System.out.println("\nBuscando libro con Título = '1984' (lineal)");
        Libro resultado2 = BusquedaLineal.buscarPorTitulo(libros, "1984");
        System.out.println(resultado2 != null ? resultado2 : "Libro no encontrado");

        // =====================================
        //  BÚSQUEDA BINARIA ITERATIVA
        // =====================================
        System.out.println("\n=============================");
        System.out.println("BÚSQUEDA BINARIA ITERATIVA");
        System.out.println("=============================");

        // La búsqueda binaria requiere que el arreglo esté ordenado.
        // Este arreglo ya está ordenado por ID, así que no necesitamos ordenar.

        System.out.println("\nBuscando libro con ID = 4 (binaria)");
        Libro encontradoBinariaId = BusquedaBinaria.buscarPorId(libros, 4);
        System.out.println(encontradoBinariaId != null ? encontradoBinariaId : "Libro no encontrado");

        System.out.println("\nBuscando libro con Título = 'Clean Code' (binaria)");
        Libro encontradoBinariaTitulo = BusquedaBinaria.buscarPorTitulo(libros, "Clean Code");
        System.out.println(encontradoBinariaTitulo != null ? encontradoBinariaTitulo : "Libro no encontrado");
    }
}

