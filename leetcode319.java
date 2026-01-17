class Solution {

     public static void toogle(boolean[] Switch,int num,int size){
        for(int i = num; i <= size; i += num){
             Switch[i] = !Switch[i];
         }
     }


    public int bulbSwitch(int n) {

        if(n <= 1) return n;

        boolean[] Switch = new boolean[n+1];

        Arrays.fill(Switch,true);

        for(int i = 2; i <= n; i++){
          // Toggling
           toogle(Switch,i,n);
        }

        int count = 0;

        for(int i = 1; i <= n; i++){
           if(Switch[i]){
              count++;
            }
        }

        return count;
    }
// }
