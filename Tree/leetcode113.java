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

    public static List<List<Integer>> dfs(
        TreeNode root,
        List<Integer> list,
        int targetSum
    ) {
        if (root == null) return null;

        List<List<Integer>> ans = new ArrayList<>();

        list.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(list));
            }

            // Back tracking
            list.remove(list.size() - 1);
            return ans;
        }

        List<List<Integer>> left = dfs(root.left, list, targetSum);
        if (left != null) and.addAll(left);

        List<List<Integer>> right = dfs(root.right, list, targetSum);
        if (right != null) ans.addAll(right);

        // Backtracking
        list.remove(list.size() - 1);

        return ans;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();

        return dfs(root, list, targetSum);
    }
}
