import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Graph {

    private int Nb_sommet;
    private HashMap<Integer,HashSet<Integer>> adj;


    public Graph(int Nb_sommet){
        this.Nb_sommet = Nb_sommet;
        adj = new HashMap<>();
    }
    public int getNb_sommet() {
        return Nb_sommet;
    }
    public HashMap<Integer, HashSet<Integer>> getAdj() {
        return adj;
    }

    void addArc(int source, int destination){
        if(source >= Nb_sommet || source < 0 || destination >= Nb_sommet || destination < 0){
            System.out.println("Sommet non disponible sommet compris entre 0 et"+ (Nb_sommet-1) );
            return;
        }
        if(source == destination){
            System.out.println("Pas d'arc rentrant sur lui meme");
            return;
        }
        if(adj.get(source) == null){
            adj.put(source,new HashSet<Integer>());
        }
        if(adj.get(destination) == null){
            adj.put(destination,new HashSet<Integer>());
        }
        adj.get(source).add(destination);
        adj.get(destination).add(source);

    }

    void removeArc(int source,int destination){
        adj.get(source).remove(destination);
        adj.get(destination).remove(source);
    }


}
