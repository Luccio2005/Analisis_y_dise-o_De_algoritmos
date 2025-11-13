public class ResolucionLaberinto {

    private final char[][] laberinto;
    private final PanelLaberinto panel;
    private final int filas, columnas;
    private boolean encontrado = false;

    public ResolucionLaberinto(char[][] laberinto, PanelLaberinto panel) {
        this.laberinto = laberinto;
        this.panel = panel;
        this.filas = laberinto.length;
        this.columnas = laberinto[0].length;
    }

    public void resolver(int x, int y) {
        if (encontrado) return;

        // Si llegamos a la salida
        if (laberinto[x][y] == 'E') {
            encontrado = true;
            panel.repaint();
            return;
        }

        // Marcar el paso actual
        if (laberinto[x][y] == ' ') {
            laberinto[x][y] = '.'; // camino explorado
            panel.repaint();
            dormir(10); // pequeña pausa para visualización
        }

        // Direcciones: abajo, derecha, arriba, izquierda
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] d : dirs) {
            if(encontrado) return;
            int nx = x + d[0];
            int ny = y + d[1];
            if (esValido(nx, ny)) {
                resolver(nx, ny);
            }
        }

        // Retroceso
        if (!encontrado && laberinto[x][y] == '.') {
            laberinto[x][y] = ' ';
            panel.repaint();
            dormir(10);
        }
    }

    private boolean esValido(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas &&
                (laberinto[x][y] == ' ' || laberinto[x][y] == 'E');
    }

    private void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
