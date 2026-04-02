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

    public boolean isCompleteTree(TreeNode root) {
        //Bfs Solution
        Queue<TreeNode> q = new LinkedList<>();

        boolean flag = false;

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode newNode = q.poll();

            if (newNode == null) {
                flag = true;
            } else {
                if (flag) return false;

                q.add(newNode.left);
                q.add(newNode.right);
            }
        }

        return true;
    }
}

class Solution {

    // Method to Calculate Node

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + (left + right);
    }

    // Checking tree is complete tree or not
    public static boolean acbt(TreeNode root, int count, int index) {
        if (root == null) return true;

        if (index > count) return false;

        return (
            acbt(root.left, count, 2 * index) &&
            acbt(root.right, count, 2 * index + 1)
        );
    }

    public boolean isCompleteTree(TreeNode root) {
        // Calculating Total number of nodes

        int count = countNodes(root);

        return acbt(root, count, 1);
    }
}
