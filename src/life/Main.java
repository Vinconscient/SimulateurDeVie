package life;


public class Main {
    public static void main(String args[]) {
        GameOfLife game = new GameOfLife(5, 5);
        game.setCellule(2, 3);
        game.setCellule(3, 3);
        game.setCellule(3, 2);
        game.setCellule(1, 2);
        game.setCellule(3, 1);

        game.print();
        System.out.println("\n Next gen");
        System.out.println(game.nbVoisins(1,1) + " " + game.nbVoisins(1,2) + " " + game.nbVoisins(1,3));
        game.nextGeneration();
        game.print();
        System.out.println("\n Next gen");
        System.out.println(game.nbVoisins(1,1) + " " + game.nbVoisins(1,2) + " " + game.nbVoisins(1,3));
        game.nextGeneration();
        game.print();System.out.println("\n Next gen");
        System.out.println(game.nbVoisins(1,1) + " " + game.nbVoisins(1,2) + " " + game.nbVoisins(1,3));
        game.nextGeneration();
        game.print();
        System.out.println("\n Next gen");
        System.out.println(game.nbVoisins(1,1) + " " + game.nbVoisins(1,2) + " " + game.nbVoisins(1,3));
        game.nextGeneration();
        game.print();

    }
}
