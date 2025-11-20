import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Mapa mapa = new Mapa(100, 100, 30); // 30 tesoros

        JFrame ventana = new JFrame("Buscador de Tesoros - Mapa");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelMapa panel = new PanelMapa(mapa.getGrid());
        ventana.add(new JScrollPane(panel));

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        // obtener posición inicial
        int startX = 1;
        int startY = 1;

        Explorador exp = new Explorador(startX, startY, mapa.getGrid(), panel);
        panel.setExplorador(exp);

        // iniciar búsqueda en hilo aparte
        new Thread(() -> exp.iniciarBusqueda()).start();
    }
}
