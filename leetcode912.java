import java.util.*;



public class leetcode912{

   public static void main(String[] args){


    Scanner scan = new Scanner(System.in);

    solution sol = new solution();

     List<Integer> list = new ArrayList<>();

     while(true){

       int value = scan.nextInt();

       if(value == -1) break;

        list.add(value);

     }

      sol.quickSort(list,0,list.size()-1);

      for(int a:list){
          System.out.print(a + " ");
      }


   }

}



class solution{

   // For avoiding worst case senario
   static Random rand = new Random();



  public static void quickSort(List<Integer> arr,int low,int high){

       if(low < high){

          int Pindex = partition(arr,low,high);

          quickSort(arr,low,Pindex-1);
          quickSort(arr,Pindex+1,high);

       }
  }


  static int partition(List<Integer> arr, int low, int high){


    int pivotIndex = low + rand.nextInt(high - low + 1);

    int tempi = arr.get(low);
    arr.set(low,arr.get(pivotIndex));
    arr.set(pivotIndex,tempi);


      int pivot = arr.get(low);

      int i = low;
      int j = high;


      while(i < j){

          // Moving low
          while(arr.get(i) <= pivot && i <= high - 1){
           i++;
          }


         // Moving high
         while(arr.get(j) > pivot && j >= low + 1){
            j--;
         }


       if(i < j){

           // Swapping
           int temp = arr.get(i);
           arr.set(i,arr.get(j));
           arr.set(j,temp);

       }

      }


      int temp = pivot;
      arr.set(low,arr.get(j));
      arr.set(j,temp);

      return j;

  }


}






