import java.util.*;

public class Documento {
    private String nombre;
    private String contenido;
    private Map<String, Integer> frecuenciaPalabras;

    public Documento(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.frecuenciaPalabras = new HashMap<>();
        procesarContenido();
    }

    private void procesarContenido() {
        String[] palabras = contenido.toLowerCase().split("\\W+");
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public Map<String, Integer> getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }
}
