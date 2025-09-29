import java.util.*;





class leetcode32{

   public static void main(String[] args){

     Scanner scan = new Scanner(System.in);

     String value = scan.next();

     System.out.println(LongValidParent(value));



   }

   // Longest valid Parentheses
   public static int LongValidParent(String value){


     Stack<Integer> stack = new Stack<>();
     stack.push(-1);
     int max = 0;


     for(int i = 0; i < value.length() - 1; i++){

         char token = value.charAt(i);

         if(token == '('){
           stack.push(i);
         }
         else{

           // We will pop out if char is (
           stack.pop();

           // If stack get empty then we push the index in stack
           // Then continue to next iteration no need to reassign max value
           if(stack.isEmpty()){
             stack.push(i);
             continue;
           }

         }

         max = Math.max(max,i - (stack.peek()));
     }

      return max;
   }


}
