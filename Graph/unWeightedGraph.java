import java.util.*;

class unWeightedGraph {

    public static void main(String[] args) {
        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize list of connected node
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding element
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);

        graph.get(2).add(0);
        graph.get(2).add(4);

        // Printing
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "->" + graph.get(i));
        }
    }
}
