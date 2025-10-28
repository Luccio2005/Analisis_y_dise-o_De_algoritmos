public class Main {
    public static void main(String[] args) {

        Libro[] libros = {
                new Libro(1, "Clean Code", "Robert C. Martin"),
                new Libro(2, "El Quijote", "Cervantes"),
                new Libro(3, "Cien años de soledad", "García Márquez"),
                new Libro(4, "La Odisea", "Homero"),
                new Libro(5, "1984", "George Orwell")
        };

        System.out.println(" Buscando libro con ID = 3");
        Libro resultado1 = BusquedaLineal.buscarPorId(libros, 3);
        System.out.println(resultado1 != null ? resultado1 : "Libro no encontrado");

        System.out.println("\n Buscando libro con Título = '1984'");
        Libro resultado2 = BusquedaLineal.buscarPorTitulo(libros, "1984");
        System.out.println(resultado2 != null ? resultado2 : "Libro no encontrado");
    }
}
