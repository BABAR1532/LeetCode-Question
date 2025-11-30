class Solution {
    public int maxProfit(int[] prices) {

        int size = prices.length;

        int maxInt = 0;

        for(int i = 0; i < size; i++){

            int stock = prices[i];

            for(int j = i + 1; j < size; j++){

                if(prices[j] > stock){

                 int profit = prices[j] - stock;

                 maxInt = Math.max(maxInt,profit);

                 }
            }

        }

        return maxInt;

    }
}
