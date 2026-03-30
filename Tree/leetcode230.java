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

    public static void inOrderStack(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (node == null) return null;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode leftNode = root;
        inOrderStack(stack, root);

        int count = 0;

        while (!stack.isEmpty()) {
            TreeNode newNode = stack.pop();
            inOrderStack(stack, root.right);

            count++;

            if (count == k) return newNode;
        }
    }
}
