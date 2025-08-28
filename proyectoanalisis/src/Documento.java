import java.util.HashMap;
import java.util.Map;

public class Documento {
    private final String nombre;
    private final String contenido;
    private final Map<String, Integer> frecuenciaPalabras = new HashMap<>();

    public Documento(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
        procesarContenido();
    }

    private void procesarContenido() {
        // \\P{L}+ separa por todo lo que NO es letra (soporta tildes)
        String[] tokens = contenido.toLowerCase().split("\\P{L}+");
        for (String t : tokens) {
            if (!t.isEmpty()) {
                Integer c = frecuenciaPalabras.get(t);
                frecuenciaPalabras.put(t, (c == null) ? 1 : c + 1);
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

