import javax.swing.*;
import java.awt.*;

public class PanelMapa extends JPanel {

    private final char[][] mapa;
    private final int TAM = 7;

    public PanelMapa(char[][] mapa) {
        this.mapa = mapa;
        setPreferredSize(new Dimension(mapa[0].length * TAM, mapa.length * TAM));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {

                char c = mapa[i][j];

                switch (c) {
                    case '#': g.setColor(Color.darkGray); break;   // obstáculo
                    case 'T': g.setColor(Color.yellow); break;      // tesoro
                    case 'E': g.setColor(Color.green); break;       // entrada
                    case 'S': g.setColor(Color.red); break;         // salida
                    default: g.setColor(Color.white); break;        // camino
                }

                g.fillRect(j * TAM, i * TAM, TAM, TAM);
            }
        }
    }
}
