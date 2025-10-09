import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarLibros {

    public static void main(String[] args) {
        try {
            // Muestra la ruta actual del programa
            String rutaCarpeta = System.getProperty("user.dir");
            System.out.println("📂 Ruta actual del programa: " + rutaCarpeta);

            // Crea archivo directamente en el escritorio (más seguro)
            String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";

            Random random = new Random();
            File archivo = new File(rutaArchivo);

            try (FileWriter writer = new FileWriter(archivo)) {
                for (int i = 0; i < 1000; i++) {
                    int id = random.nextInt(1000) + 1;
                    String titulo = "Libro" + id;
                    String autor = "Autor" + id;
                    writer.write(id + "," + titulo + "," + autor + "\n");
                }
                System.out.println("✅ Archivo generado correctamente en:\n" + archivo.getAbsolutePath());
            }

        } catch (IOException e) {
            System.out.println("❌ Error al generar el archivo: " + e.getMessage());
        }
    }
}



