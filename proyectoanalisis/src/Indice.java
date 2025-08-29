import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Indice {
    private final List<Documento> documentos = new ArrayList<>();

    public void agregarDocumento(Documento doc) {
        documentos.add(doc);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public Documento buscarDocumento(String nombre) {
        for (Documento d : documentos) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        return null;
    }

    // Carga todos los .txt de la carpeta usando Files.readAllLines (Java 8)
    public void cargarDesdeCarpeta(String rutaCarpeta) {
        Path carpeta = Paths.get(rutaCarpeta);

        if (!Files.exists(carpeta) || !Files.isDirectory(carpeta)) {
            System.err.println("Carpeta no válida: " + rutaCarpeta);
            return;
        }

        int cargados = 0;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(carpeta, "*.txt")) {
            for (Path archivo : stream) {
                try {
                    List<String> lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
                    String contenido = String.join(System.lineSeparator(), lineas);
                    Documento doc = new Documento(archivo.getFileName().toString(), contenido);
                    agregarDocumento(doc);
                    System.out.println("Cargado: " + archivo.getFileName());
                    cargados++;
                } catch (IOException e) {
                    System.err.println("No se pudo leer: " + archivo.getFileName() + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al acceder a la carpeta: " + e.getMessage());
        }

        if (cargados == 0) {
            System.out.println("No se encontraron archivos .txt en: " + rutaCarpeta);
        }
    }
    public void mostrarMetricas() {
        System.out.println("\n=== Métricas de Documentos ===");
        if (documentos.isEmpty()) {
            System.out.println("(sin documentos)");
        } else {
            for (Documento doc : documentos) {
                System.out.println(doc.toString());
            }
        }
    }
}


