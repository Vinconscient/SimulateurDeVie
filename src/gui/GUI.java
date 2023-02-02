package gui;
import javax.swing.*;
import java.awt.*;
import life.*;
class GUI {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Jeu de la vie ©");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);

        //Creating the MenuBar and adding components
        JMenuBar menu = new JMenuBar();
        JMenu para = new JMenu("Paramètres");
        JMenu m2 = new JMenu("Squeezie");
        menu.add(para);
        menu.add(m2);
        JMenuItem tailleX = new JMenuItem("Taille en X");
        JMenuItem tailleY = new JMenuItem("Taille en Y");
        JMenuItem vie = new JMenuItem("Vie");
        JMenuItem mort = new JMenuItem("Mort");
        JMenuItem pub = new JMenuItem("alyx.live cliquez ici YoKo");
        tailleX.showInputDialog("Entrez la taille en X");
        para.add(vie);
        para.add(mort);
        m2.add(pub);
        para.add(tailleX);
        para.add(tailleY);


        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Entre la vie");
        JTextField tf = new JTextField(4);
        JButton send = new JButton("selectionner");
        JButton reset = new JButton("Reset");
        panel.add(label); 
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        JTextArea ta = new JTextArea();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menu);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
}