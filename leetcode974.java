class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int result = 0;
        int sum = 0;

        HashMap<Integer,Integer> map = HashMap<>();

        // Initial value if first element is ans itself
        map.put(0,1);

        for(int i = 0; i < nums.length; i++){

            // Adding value first
            sum += nums[i];


            // Making Remainder Positive
            int div = ((sum % k) + sum) % k;

            if(map.contains(div)){
                result += map.get(div);
            }
            else{
              map.put(div,getOrDefault(div,0) + 1);
            }
        }

        return result;

    }
}
