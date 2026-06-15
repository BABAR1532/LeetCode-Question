import java.util.HashMap;

class Solution {

    public int ladderLength(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {
        // First we will create a hashset to put all the values in it
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), i);
        }

        if (!map.containsKey(endWord)) return 0;

        int distance = 1;

        Queue<String> q = new LinkedList<>();

        boolean[] visited = new boolean[wordList.size()];

        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String value = q.poll();

                for (int i = 0; i < value.length(); i++) {
                    if (value.equals(endWord)) return distance;

                    char[] arr = value.toCharArray();

                    char orginal = arr[i];

                    for (int j = 0; j < 26; j++) {
                        char c = (char) ('a' + j);
                        arr[i] = c;

                        String newValue = new String(arr);

                        if (map.containsKey(newValue)) {
                            int index = map.get(newValue);

                            if (!visited[index]) {
                                q.offer(newValue);
                                // Mark as visited
                                visited[index] = true;
                            }
                        }
                    }
                    arr[i] = orginal;
                }
            }

            distance++;
        }

        return 0;
    }
}

/////
//
// ******************* Hashset ******************** approach

HashSet<String> set = new HashSet<>(wordList);

Queue<String> q = new LinkedList<>();

q.offer(beginWord);

int distance = 1;

while (!q.isEmpty()) {
    int size = q.size();

    while (size-- > 0) {
        String word = q.poll();

        if (word.equals(endWord)) {
            return distance;
        }

        for (int i = 0; i < word.length(); i++) {
            char[] arr = word.toCharArray();

            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;

                String next = new String(arr);

                if (set.contains(next)) {
                    q.offer(next);

                    set.remove(next); // visited
                }
            }

            arr[i] = original;
        }
    }

    distance++;
}

return 0;
