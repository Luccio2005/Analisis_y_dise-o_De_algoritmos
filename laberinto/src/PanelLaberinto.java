import javax.swing.*;
import java.awt.*;

public class PanelLaberinto extends JPanel {

    private final char[][] laberinto;
    private final int TAM_CELDA = 6; // tamaño de cada celda en píxeles

    public PanelLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;
        int filas = laberinto.length;
        int columnas = laberinto[0].length;
        setPreferredSize(new Dimension(columnas * TAM_CELDA, filas * TAM_CELDA));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                char c = laberinto[i][j];
                switch (c) {
                    case '#': // muro
                        g.setColor(Color.DARK_GRAY);
                        break;
                    case 'S': // inicio
                        g.setColor(Color.GREEN);
                        break;
                    case 'E': // salida
                        g.setColor(Color.RED);
                        break;
                    case '.': g.setColor(Color.CYAN);
                        break;
                    default: // camino
                        g.setColor(Color.WHITE);
                        break;
                }
                g.fillRect(j * TAM_CELDA, i * TAM_CELDA, TAM_CELDA, TAM_CELDA);
            }
        }
    }
}
