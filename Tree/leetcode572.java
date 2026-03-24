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

    // Method to finding same tree
    public static boolean sameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.val != tree2.val) return false;
        return (
            sameTree(tree1.left, tree2.left) &&
            sameTree(tree1.right, tree2.right)
        );
    }

    // Method to find subTree or not
    public static boolean subTree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (sameTree(root, subRoot)) {
            return true;
        }

        return subTree(root.left, subRoot) || subTree(root.right, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return subTree(root, subRoot);
    }
}
