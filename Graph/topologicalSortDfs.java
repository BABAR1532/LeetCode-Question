class Solution {

    public void dfs(
        ArrayList<ArrayList<Integer>> lists,
        int node,
        boolean[] visited,
        Stack<Integer> stack
    ) {
        visited[node] = true;

        for (int value : lists.get(node)) {
            if (!visited[value]) {
                dfs(lists, value, visited, stack);
            }
        }

        stack.push(node);
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        // Creating Adjacency list{
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(lists, i, visited, stack);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }
}
