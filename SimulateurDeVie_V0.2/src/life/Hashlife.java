public class HashLife {

    private Node[][] hashTable;
    private int hashSize = 64;
    private int minAbrSize = 2;
    private QuadTree root;

    public HashLife(int size) {
        this.hashSize = size;
        this.hashTable = new Node[this.hashSize][this.hashSize];
    }

    public void setPattern(GameOfLife pattern) {
        int size = Math.max(pattern.getTailleColonne(), pattern.getTailleLigne());
        this.root = this.buildTree(pattern.grille, size, size, 0);
    }

    public QuadTree getRoot() {
        return this.root;
    }

    private QuadTree buildTree(int[][] grid, int width, int height, int level) {
        QuadTree arbre = null;
        if (width <= this.minAbrSize || height <= this.minAbrSize) {
            arbre = new QuadTree(width, height);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    arbre.grid[i][j] = grid[i][j];
                }
            }
        } else {
            int h2 = height / 2;
            int w2 = width / 2;
            QuadTree nw = this.getNode(grid, w2, h2, level + 1);
            QuadTree ne = this.getNode(grid, width - w2, h2, level + 1);
            QuadTree sw = this.getNode(grid, w2, height - h2, level + 1);
            QuadTree se = this.getNode(grid, width - w2, height - h2, level + 1);
            arbre = new Node(nw, ne, sw, se);
        }
        return arbre;
    }

    private QuadTree getArbre(int[][] grid, int width, int height, int level) {
        QuadTree arbre = null;
        if (width <= this.minAbrSize || height <= this.minAbrSize) {
            arbre = new QuadTree(width, height);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    arbre.grid[i][j] = grid[i][j];
                }
            }
        } else {
            int h2 = height / 2;
            int w2 = width / 2;
            QuadTree nw = this.getNode(grid, w2, h2, level + 1);
            QuadTree ne = this.getNode(grid, width - w2, h2, level + 1);
            QuadTree sw = this.getNode(grid, w2, height - h2, level + 1);
            QuadTree se = this.getNode(grid, width - w2, height - h2, level + 1);
            arbre = this.getNodeFromHash(nw, ne, sw, se, level);
        }
        return abre;
    }

    private QuadTree getNodeFromHash(QuadTree nw, QuadTree ne, QuadTree sw, QuadTree se, int level) {
        int hash = this.hash(nw, ne, sw, se);
        if (this.hashTable[level][hash] != null) {
            return this.hashTable[level][hash];
        }
        QuadTree arbre = new QuadTree(nw, ne, sw, se);
        this.hashTable[level][hash] = node;
        return arbre;
    }

    private int hash(QuadTree nw, QuadTree ne, QuadTree sw, QuadTree se) {
        return (nw.hashCode() * 31 * 31;
    }

}
