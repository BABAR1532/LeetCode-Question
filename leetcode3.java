class Solution {
    public int lengthOfLongestSubstring(String s) {


      if(s.length() == 0) return 0;

      Char[] list = s.toCharArray(s);

      int start = 0;

      int max = Integer.MAX_VALUE;

      HashMap<String,Integer> map = new HashMap<>();

      for(int end = 0; end < list.length; end++){

           char value = list[end];

           map.put(value,map.getOrDefualt(value,0) + 1);

           while(map.get(value) > 1){

           char leftChar = list[start];

           map.put(leftChar,map.get(leftChar) - 1);

           left++; // Moving window

           }


           max = Math.max(max,end - start + 1);

      }

      return max;

    }
}
