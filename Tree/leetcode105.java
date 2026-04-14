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

    // Important global variables

    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static int index;

    // Method to build tree
    public static TreeNode dfs(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int currentValue = preorder[index];
        TreeNode newNode = new TreeNode(currentValue);
        index++;

        int inIndex = map.get(currentValue);

        newNode.left = dfs(preorder, start, inIndex - 1);
        newNode.right = dfs(preorder, inIndex + 1, end);

        return newNode;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        map.clear();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode buildTree = null;

        int start = 0;
        int end = inorder.length - 1;

        return dfs(preorder, start, end);
    }
}
