import java.io.*;
import java.util.*;

public class ListaInvertida {

    public static void main(String[] args) {
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";
        String rutaIndiceInvertido = System.getProperty("user.home") + "/Desktop/indice_invertido.txt";

        Map<String, List<Integer>> indiceInvertido = new HashMap<>();
        Map<String, List<Integer>> indiceAutores = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String autor = partes[2];

                // 🔹 Palabras clave del título
                agregarPalabras(indiceInvertido, titulo, id);

                // 🔹 Guardar autores completos (para búsqueda por nombre)
                String autorClave = autor.toLowerCase();
                indiceAutores.computeIfAbsent(autorClave, k -> new ArrayList<>()).add(id);
            }

            // 🔹 Guardar los índices en archivos
            try (FileWriter fw = new FileWriter(rutaIndiceInvertido)) {
                fw.write("=== ÍNDICE POR PALABRAS CLAVE ===\n");
                for (Map.Entry<String, List<Integer>> entrada : indiceInvertido.entrySet()) {
                    fw.write(entrada.getKey() + " -> " + entrada.getValue() + "\n");
                }

                fw.write("\n=== ÍNDICE POR AUTORES ===\n");
                for (Map.Entry<String, List<Integer>> entrada : indiceAutores.entrySet()) {
                    fw.write(entrada.getKey() + " -> " + entrada.getValue() + "\n");
                }
            }

            System.out.println("✅ Índices generados correctamente en:");
            System.out.println(rutaIndiceInvertido);

            // 🔹 Menú de búsqueda
            Scanner sc = new Scanner(System.in);
            System.out.println("\n🔍 Tipo de búsqueda:");
            System.out.println("1) Por palabra clave (título)");
            System.out.println("2) Por autor");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.print("👉 Ingresa una palabra clave: ");
                String palabra = sc.nextLine().toLowerCase();

                if (indiceInvertido.containsKey(palabra)) {
                    System.out.println("\n📚 Libros con la palabra '" + palabra + "': " + indiceInvertido.get(palabra));
                } else {
                    System.out.println("\n❌ No se encontraron libros con esa palabra clave.");
                }

            } else if (opcion == 2) {
                System.out.print("👉 Ingresa el nombre o parte del autor: ");
                String autorBuscado = sc.nextLine().toLowerCase();

                boolean encontrado = false;
                for (Map.Entry<String, List<Integer>> entrada : indiceAutores.entrySet()) {
                    if (entrada.getKey().contains(autorBuscado)) {
                        System.out.println("\n👤 Autor: " + entrada.getKey());
                        System.out.println("📚 Libros: " + entrada.getValue());
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("\n❌ No se encontraron autores que coincidan con '" + autorBuscado + "'");
                }

            } else {
                System.out.println("❌ Opción no válida.");
            }

            sc.close();

        } catch (IOException e) {
            System.out.println("❌ Error al generar índice invertido: " + e.getMessage());
        }
    }

    private static void agregarPalabras(Map<String, List<Integer>> indice, String texto, int idLibro) {
        String[] palabras = texto.toLowerCase().split("[^a-zA-Z0-9áéíóúñ]+");
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                indice.computeIfAbsent(palabra, k -> new ArrayList<>()).add(idLibro);
            }
        }
    }
}

