package life;

public class QuadTree{
    Integer val;
    QuadTree fils1, fils2, fils3, fils4;
    boolean estFeuille;

    public QuadTree(int val, QuadTree fils1, QuadTree fils2, QuadTree fils3, QuadTree fils4){
        this.val = val;
        this.fils1 = fils1;
        this.fils2 = fils2;
        this.fils3 = fils3;
        this.fils4 = fils4;
        this.estFeuille = false;
    }

    public QuadTree(){
        this.val = null;
        this.fils1 = null;
        this.fils2 = null;
        this.fils3 = null;
        this.fils4 = null;
        this.estFeuille = true;
    }

    public QuadTree(int val){
        this.val = val;
        this.fils1 = null;
        this.fils2 = null;
        this.fils3 = null;
        this.fils4 = null;
        this.estFeuille = true;
    }

    public String toString(){
        return afficheQuad(this);
    }

    public String afficheQuad(QuadTree q){
        if (q.estFeuille == true){
            return String.valueOf(q.val);
        }
        else{
            return String.valueOf(q.val) +"\nfils1 : "+ afficheQuad(q.fils1) +"   fils2 : "+ afficheQuad(q.fils2) +"   fils3 : "+ afficheQuad(q.fils3) +"   fils4 : "+ afficheQuad(q.fils4);
        }
    }

    public static void main(String args[]){
        QuadTree n1 = new QuadTree(12);
        QuadTree n2 = new QuadTree(1);
        QuadTree n3 = new QuadTree(15);
        QuadTree n4 = new QuadTree(5);

        QuadTree n111 = new QuadTree(1222);
        QuadTree n222 = new QuadTree(111);
        QuadTree n333 = new QuadTree(1555);
        QuadTree n444 = new QuadTree(555);

        QuadTree n1111 = new QuadTree(12222);
        QuadTree n2222 = new QuadTree(1111);
        QuadTree n3333 = new QuadTree(15555);
        QuadTree n4444 = new QuadTree(5555);

        QuadTree n11111 = new QuadTree(122222);
        QuadTree n22222 = new QuadTree(11111);
        QuadTree n33333 = new QuadTree(155555);
        QuadTree n44444 = new QuadTree(55555);

        QuadTree n11 = new QuadTree(122,n1,n2,n3,n4);
        QuadTree n22 = new QuadTree(11,n111,n222,n333,n444);
        QuadTree n33 = new QuadTree(155,n1111,n2222,n3333,n4444);
        QuadTree n44 = new QuadTree(55,n11111,n22222,n33333,n44444);

        QuadTree q = new QuadTree();
        q.fils1 = n11;
        q.fils2 = n22;
        q.fils3 = n33;
        q.fils4 = n44;
        q.estFeuille = false;
        System.out.println(q);
    }

}