import java.io.*;
import java.util.*;

public class OrdenarLibrosPorID {
    public static void main(String[] args) {
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";

        try {
            // Leer todas las líneas del archivo
            List<String> lineas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }
            }

            // Ordenar las líneas por ID (la primera parte de cada línea)
            Collections.sort(lineas, (a, b) -> {
                int idA = Integer.parseInt(a.split(",")[0]);
                int idB = Integer.parseInt(b.split(",")[0]);
                return Integer.compare(idA, idB);
            });

            // Reescribir el archivo ordenado
            try (FileWriter fw = new FileWriter(rutaArchivo)) {
                for (String linea : lineas) {
                    fw.write(linea + "\n");
                }
            }

            System.out.println("✅ Archivo libros.txt ordenado correctamente por ID.");

        } catch (IOException e) {
            System.out.println("❌ Error al ordenar el archivo: " + e.getMessage());
        }
    }
}
