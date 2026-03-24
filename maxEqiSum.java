public class Main {

    static int findMaxSum(int[] arr, int n) {
        int totalSum = 0;

        // Caculating total findSum
        for (int a : arr) {
            totalSum += a;
        }

        int preSum = 0;
        int ans = Integer.MAX_VALUE;
        int indexAns = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            int suffixSum = totalSum - preSum;

            currentDifference = Math.abs(suffixSum - preSum);

            if (currentDifference < ans) {
                indexAns = i;
                ans = currentDifference;
            }
        }

        return indexAns;
    }
}


////
static int findMaxSum(int[] arr, int n) {
    int totalSum = 0;

    // Caculating total findSum
    for (int a : arr) {
        totalSum += a;
    }

    int leftSum = 0;


    for(int i = 0; i < arr.length; i++){

        // Caculating right Sum
           int rightSum = totalSum - (leftSum + arr[i]);

           if(leftSum == rightSum){
               return i;
           }

        leftSum += arr[i];

    }

     return -1;

 }

}
