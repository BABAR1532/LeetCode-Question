import java.util.*;

public class leetcode150{



public static int evalRPN(String[] tokens){

 Stack<Integer> stack = new Stack<>();

  for(int i = 0; i < tokens.length; i++){

  if(tokens[i].equals("+")){
       int ans2 = stack.pop();
       int ans1 = stack.pop();

       stack.push(ans2+ans1);
  }

  else if(tokens[i].equals("-")){

       int ans2 = stack.pop();
       int ans1 = stack.pop();

       stack.push(ans1-ans2);

  }

  else if(tokens[i].equals("*")){


       int ans2 = stack.pop();
       int ans1 = stack.pop();

       stack.push(ans2*ans1);

  }
  else if(tokens[i].equals("/")){

      int ans2 = stack.pop();
       int ans1 = stack.pop();

       stack.push(ans1/ans2);

  }
  else{

   stack.push(Integer.parseInt(tokens[i]));

  }


  }

   return stack.pop();

}


 public static void main(String[] args){


   Scanner scan = new Scanner(System.in);

   System.out.println("Enter the number of tokens in RPN Expression:");
   int n = scan.nextInt();

   scan.nextLine(); // Consume newline

   String[] tokens = new String[n];

   System.out.println("Enter the tokens separted by space:");

   tokens = scan.nextLine().trim().split(" ");

   int result = evalRPN(tokens);


   System.out.println("Result of the RPN expression: " + result);


  }
}
