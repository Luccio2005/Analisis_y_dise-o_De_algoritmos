import java.io.*;
import java.util.*;

public class BusquedaSecuencialConIndice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rutaArchivo = System.getProperty("user.home") + "/Desktop/libros.txt";
        String rutaIndice = System.getProperty("user.home") + "/Desktop/indice_libros.txt";
        int tamanoBloque = 10;

        System.out.print("🔍 Ingresa el ID del libro que deseas buscar: ");
        int idBuscado = sc.nextInt();

        try {
            // --- 1️⃣ Leer índice ---
            List<Integer> idsIndice = new ArrayList<>();
            try (BufferedReader brIndice = new BufferedReader(new FileReader(rutaIndice))) {
                String linea;
                while ((linea = brIndice.readLine()) != null) {
                    idsIndice.add(Integer.parseInt(linea.split(",")[0]));
                }
            }

            // --- 2️⃣ Determinar el bloque ---
            int bloqueBuscar = -1;
            for (int i = 0; i < idsIndice.size(); i++) {
                if (idBuscado < idsIndice.get(i)) {
                    bloqueBuscar = i - 1;
                    break;
                }
            }
            if (bloqueBuscar == -1) bloqueBuscar = idsIndice.size() - 1;

            System.out.println("📦 Buscando en bloque " + bloqueBuscar);

            // --- 3️⃣ Leer solo ese bloque del archivo principal ---
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                int inicio = bloqueBuscar * tamanoBloque;
                int fin = inicio + tamanoBloque;

                int contador = 0;
                long tInicio = System.nanoTime();

                while ((linea = br.readLine()) != null) {
                    if (contador >= inicio && contador < fin) {
                        String[] partes = linea.split(",");
                        int id = Integer.parseInt(partes[0]);
                        String titulo = partes[1];
                        String autor = partes[2];

                        if (id == idBuscado) {
                            long tFin = System.nanoTime();
                            System.out.println("\n✅ Libro encontrado:");
                            System.out.println("ID: " + id);
                            System.out.println("Título: " + titulo);
                            System.out.println("Autor: " + autor);
                            System.out.println("⏱ Tiempo de búsqueda: " + (tFin - tInicio) / 1_000_000.0 + " ms");
                            sc.close();
                            return;
                        }
                    }
                    contador++;
                }

                System.out.println("\n❌ Libro con ID " + idBuscado + " no encontrado.");

            }

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        sc.close();
    }
}

