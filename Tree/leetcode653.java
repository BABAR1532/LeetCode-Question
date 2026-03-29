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

    public static boolean dfs(TreeNode root, int k, HashSet<Integer> map) {
        if (root == null) return false;

        int requiredValue = k - root.val;

        if (map.contains(requiredValue)) {
            return true;
        }

        return dfs(root.left, k, map) && dfs(root.right, k, map);
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map = new HashSet<>();

        map.put(root.val);

        return dfs(root, k, map);
    }
}
