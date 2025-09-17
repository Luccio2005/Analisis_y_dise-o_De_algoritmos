public class Main {
    public static void main(String[] args) {
        // Crear algunos libros de prueba
        Libro libro1 = new Libro(1, "El Quijote", "Miguel de Cervantes");
        Libro libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez");
        Libro libro3 = new Libro(3, "Clean Code", "Robert C. Martin");

        // Imprimir los libros
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
    }
}