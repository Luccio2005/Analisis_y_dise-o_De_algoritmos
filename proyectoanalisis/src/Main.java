import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Indice indice = new Indice();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MINI MOTOR DE BUSQUEDA ===");
            System.out.println("1. Agregar documento");
            System.out.println("2. Listar documentos");
            System.out.println("3. Ver contenido de un documento");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del documento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese contenido del documento: ");
                    String contenido = sc.nextLine();
                    Documento doc = new Documento(nombre, contenido);
                    indice.agregarDocumento(doc);
                    System.out.println("Documento agregado con éxito.");
                    break;

                case 2:
                    System.out.println("Documentos en el índice:");
                    for (Documento d : indice.getDocumentos()) {
                        System.out.println("- " + d.getNombre());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese nombre del documento: ");
                    String nombreDoc = sc.nextLine();
                    Documento encontrado = indice.buscarDocumento(nombreDoc);
                    if (encontrado != null) {
                        System.out.println("Contenido: " + encontrado.getContenido());
                        System.out.println("Frecuencia de palabras: " + encontrado.getFrecuenciaPalabras());
                    } else {
                        System.out.println("Documento no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}