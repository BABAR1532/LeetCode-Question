import java.util.*;

class leetcode32{

// Method to remove to make valid parentheses
public static String minimumRemove(String value){

   Stack<Integer> stack = new Stack<>();
   char[] arr = value.toCharArray();


   for(int i = 0; i < value.length(); i++){

      char token = value.charAt(i);

      if(token == '('){

         stack.push(i);

      }
      else if(token == ')'){

        if(!stack.isEmpty()){
           stack.pop();
        }

        else {
          arr[i] = '*';

        }

      }

   }

   // If stack is not empty ie invalid parentheses

   while(!stack.isEmpty()){
       arr[stack.pop()] = '*';
   }

   StringBuilder ans = new StringBuilder();

   for(char c:arr){

      if(c != '*'){
        ans.append(c);
      }
   }


   return ans.toString();

}

 public static void main(String[] args){

    Scanner scan = new Scanner(System.in);

    String value = scan.next();


    String ans = minimumRemove(value);

    System.out.println(ans);


 }


}
