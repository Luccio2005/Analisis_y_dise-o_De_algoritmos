public class Explorador {

    private int x, y;
    private final char[][] mapa;
    private final PanelMapa panel;
    private boolean tesoroEncontrado = false;

    public Explorador(int x, int y, char[][] mapa, PanelMapa panel) {
        this.x = x;
        this.y = y;
        this.mapa = mapa;
        this.panel = panel;
    }

    public void iniciarBusqueda() {
        buscar(x, y);
    }

    private boolean buscar(int i, int j) {

        // salir si ya encontramos tesoro
        if (tesoroEncontrado) return true;

        // fuera del mapa
        if (i < 0 || i >= mapa.length || j < 0 || j >= mapa[0].length)
            return false;

        // muro o visitado
        if (mapa[i][j] == '#' || mapa[i][j] == 'V')
            return false;

        // si es tesoro → GANAMOS
        if (mapa[i][j] == 'T') {
            mapa[i][j] = 'X'; // marcar tesoro encontrado
            tesoroEncontrado = true;
            panel.repaint();
            return true;
        }

        // marcar como visitado
        if (mapa[i][j] != 'E')
            mapa[i][j] = 'V';  // visitado

        moverAnimado(i, j);

        // explorar en 4 direcciones
        if (buscar(i + 1, j)) return true;
        if (buscar(i - 1, j)) return true;
        if (buscar(i, j + 1)) return true;
        if (buscar(i, j - 1)) return true;

        // backtracking (retrocede)
        if (mapa[i][j] != 'E')
            mapa[i][j] = '.'; // camino descartado

        panel.repaint();
        return false;
    }

    private void moverAnimado(int i, int j) {
        this.x = i;
        this.y = j;

        try { Thread.sleep(10); } catch (Exception e) {}

        panel.repaint();
    }
    public int getX() { return x; }
    public int getY() { return y; }
}
