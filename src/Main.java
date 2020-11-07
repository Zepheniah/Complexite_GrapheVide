import jdk.swing.interop.SwingInterOpUtils;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addArc(0,1);
        graph.addArc(0,2);
        graph.addArc(1,3);
        graph.addArc(4,5);
        graph.addArc(5,6);
        graph.addArc(3,7);



        List<Integer> test = new ArrayList<>();
        test.add(0);
        test.add(6);
        test.add(3);
        System.out.println("QUESTION 1");
        if(Algo.CheckGraphevide(graph,test)) System.out.println("GRAPHE VIDE");
        System.out.println(test);
        test.add(2);
        test.add(1);
        if(!Algo.CheckGraphevide(graph,test)) System.out.println("GRAPHE VIDE PAS VIDE");
        System.out.println(test);
        System.out.println("-----------------------------------------------------------");
        System.out.println("QUESTION 2 ");
        List<Integer> test2 = Algo.VideMaximal(graph);
        System.out.println("Un sous ensemble maximal"+test2);
        if(Algo.CheckGraphevide(graph,test2)) System.out.println("GRAPHE VIDE");
        System.out.println("------------------------------------------------------------");
        System.out.println("QUESTION 3 ");
        List<Integer> test3 = Algo.VideMaximum(graph);
        if(Algo.CheckGraphevide(graph,test3)) System.out.println("GRAPHE VIDE");
        System.out.println("Graphe Maximum"+test3);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Question 4");
        List<Integer> test4 = Algo.VideMaximalHeuristic(graph);
        if(Algo.CheckGraphevide(graph,test4)) System.out.println("GRAPHE VIDE");
        System.out.println(test4);


    }

}
