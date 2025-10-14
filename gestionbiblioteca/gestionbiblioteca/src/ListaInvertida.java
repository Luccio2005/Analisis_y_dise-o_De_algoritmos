import java.io.*;
import java.util.*;

public class ListaInvertida {

    public static void main(String[] args) {
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";
        String rutaIndiceInvertido = System.getProperty("user.home") + "/Desktop/indice_invertido.txt";

        Map<String, List<Integer>> indiceInvertido = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String autor = partes[2];

                // 🔹 Dividir palabras clave (por título y autor)
                agregarPalabras(indiceInvertido, titulo, id);
                agregarPalabras(indiceInvertido, autor, id);
            }

            // 🔹 Guardar el índice invertido en un archivo
            try (FileWriter fw = new FileWriter(rutaIndiceInvertido)) {
                for (Map.Entry<String, List<Integer>> entrada : indiceInvertido.entrySet()) {
                    fw.write(entrada.getKey() + " -> " + entrada.getValue() + "\n");
                }
            }

            System.out.println("✅ Índice invertido generado correctamente en:");
            System.out.println(rutaIndiceInvertido);

            // 🔹 Permitir búsqueda de palabra clave
            Scanner sc = new Scanner(System.in);
            System.out.print("\n🔍 Ingresa una palabra clave para buscar libros: ");
            String palabra = sc.nextLine().toLowerCase();

            if (indiceInvertido.containsKey(palabra)) {
                System.out.println("\n📚 Libros con la palabra '" + palabra + "': " + indiceInvertido.get(palabra));
            } else {
                System.out.println("\n❌ No se encontraron libros con esa palabra clave.");
            }

            sc.close();

        } catch (IOException e) {
            System.out.println("❌ Error al generar índice invertido: " + e.getMessage());
        }
    }

    private static void agregarPalabras(Map<String, List<Integer>> indice, String texto, int idLibro) {
        // Divide el texto en palabras eliminando caracteres especiales
        String[] palabras = texto.toLowerCase().split("[^a-zA-Z0-9áéíóúñ]+");
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                indice.computeIfAbsent(palabra, k -> new ArrayList<>()).add(idLibro);
            }
        }
    }
}
