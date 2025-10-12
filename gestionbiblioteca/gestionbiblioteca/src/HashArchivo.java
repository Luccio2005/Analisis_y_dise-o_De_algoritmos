import java.io.IOException;
import java.io.RandomAccessFile;

public class HashArchivo {
    private static final int CAPACIDAD = 100; // tamaño fijo del archivo hash
    private static final String RUTA_ARCHIVO = System.getProperty("user.home") + "/Desktop/hash_libros.dat";

    // Función hash (transforma clave en posición)
    private static int funcionHash(int id) {
        return id % CAPACIDAD;
    }

    public static void escribirLibro(Libro libro) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA_ARCHIVO, "rw")) {
            int posicion = funcionHash(libro.getId());
            long offset = posicion * 100; // cada registro ocupa 100 bytes
            raf.seek(offset);

            // Formato fijo: id(4 bytes), titulo(40 bytes), autor(40 bytes)
            raf.writeInt(libro.getId());
            raf.writeUTF(libro.getTitulo());
            raf.writeUTF(libro.getAutor());

            System.out.println("✅ Libro guardado en posición " + posicion);

        } catch (IOException e) {
            System.out.println("❌ Error al escribir libro: " + e.getMessage());
        }
    }

    public static void buscarLibro(int id) {
        try (RandomAccessFile raf = new RandomAccessFile(RUTA_ARCHIVO, "r")) {
            int posicion = funcionHash(id);
            long offset = posicion * 100;
            raf.seek(offset);

            int idLeido = raf.readInt();
            String titulo = raf.readUTF();
            String autor = raf.readUTF();

            if (idLeido == id) {
                System.out.println("✅ Libro encontrado:");
                System.out.println("ID: " + idLeido);
                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
            } else {
                System.out.println("❌ No coincide el ID en esa posición.");
            }

        } catch (IOException e) {
            System.out.println("❌ Error al buscar libro: " + e.getMessage());
        }
    }
}
