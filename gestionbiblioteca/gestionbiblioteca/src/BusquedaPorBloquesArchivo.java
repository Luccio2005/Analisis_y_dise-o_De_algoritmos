import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusquedaPorBloquesArchivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ruta del archivo
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";

        System.out.print("🔍 Ingresa el ID del libro que deseas buscar: ");
        int idBuscado = sc.nextInt();

        int tamanoBloque = 10; // puedes ajustar este valor (10 libros por bloque)
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            List<String> bloque = new ArrayList<>();

            long inicio = System.nanoTime();

            while ((linea = br.readLine()) != null) {
                bloque.add(linea);

                // Cuando se llena el bloque, se procesa
                if (bloque.size() == tamanoBloque) {
                    encontrado = buscarEnBloque(bloque, idBuscado);
                    if (encontrado) break;
                    bloque.clear();
                }
            }

            // Procesar el último bloque (si quedó incompleto)
            if (!encontrado && !bloque.isEmpty()) {
                encontrado = buscarEnBloque(bloque, idBuscado);
            }

            long fin = System.nanoTime();
            double tiempo = (fin - inicio) / 1_000_000.0;

            if (!encontrado) {
                System.out.println("\n❌ Libro con ID " + idBuscado + " no encontrado.");
            }

            System.out.println("\nTiempo total de búsqueda: " + tiempo + " ms");

        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }

        sc.close();
    }

    private static boolean buscarEnBloque(List<String> bloque, int idBuscado) {
        // Convertir cada línea del bloque en un libro
        for (String linea : bloque) {
            String[] partes = linea.split(",");
            int id = Integer.parseInt(partes[0]);
            String titulo = partes[1];
            String autor = partes[2];

            if (id == idBuscado) {
                System.out.println("\n✅ Libro encontrado en bloque:");
                System.out.println("ID: " + id);
                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
                return true;
            }
        }
        return false;
    }
}
