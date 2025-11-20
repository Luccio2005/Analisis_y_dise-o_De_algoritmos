import javax.swing.*;
import java.awt.*;

public class PanelMapa extends JPanel {

    private final char[][] mapa;
    private final int TAM = 7;
    private Explorador explorador;

    public void setExplorador(Explorador e) {
        this.explorador = e;
    }

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
                    case '#': g.setColor(Color.darkGray); break;
                    case 'T': g.setColor(Color.yellow); break;
                    case 'E': g.setColor(Color.green); break;
                    case 'S': g.setColor(Color.red); break;
                    case 'V': g.setColor(new Color(150, 200, 255)); break; // visitado (celeste)
                    case '.': g.setColor(Color.lightGray); break; // retroceso
                    case 'X': g.setColor(Color.orange); break; // tesoro encontrado
                    default: g.setColor(Color.white); break;
                }

                g.fillRect(j * TAM, i * TAM, TAM, TAM);
            }
        }
        // Dibujar explorador
        if (explorador != null) {
            g.setColor(Color.blue);
            g.fillRect(explorador.getY() * TAM, explorador.getX() * TAM, TAM, TAM);
        }
    }
}
