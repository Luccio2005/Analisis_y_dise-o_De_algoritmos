public class Libro {
    // Atributos
    private int id;
    private String titulo;
    private String autor;
    // Constructor
    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }
    // Getters y Setters
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    // Método toString para imprimir fácil
    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + '}';
    }
}


