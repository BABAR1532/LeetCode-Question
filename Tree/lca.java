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

    public static int commonBoss(
        TreeNode root,
        TreeNode p,
        TreeNode q,
        TreeNode commonBoss
    ) {
        // He can not boss any one
        if (root == null) return 0;

        // dfs
        int left = commonBoss(root.left, p, q, commonBoss);
        int right = commonBoss(root.right, p, q, commonBoss);

        int self = 0;

        if (root == p || root == q) {
            self = 1;
        }

        int total = left + right + self;

        // If we find lowest ancestor (because recursion flow from down to up)
        if (total == 2 && commonBoss == null) {
            commonBoss = root;
        }

        return total;
    }

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        TreeNode commonBoss = null;

        int count = lowestBoss(root, p, q, commonBoss);

        return commonBoss;
    }
}

// Another method

public static TreeNode commonBoss(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = commonBoss(root.left, p, q);
    TreeNode right = commonBoss(root.right, p, q);

    if (left != null && right != null) return root;

    return (left != null) ? left : right;
}
