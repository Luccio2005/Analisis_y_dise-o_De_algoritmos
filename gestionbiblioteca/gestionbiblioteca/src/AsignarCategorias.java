import java.io.*;
import java.util.*;

public class AsignarCategorias {
    public static void main(String[] args) {
        String inputFile = System.getProperty("user.home") + "/Desktop/libros.txt";;
        String outputFile = System.getProperty("user.home") + "/Desktop/libros_con_categorias.txt";

        // 10 categorías predefinidas
        String[] categorias = {
                "Ciencia", "Historia", "Fantasía", "Romance", "Tecnología",
                "Arte", "Filosofía", "Infantil", "Terror", "Deportes"
        };

        Random random = new Random();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String categoria = categorias[random.nextInt(categorias.length)];
                pw.println(linea + "," + categoria);
            }

            System.out.println("✅ Categorías asignadas correctamente a cada libro.");
            System.out.println("Nuevo archivo generado: " + outputFile);

        } catch (IOException e) {
            System.out.println("❌ Error al procesar el archivo: " + e.getMessage());
        }
    }
}

