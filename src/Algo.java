import java.util.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class Algo {
    /**
     *Les fonctions java ne communiquant pas leur complexité, j'estime O(n²)
     */
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

    /**
     * Algorithme trouvé https://en.wikipedia.org/wiki/Maximal_independent_set#Listing_all_maximal_independent_sets
     * Complexité en O(m) avec m étant le nombre d'arc
     */
    static List<Integer> VideMaximal(Graph graph){
        ArrayList<Integer> temp = new ArrayList<>(graph.getAdj().keySet());
        List<Integer> result = new ArrayList<>();
        while(!temp.isEmpty()){
            int i = temp.iterator().next();
            result.add(i);
            for(Integer voisin : graph.getAdj().get(i)){
               if(temp.indexOf(voisin)>= 0) temp.remove(temp.indexOf(voisin));
            }
            temp.remove(temp.indexOf(i));
        }
        return result;
    }

    /**
     *Les fonctions java ne communiquant pas leur complexité, j'estime o(n^4) , n² pour le parcours mais à chaque parcours je lance CheckGraphevide qui
     * est lui meme n² , par imbrication O(n^4)
     */
    static List<Integer> VideMaximum(Graph graph){
        List<Integer> result = new ArrayList<>(); // Liste qui sera retourner en fin d'algo

        if(graph.getAdj().isEmpty())return result;// Si il y a pas de voisin alors on retourne une liste vide
        // J'ajoute un sommet à la liste, puis des sommets 1 & 1 que je retire si ils "cassent" le graphe vide
        for(int i = 0; i<graph.getAdj().size();i++){
            List<Integer> temp = new LinkedList<>();
            temp.add(i);
            for(int j =0;j<graph.getAdj().size();j++){
                if(i!=j)temp.add(j);
                if(!CheckGraphevide(graph,temp))temp.remove((Object)j); //  si ils "cassent" le graphe vide je retire
            }
            if(temp.size()>result.size()) // Si lors de cette itération temp est plus grand que le resultat actuel alors temp devient le resultat
                result = (LinkedList<Integer>) ((LinkedList<Integer>) temp).clone();
        }
        return result;

    }


    /*
    static List<Integer> VideMaximalHeuristic(Graph graph){
       Map<Integer,List<Integer>> sorted = graph.getAdj().entrySet().stream()
               .sorted(comparingInt(e -> e.getValue().size()))
               .collect(toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                LinkedHashMap::new
        ));
        ArrayList<Integer> min_degre = (ArrayList<Integer>) sorted.keySet();
        for(Integer i : min_degre){

        }
    }
    */

}
