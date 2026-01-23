class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {


        int i = 0;
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();


        while(i < n && intervals[i][1] < newInterval[0]){
           result.add(intervals[i]);
           i++;
        }

        // Overlapping

        while(i < n && intervals[i][0] <= newInterval[1]){

           newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
           newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
           i++;
        }


         // Add the new non overlapping intervals
         result.add(newInterval);


         // Adding remaining values
         while(i < n){
           result.add(intervals[i]);
           i++;
         }

         return result.toArray(new int[result.size()][]);
    }
}
