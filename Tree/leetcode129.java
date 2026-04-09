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

    public static int maxVal;

    public static void dfs(TreeNode root, StringBuilder value) {
        if (root == null) return;

        value.append(root.val);

        if (root.left == null && root.right == null) {
            maxVal += Integer.parseInt(value.toString());
            value.deleteCharAt(value.length() - 1);
            return;
        }

        dfs(root.left, value);
        dfs(root.right, value);

        // Bakctracking
        value.deleteCharAt(value.length() - 1);
    }

    public int sumNumbers(TreeNode root) {
        maxVal = 0;

        StringBuilder value = new StringBuilder();
        dfs(root, value);

        return maxVal;
    }
}

// Another Approach
// --------------------
// --------------------------

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

    public static int maxVal;

    public static void dfs(TreeNode root, int result) {
        if (root == null) return;

        result = (result * 10) + root.val;

        if (root.left == null && root.right == null) {
            maxVal += result;

            return;
        }

        dfs(root.left, result);
        dfs(root.right, result);
    }

    public int sumNumbers(TreeNode root) {
        maxVal = 0;

        int result = 0;

        dfs(root, result);

        return maxVal;
    }
}
