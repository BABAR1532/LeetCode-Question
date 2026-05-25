class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            count++;

            for (int value : lists.get(node)) {
                indegree[value]--;

                if (indegree[value] == 0) {
                    q.add(value);
                }
            }
        }

        int ansArray[] = new int[numCourses];

        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }

        if (count == numCourses) return ansArray;
        return new int[] {};
    }
}
