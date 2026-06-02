class Solution {

    public char find(char value, char[] parent) {
        if (value == parent[value - 'a']) return value;

        return parent[value - 'a'] = find(parent[value - 'a'], parent);
    }

    public void union(char value1, char value2, char[] parent, int[] rank) {
        char parent1 = find(value1, parent);
        char parent2 = find(value2, parent);

        if (parent1 == parent2) return;
        else if (rank[parent1 - 'a'] < rank[parent2 - 'a']) {
            parent[parent1 - 'a'] = parent2;
        } else if (rank[parent1 - 'a'] > rank[parent2 - 'a']) {
            parent[parent2 - 'a'] = parent1;
        } else if (rank[parent1 - 'a'] == rank[parent2 - 'a']) {
            parent[parent1 - 'a'] = parent2;
            rank[parent2 - 'a'] += 1;
        }
    }

    public boolean equationsPossible(String[] equations) {
        char[] parent = new char[26];

        for (char c = 'a'; c <= 'z'; c++) {
            parent[c - 'a'] = c;
        }

        int[] rank = new int[26];

        for (int i = 0; i < equations.length; i++) {
            String input = equations[i];

            char value1 = input.charAt(0);
            char value2 = input.charAt(3);

            char operation = input.charAt(1);

            if (operation == '=') {
                union(value1, value2, parent, rank);
            }
        }

        for (int i = 0; i < equations.length; i++) {
            String input = equations[i];

            char value1 = input.charAt(0);
            char value2 = input.charAt(3);

            char operation = input.charAt(1);

            if (operation == '!') {
                char parent1 = find(value1, parent);
                char parent2 = find(value2, parent);

                if (parent1 == parent2) return false;
            }
        }

        return true;
    }
}
