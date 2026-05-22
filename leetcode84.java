class Solution {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int size = heights.length;

        int max = -1;

        for (int i = 0; i < size; i++) {
            int height = heights[i];

            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];

                int left = (stack.isEmpty() ? -1 : stack.peek());
                int right = i;

                int width = right - left - 1;
                max = Math.max(max, width * currentHeight);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int currentHeight = heights[stack.pop()];
            int left = (stack.isEmpty() ? -1 : stack.peek());

            int right = size;

            int width = right - left - 1;

            max = Math.max(max, width * currentHeight);

            return max;
        }
    }
}
