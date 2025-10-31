import java.util.Random;

public class GeneradorLibros {
    public static Libro[] generarLibros(int cantidad) {
        Libro[] libros = new Libro[cantidad];
        Random rand = new Random();

        for (int i = 0; i < cantidad; i++) {
            int id = i + 1;
            String titulo = "Libro " + id;
            String autor = "Autor " + (rand.nextInt(1000) + 1);
            libros[i] = new Libro(id, titulo, autor);
        }
        return libros;
    }
}

