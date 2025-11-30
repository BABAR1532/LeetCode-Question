class Solution {
    public int[][] reconstructQueue(int[][] people) {


        // Compartor is very important here
        Arrays.sort(people, (a,b) -> {
           if(a[0] == b[0]) return a[1] - b[1];
           return b[0] - a[0];
        });

        List<int[]> result = new ArryaList<>();

        for(int[] person: people){
          result.add(person[1],person);
        }

        return result.toArray(new int[people.length][]);

    }
}
