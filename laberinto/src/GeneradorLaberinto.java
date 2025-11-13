
import java.util.Random;

public class GeneradorLaberinto {

    private final int FILAS;
    private final int COLUMNAS;
    private final char[][] laberinto;
    private final Random rand = new Random();

    public GeneradorLaberinto(int filas, int columnas) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
        this.laberinto = new char[FILAS][COLUMNAS];
        inicializarLaberinto();
        generarLaberinto(1, 1);
        colocarInicioYSalida();
        laberinto[1][1] = 'S'; // inicio
        laberinto[FILAS - 2][COLUMNAS - 2] = 'E'; // salida
    }

    private void inicializarLaberinto() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                laberinto[i][j] = '#'; // todo muro al inicio
            }
        }
    }

    private void generarLaberinto(int x, int y) {
        // Marca la celda actual como camino
        laberinto[x][y] = ' ';

        // Direcciones posibles: arriba, abajo, izquierda, derecha
        int[][] direcciones = {
                {-2, 0}, {2, 0}, {0, -2}, {0, 2}
        };
        mezclarDirecciones(direcciones);

        // Intenta excavar en cada dirección
        for (int[] dir : direcciones) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (esValido(nx, ny)) {
                if (laberinto[nx][ny] == '#') {
                    // Excava pared intermedia
                    laberinto[x + dir[0] / 2][y + dir[1] / 2] = ' ';
                    generarLaberinto(nx, ny);
                }
            }
        }
    }

    private boolean esValido(int x, int y) {
        return x > 0 && x < FILAS - 1 && y > 0 && y < COLUMNAS - 1;
    }

    private void mezclarDirecciones(int[][] dirs) {
        for (int i = dirs.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int[] temp = dirs[i];
            dirs[i] = dirs[j];
            dirs[j] = temp;
        }
    }
    private void colocarInicioYSalida() {
        laberinto[1][1] = 'S';
        // Buscar una celda libre cercana al borde derecho
        for (int i = FILAS - 2; i > 1; i--) {
            if (laberinto[i][COLUMNAS - 3] == ' ') {
                laberinto[i][COLUMNAS - 2] = 'E';
                return;
            }
        }
        // Si no encuentra, coloca salida de emergencia abajo
        laberinto[FILAS - 2][COLUMNAS - 2] = 'E';
    }


    public void imprimirLaberinto() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                char c = laberinto[i][j];
                switch (c) {
                    case '#':
                        System.out.print("🧱"); // muro
                        break;
                    case 'S':
                        System.out.print("🟢"); // inicio
                        break;
                    case 'E':
                        System.out.print("🏁"); // salida
                        break;
                    default:
                        System.out.print("  "); // camino
                        break;
                }
            }
            System.out.println();
        }
    }

    public char[][] getLaberinto() {
        return laberinto;
    }
}
