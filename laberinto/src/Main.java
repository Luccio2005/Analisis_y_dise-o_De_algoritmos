import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeneradorLaberinto gen = new GeneradorLaberinto(100, 100);
            PanelLaberinto panel = new PanelLaberinto(gen.getLaberinto());

            JFrame ventana = new JFrame("Laberinto con Backtracking");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.add(panel);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

            // Iniciar búsqueda en otro hilo
            new Thread(() -> {
                ResolucionLaberinto solver = new ResolucionLaberinto(gen.getLaberinto(), panel);
                solver.resolver(1, 1); // desde el inicio
            }).start();
        });
    }
}
