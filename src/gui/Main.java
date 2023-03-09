package gui;
import javax.swing.*;
import life.GameOfLife;
public class Main{
    public static void main(String args[]){
        GameOfLife gol = new GameOfLife(12,12);
        gol.trucDeBase(0);

        JFrame frame = new JFrame("Jeu de la vie");
        frame.setSize(430, 700);
        GUI panneau = new GUI(gol);
        frame.getContentPane().add(panneau);

        // panneau.game.prochaineGeneration();
        // frame.getContentPane().repaint();


        int nbGen = 0;
        while(nbGen < 5){
            nbGen = nbGen + 1;
            System.out.println("NEW WAVE n°"+nbGen);
            panneau.game.prochaineGeneration();
            frame.getContentPane().repaint();
            try {
            Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }    
        }
        System.out.print("FINI");
        // frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}