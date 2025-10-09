import java.util.*;


public class leetcode224{


   // Method for  basic_Calculator

   public static int basic_Calculator(String value){

     Stack<Integer> stack = new Stack<>();

     int sign = 1;
     int number = 0;
     int total = 0;

     for(char token:value.toCharArray()){

         if(Character.isDigit(token)){

           // Suppose number is 2222 then we need forumla that why
           number = number * 10 + (token - '0');
         }

         else if(token == '+'){

          total += sign * number;
          sign = 1;
          number = 0;
         }

         else if(token == '-'){

          total += sign * number;
          sign = -1;
          number = 0;

         }

         else if(token == '('){

          stack.push(total);
          stack.push(sign);

          total = 0;
          sign = 1;   // We do not reset the number because it already will be set to 0

         }

         else if(token == ')'){

           total += sign * number;
           total *= stack.pop();
           total += stack.pop();

           // since number will be not reset we have to reset it manually
           number = 0;

         }

       }

         // Last number calculation
         total += sign * number;

         return total;

     }


 public static void main(String[] args){

   Scanner scan = new Scanner(System.in);

   String input = scan.next();


   int ans = basic_Calculator(input);


   System.out.println(ans);


  }

}
