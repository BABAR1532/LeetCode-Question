import java.util.*;

public class sequenceAfterFlipping{

    int number = 100;

    String bitNumber = Integer.toBinaryString(number);

    int max = 0;

    for(int i = 0; i < bitNumber.length(); i++){

       char c = bitNumber.charAt(i);

       if(c == '0'){

          // Left side
          int l = i - 1;
          int leftCount = 0

          while(l >= 0 && bitNumber.charAt(l) == '1'){
              leftCount++;
              l--;
          }

          // Right side
          int r = i+1;
          int rightCount = 0

          while(r <= bitNumber.length() - 1 && charAt(r) == '1'){
          rightCount++;
          r++;
          }


          // plus one is for the 0 from where we iterating left and right
          int totalLength = leftCount + rightCount + 1;

          max = Math.max(max,totalLength);

       }

       return max;
    }




}
