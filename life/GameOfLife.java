package life;

public class GameOfLife {

    private int[][] grille;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grille = new int[rows][cols];
    }

    public void setCellule(int x, int y) {
        grille[x][y] = 1;
    }

    public void nextGeneration() {
        int[][] newgrille = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = nbVoisins(i, j);
                if (grille[i][j] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        newgrille[i][j] = 0;
                    } else {
                        newgrille[i][j] = 1;
                    }
                } else {
                    if (neighbors == 3) {
                        newgrille[i][j] = 1;
                    }
                }
            }
        }

        grille = newgrille;
    }

    protected int nbVoisins(int x, int y) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int row = (x + i + rows) % rows;
                int col = (y + j + cols) % cols;
                count += grille[row][col];
            }
        }

        return count;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }
}