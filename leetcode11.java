class Solution {
    public int maxArea(int[] height) {

        int minValue = Integer.MIN_VALUE;

        int end = height.length - 1;
        int start = 0;

        while(start < end){

           minvalue = Math.max(minvalue,(end - i ) * Math.min(height[start],height[end]));


             if(height[start] <= height[end]){

               start++;

             }
             else {

               end--;

             }

        }

        return minValue;


    }
}
