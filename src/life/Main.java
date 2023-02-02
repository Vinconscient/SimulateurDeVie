package life;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String args[]){
        GameOfLife gol = new GameOfLife(92,51);
        System.out.println(gol);
        gol.trucDeBase(0);
        // System.out.println(gol.nbVoisin(3,3));
        int nbGen = 0;
        while(true){
            gol.prochaineGeneration();
            nbGen = nbGen + 1;
            // System.out.println("NEW WAVE n°"+nbGen);
            System.out.println(gol);
            try {
            Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }    
        }
        
    }
}
