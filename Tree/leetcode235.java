/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val > root.val && q.val > root.val) {
            return dfs(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return dfs(root.left, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        return dfs(root, p, q);
    }
}
