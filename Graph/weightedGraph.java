import java.util.*;

class Pair {

    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class weightedGraph {

    public static void main(String[] args) {
        int vertices = 3;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        // Intialize list of connected node
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 5));
        graph.get(0).add(new Pair(2, 3));

        // Printing
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "-> ");

            for (Pair p : graph.get(i)) {
                System.out.print("(" + p.node + "," + p.weight + ") ");
            }

            System.out.println();
        }
    }
}
