import java.util.*;

public class Graph {

    private int Nb_sommet;
    private HashMap<Integer,List<Integer>> adj;


    public Graph(int Nb_sommet){
        this.Nb_sommet = Nb_sommet;
        adj = new HashMap<>();
    }

    public Graph(int Nb_sommet,HashMap<Integer,List<Integer>> adj){
        this.Nb_sommet = Nb_sommet;
        this.adj = (HashMap<Integer,List<Integer>>)adj.clone();
    }
    public int getNb_sommet() {
        return Nb_sommet;
    }
    public HashMap<Integer, List<Integer>> getAdj() {
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
            adj.put(source,new ArrayList<Integer>());
        }
        if(adj.get(destination) == null){
            adj.put(destination,new ArrayList<Integer>());
        }
        adj.get(source).add(destination);
        adj.get(destination).add(source);

    }

    void removeArc(int source,int destination){
        if(!adj.get(source).contains(destination) || !adj.get(destination).contains(source))return;
        adj.get(source).remove((Object)destination);
        adj.get(destination).remove((Object)source);
    }

    public int nb_arc(){
        int nb = 0;
        for(int i = 0; i<adj.size();i++){
            nb += adj.get(i).size();
        }
        return nb;
    }

}
