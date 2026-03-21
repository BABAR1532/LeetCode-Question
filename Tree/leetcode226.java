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

    // Dfs function
    public static void dfs(TreeNode root) {
        if (root == null) return;

        // Swapping method
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Simple dfs call
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        dfs(root);

        return root;
    }
}


// Another Approach
// *************
// *******************


// Dfs function
public static  dfs(TreeNode root) {

    if (root == null) return;

    // Deep call first
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        root.left = right;
        root.right = left;

        return root;
}
