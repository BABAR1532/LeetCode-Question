import java.util.*;
class chineseRemainder{
  public static int FindMin(int[] num, int[] rem, int size){
    // Calculating total Big M
    int M = 1;
    for(int i = 0; i < size; i++){
       M *= num[i];  // ✓ Fixed: num[i] instead of num[0]
    }

    int ans = 0;
    for(int i = 0; i < size; i++){  // ✓ Fixed: syntax error
      int b = M / num[i];
      // Adding actual ans
      ans += rem[i] * b * modInverse(b, num[i]);
    }
    return ans % M;
  }

   // Method to calculate modInverse
   public static int modInverse(int c, int mod){
       c = c % mod;
       for(int i = 1; i < mod; i++){
          if((c * i) % mod == 1){  // ✓ Fixed: (c * i) % mod == 1
              return i;
          }
       }
      // Just for condition no use
      return 1;
   }

   public static void main(String[] args){
       int[] num = {3, 4, 5};
       int[] rem = {2, 3, 1};
       int k = num.length;
       System.out.println(FindMin(num, rem, k));
   }
}
