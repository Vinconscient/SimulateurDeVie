package life;
import java.util.ArrayList;

public class GameOfLife{

    private int[][] grille;
    private int tailleColonne = 4;
    private int tailleLigne = 4;

    public GameOfLife(int tailleColonne, int tailleLigne){
        this.tailleColonne = tailleColonne;
        this.tailleLigne = tailleLigne;
        this.grille = new int[tailleLigne][tailleColonne];
        this.setup();
    }

    private void setup(){
        for(int i=0; i<this.tailleLigne;i++){
            for(int j=0; j<this.tailleColonne;j++){
                this.grille[i][j] = 0;
            }
        }
    }

    public void setCellule(int x,int y){this.grille[x][y] = 1;}

    public int nbVoisin(int x, int y){
        //return this.grille[i-1][j-1] + this.grille[i-1][j] + this.grille[i+1][j-1] + this.grille[i][j-1] + this.grille[i+1][j] + this.grille[i+1][j-1] + this.grille[i+1][j] + this.grille[i+1][j+1];
        int res = 0;
        for(int i = -1; i<= 1; i++){
            for(int j=-1; j<=1;j++){
                if(i==0 && j == 0){
                    continue;
                }
                int ligne = (x + i + this.tailleLigne) % this.tailleLigne; // on fait modulo la taille pour que le tableau soit "lié" en haut et en bas
                int colonne = (y + j + this.tailleColonne) % this.tailleColonne; // comme au dessus mais a gauche et a droite 
                res += this.grille[ligne][colonne];
            }
        }
        return res;
    }

    public void prochaineGeneration(){
        int[][] grilleRes = new int[this.tailleLigne][this.tailleColonne];
        for(int i=0; i<this.tailleLigne;i++){
            for(int j=0; j<this.tailleColonne;j++){
                int voisin = this.nbVoisin(i,j);
                if(this.grille[i][j] == 1){
                    // La cellule est vivante
                    if(voisin < 2 || voisin > 3){
                        grilleRes[i][j] = 0; 
                    }
                    else{
                        grilleRes[i][j] = 1;
                    }
                }
                else{
                    if(voisin == 3){
                        grilleRes[i][j] = 1;
                    } 
                }                
            }
        }
        this.grille = grilleRes;
    }

    public void trucDeBase(int delta){
        this.setCellule(1+delta,2+delta);
        this.setCellule(2+delta,3+delta);
        this.setCellule(3+delta,1+delta);
        this.setCellule(3+delta,2+delta);
        this.setCellule(3+delta,3+delta);
    }

    @Override
    public String toString(){
        String res = "";
        for(int i=0; i<this.tailleLigne; i++){
            for(int j=0; j<this.tailleColonne; j++){
                if(this.grille[i][j] == 1){
                    res += "■";
                }
                else {
                    res += "□";
                }
                res += " ";
            }
            res += "\n";
        }
        return res;
    }
}
