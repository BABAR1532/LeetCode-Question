class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length;

        int count1 = 0;
        int count2 = 0;

        int major1 = 0;
        int major2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major1) {
                count1++;
            } else if (nums[i] == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                major2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<Integer>();

        // checking majority ass well
        // For majority1 && majority2
        int majorOccur1 = 0;
        int majorOccur2 = 0;
        for (int i : nums) {
            if (i == major1) {
                majorOccur1++;
            } else if (i == major2) {
                majorOccur2++;
            }
        }

        if (majorOccur1 > (size / 3)) {
            list.add(major1);
        }

        if (majorOccur2 > (size / 3)) {
            list.add(major2);
        }

        return list;
    }
}
