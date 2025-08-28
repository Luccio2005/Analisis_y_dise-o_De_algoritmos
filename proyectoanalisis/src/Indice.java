import java.util.*;

public class Indice {
    private List<Documento> documentos;

    public Indice() {
        this.documentos = new ArrayList<>();
    }

    public void agregarDocumento(Documento doc) {
        documentos.add(doc);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public Documento buscarDocumento(String nombre) {
        for (Documento doc : documentos) {
            if (doc.getNombre().equalsIgnoreCase(nombre)) {
                return doc;
            }
        }
        return null;
    }
}