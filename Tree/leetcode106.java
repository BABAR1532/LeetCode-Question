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

    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static int count;

    public static TreeNode dfs(int[] postorder, int start, int end) {
        if (start > end) return null;

        int value = postorder[count--];

        int currentIndex = map.get(value);

        TreeNode currentNode = new TreeNode(value);

        currentNode.right = dfs(postorder, currentIndex + 1, end);
        currentNode.left = dfs(postorder, start, currentIndex - 1);

        return currentNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map.clear();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        count = inorder.length - 1;

        int start = 0;
        int end = count;

        return dfs(postorder, start, end);
    }
}
