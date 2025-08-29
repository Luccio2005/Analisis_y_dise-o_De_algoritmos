import java.util.HashMap;
import java.util.Map;

public class Documento {
    private final String nombre;
    private final String contenido;
    private final Map<String, Integer> frecuenciaPalabras = new HashMap<>();

    // NUEVOS ATRIBUTOS (métricas)
    private final int cantidadPalabras;
    private final int cantidadCaracteres;
    private final int cantidadLineas;

    public Documento(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
        procesarContenido();
        this.cantidadPalabras = contarPalabras();
        this.cantidadCaracteres = contarCaracteres();
        this.cantidadLineas = contarLineas();
    }

    private void procesarContenido() {
        // \\P{L}+ separa por todo lo que NO es letra (soporta tildes y acentos)
        String[] tokens = contenido.toLowerCase().split("\\P{L}+");
        for (String t : tokens) {
            if (!t.isEmpty()) {
                Integer c = frecuenciaPalabras.get(t);
                frecuenciaPalabras.put(t, (c == null) ? 1 : c + 1);
            }
        }
    }

    // ==== MÉTRICAS ====
    private int contarPalabras() {
        if (contenido == null || contenido.isEmpty()) return 0;
        String[] palabras = contenido.split("\\s+");
        return palabras.length;
    }

    private int contarCaracteres() {
        if (contenido == null) return 0;
        return contenido.length();
    }

    private int contarLineas() {
        if (contenido == null || contenido.isEmpty()) return 0;
        String[] lineas = contenido.split("\\r?\\n");
        return lineas.length;
    }

    // ==== GETTERS ====
    public String getNombre() { return nombre; }
    public String getContenido() { return contenido; }
    public Map<String, Integer> getFrecuenciaPalabras() { return frecuenciaPalabras; }

    public int getCantidadPalabras() { return cantidadPalabras; }
    public int getCantidadCaracteres() { return cantidadCaracteres; }
    public int getCantidadLineas() { return cantidadLineas; }

    @Override
    public String toString() {
        return "Documento: " + nombre +
                " | Palabras: " + cantidadPalabras +
                " | Caracteres: " + cantidadCaracteres +
                " | Líneas: " + cantidadLineas;
    }
}

