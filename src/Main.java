import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(7);
        graph.addArc(0,1);
        graph.addArc(2,3);
        graph.addArc(1,3);

        List<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(5);
        test.add(6);
        if(graph.chechGraphevide(test)) System.out.println("GRAPHE VIDE");
        test.add(3);
        test.add(1);
        if(!graph.chechGraphevide(test)) System.out.println("GRAPHE VIDE PAS VIDE");


    }
}
