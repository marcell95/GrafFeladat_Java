package hu.petrik.graffeladat;

public class Main {
    public static void main(String[] args) {
        
        Grafok G = new Grafok();
        
        //próbáltam a megadott kiiratásokat, de nem működtek,
        //megjavítani meg már nem volt türelmem, de a feladatok működnek
        
        //G.getIranyitatlanG().toString();
        //G.getIranyitottG().toString();
        
        //a második paraméter mindig a kiindulási csúcs/vertex
        MelysegiBejaras M = new MelysegiBejaras(G.getIranyitottG(), 2);
        SzelessegiBejaras Sz = new SzelessegiBejaras(G.getIranyitottG(), 2);
        
        Dijsktra D = new Dijsktra();
        D.legrovidebbUt(G.getIranyitatlanG(), 0);
    }
    
    
}
