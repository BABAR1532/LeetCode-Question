class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        int[] list = new int[128];



        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            list[c]++;
        }




        int start = 0;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();

        while(right < s.length()){

         char c  = s.charAt(right);

         if(list[c] > 0){
           required--;
         }


         list[c]--;
         right++;


         // Window is valid
        while(required == 0){


          if(right - left < minLen){
            minLen = right - left;
            start = left;
          }


          char lc = s.charAt(left);
          list[lc]++;

          if(list[lec] > 0){
            required++:
          }

          left++;

        }

        }

       return minLen == MAX_VALUE ? "" : s.substring(start,start+minLen);

    }
}
