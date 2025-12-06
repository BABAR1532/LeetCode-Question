class Solution {

    
   public static void swapBlocks(int arr[],int start, int end, int length){

   	     for(int i = 0; i < length; i++){
   	     	// clever trick because it is no compusary every time the index will be 0 so
   	     	int temp = arr[start + i];
             
             arr[start+i] = arr[end+i];
             arr[end+i] = temp;
   	     }
   }


    // left Rotate method
    public static void rotateArray(int[] arr,int start, int totalsize, int leftsize){
            
        // No need
        if(leftsize == 0 || leftsize == totalsize) return;


        // Calcuating left size
        int sizeA = leftsize;
        int sizeB = totalsize - leftsize; // leftover



        if(sizeA == sizeB){
        	// Just swap
        	swapBlocks(arr,start,start+sizeA,sizeA);
        }
      

       if(sizeA < sizeB){

       	   swapBlocks(arr,start,start+sizeA,sizeA);

       	   // Recursive call (no need for rotation because we do not achieve the element right position)
       	   rotateArray(arr,start+sizeA,sizeB,leftsize);
       }


     else{

     	 swapBlocks(arr,start+sizeA-sizeB,start+sizeA,sizeB);


     	 // recursive call 
     }


 
    } 


    // Rotation arrayItself
    public static void swap(int[] arr, int start, int end,int d){
              
    }



    public void rotate(int[] nums, int k) {
        
         
        int n = nums.length;


        if(n == 0) return;


        k = k % n;

        // If k become 0
        if(k == 0) return

        int d = n - k;


        rotateArray(arr,0,n,d);
         

    }
}