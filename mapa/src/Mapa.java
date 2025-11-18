import java.util.Random;

public class Mapa {

    private final int FILAS;
    private final int COLUMNAS;
    private final char[][] grid;
    private final Random rand = new Random();

    public Mapa(int filas, int columnas, int cantidadTesoros) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
        this.grid = new char[FILAS][COLUMNAS];

        generarTerreno();
        colocarTesoros(cantidadTesoros);
        colocarEntradaSalida();
    }

    private void generarTerreno() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                if (rand.nextDouble() < 0.20) {
                    grid[i][j] = '#';  // obstáculo
                } else {
                    grid[i][j] = ' ';  // camino
                }
            }
        }
    }

    private void colocarTesoros(int cantidad) {
        int puestos = 0;

        while (puestos < cantidad) {
            int x = rand.nextInt(FILAS);
            int y = rand.nextInt(COLUMNAS);

            if (grid[x][y] == ' ') {
                grid[x][y] = 'T';
                puestos++;
            }
        }
    }

    private void colocarEntradaSalida() {
        grid[1][1] = 'E';  // entrada del explorador
        grid[FILAS - 2][COLUMNAS - 2] = 'S';  // salida o meta
    }

    public char[][] getGrid() {
        return grid;
    }
}
