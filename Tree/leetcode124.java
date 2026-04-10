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

    public static int maxPath;

    public static int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int total = left + root.val + right;

        maxPath = Math.max(maxPath, total);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;

        dfs(root);

        return maxPath;
    }
}
