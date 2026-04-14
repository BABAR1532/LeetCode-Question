/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static TreeNode dfs(int[] nums, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode currentNode = new TreeNode(nums[mid]);

        currentNode.left = dfs(nums, start, mid - 1);
        currentNode.right = dfs(nums, mid + 1, end);

        return currentNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        return dfs(nums, start, end);
    }
}
