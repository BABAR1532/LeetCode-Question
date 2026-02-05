class Solution {
    public String longestPrefix(String s) {

        char[] arr = s.toCharArray();
        int size = s.length();

        int prefix = 0;
        int suffix = 1;

        int[] lps = new int[size];


        while(suffix < size){

           if(arr[suffix] == arr[prefix]){
             lps[suffix] = prefix + 1;
             suffix++;
             prefix++;
           }


           else{

               if(prefix == 0){
                  lps[suffix] = 0;
                  prefix = 0;
                  suffix++;
               }
               else{
                 prefix = lps[prefix  - 1];
               }

           }
        }


     return s.substring(0,lps[size - 1]);

    }
}
