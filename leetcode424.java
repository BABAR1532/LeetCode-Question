class Solution {
    public int characterReplacement(String s, int k) {


        int alpaBet[] = new int[26];

        int maxSum = 0;
        int start = 0;
        int ans = 0;

        for(int end = 0; end < s.length(); end++){

           int index = s.charAt(end) - 'A';

           alpaBet[index]++;

           maxSum = Math.max(maxSum,alpaBet[index]);

          // Shrinking
          while((end - start + 1) - maxSum > k){
            alpaBet[s.charAt(start) - 'A']--;
            start++;
          }


          ans = Math.max(maxSum,end - start + 1);
        }


        return ans;

    }
}
