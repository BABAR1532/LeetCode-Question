class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        Arrays.fill(indegree, 0);

        // Creating Adjacency lists
        for (int[] list : prerequisites) {
            lists.get(list[1]).add(list[0]);
            indegree[list[0]] = indegree[list[0]] + 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int value : lists.get(node)) {
                indegree[value]--;

                if (indegree[value] == 0) {
                    q.add(value);
                }
            }
        }

        if (count == numCourses) return true;

        return false;
    }
}
