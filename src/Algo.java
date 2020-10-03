import java.util.List;

public class Algo {

    static boolean CheckGraphevide(Graph graph,List<Integer> sous_graphe){
        if(sous_graphe.size() == graph.getNb_sommet() && !graph.getAdj().isEmpty()){
            return false;
        }
        for(int i : sous_graphe){
            for(int j : sous_graphe){
                if (graph.getAdj().get(i) == null)break;
                if(i != j && graph.getAdj().get(i).contains(j)) return false;
            }
        }

        return true;
    }

}
