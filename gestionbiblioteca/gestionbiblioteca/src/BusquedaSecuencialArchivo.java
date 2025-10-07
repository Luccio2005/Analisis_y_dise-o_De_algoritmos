import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BusquedaSecuencialArchivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ruta del archivo (usa el del escritorio)
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";

        System.out.print("🔍 Ingresa el ID del libro que deseas buscar: ");
        int idBuscado = sc.nextInt();

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            long inicio = System.nanoTime(); // medir tiempo
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String autor = partes[2];

                if (id == idBuscado) {
                    long fin = System.nanoTime();
                    double tiempo = (fin - inicio) / 1_000_000.0;
                    System.out.println("\n✅ Libro encontrado:");
                    System.out.println("ID: " + id);
                    System.out.println("Título: " + titulo);
                    System.out.println("Autor: " + autor);
                    System.out.println("Tiempo de búsqueda: " + tiempo + " ms");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\n❌ Libro con ID " + idBuscado + " no encontrado.");
            }

        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }

        sc.close();
    }
}

