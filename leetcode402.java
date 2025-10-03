import java.util.*;




public class leetcode402{


   // Method to remove k digits

    public static String removeKdigit(String val,int k){

       Stack<Character> stack = new Stack<>();

       for(char value: val.toCharArray()){



           if(!stack.isEmpty() && k > 0 && stack.peek() > value){

              stack.pop();
              k--;

           }

           stack.push(value);

       }

       // If k > 0
       while(!stack.isEmpty() && k > 0){
        stack.pop();
        k--;
       }


       StringBuilder ans = new StringBuilder();


       while(!stack.isEmpty()){
         ans.append(stack.pop());
       }


       ans.reverse();


       // Removing derailing 0


       while(ans.length() > 0 && ans.charAt(0) == '0'){
          ans.deleteCharAt(0);

       }



      return ans.length() == 0 ? "0" : ans.toString();

    }




     public static void main(String[] args){


      Scanner scan = new Scanner(System.in);

      String number = scan.next();

      System.out.println(removeKdigit(number,2));




  }

}
