package life;

public class Main{
    public static void main(String args[]){
        //GameOfLife gol = new GameOfLife(92,51);
        GameOfLife gol = new GameOfLife(500,500);
        //GameOfLife gol = new GameOfLife(10, 10);
        System.out.println(gol);
        gol.trucDeBase(0);
        // System.out.println(gol.nbVoisin(3,3));
        int nbGen = 0;
        while(nbGen < 25){
            gol.prochaineGeneration();
            nbGen = nbGen + 1;
            // System.out.println("NEW WAVE n°"+nbGen);
            System.out.println(gol);
            // try {
            // Thread.sleep(1);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }    
        }
        System.out.print("FINI");
    }
}
