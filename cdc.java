import java.util.*;

public class cdc{

  public static void eval(int[] arr, int size){

      Stack<Integer> stack = new Stack<>();

      int[] ans = new int[size];
      int k = 0;



      for(int i = size - 1; i >= 1; i--){

         stack.push(arr[size-1]);

         if(arr[i-1] > arr[i]){

           while(!stack.isEmpty() && stack.peek() < arr[i-1]){
            stack.pop();

           }
            stack.push(arr[i]);
            ans[k] = stack.peek();
            k++;
         }
         else{

        ans[k] = stack.peek();
        k++;

        }





        }

        ans[size - 1] = -1;

        for(int i = 0; i < size; i++){

         System.out.print(ans[i] + " ");
      }

  }




 public static void main(String[] args){

    Scanner scan = new Scanner(System.in);

    int size  = scan.nextInt();

    int[] arr = new int[size];

    for(int i = 0; i < size; i++){

       int value = scan.nextInt();

       arr[i] = value;
    }

    eval(arr,size);

 }

}
