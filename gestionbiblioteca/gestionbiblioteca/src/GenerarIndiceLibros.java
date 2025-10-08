import java.io.*;
import java.util.*;

public class GenerarIndiceLibros {
    public static void main(String[] args) {
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";
        String rutaIndice = System.getProperty("user.home") + "/Desktop/indice_libros.txt";

        int tamanoBloque = 10; // cada bloque tiene 10 libros

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             FileWriter fw = new FileWriter(rutaIndice)) {

            String linea;
            int contador = 0;
            int bloque = 0;
            int primerID = -1;

            while ((linea = br.readLine()) != null) {
                if (contador % tamanoBloque == 0) {
                    primerID = Integer.parseInt(linea.split(",")[0]);
                    fw.write(primerID + "," + bloque + "\n");
                    bloque++;
                }
                contador++;
            }

            System.out.println("✅ Índice generado correctamente en:\n" + rutaIndice);

        } catch (IOException e) {
            System.out.println("❌ Error al generar índice: " + e.getMessage());
        }
    }
}
