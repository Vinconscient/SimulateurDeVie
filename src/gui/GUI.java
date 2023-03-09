package gui;
import life.GameOfLife;
import java.awt.*;
import javax.swing.*;
public class GUI extends JPanel{
    GameOfLife game = new GameOfLife(3,3);
    public GUI(GameOfLife game){       
        setSize( 700, 700 );
        setVisible( true );
        this.game = game;
        this.game.trucDeBase(0);

    } 
    @Override
    public void paintComponent( Graphics g){  
        int x = 30;
        for(int[] nbr : this.game.grille ){
            int y = 30;
            for(int nbr2 : nbr){
                if(nbr2 == 1){
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 30, 30);
                    g.drawRect( x, y, 30, 30 );
                }
                else{
                    g.setColor(Color.BLACK);
                    g.drawRect( x, y, 30, 30 );
                }
                y+=30;
            }
            x+=30;
        }

    } 
  
} 

