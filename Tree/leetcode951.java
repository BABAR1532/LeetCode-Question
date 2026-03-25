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

    public static boolean flipTree(TreeNode root1, TreeNode root2) {
        // If both return to end
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        // We have to check condition at each and every node i.e flip is required or not
        // That why left to left check then left and right check in opposite tree

        return (
            (flipTree(root1.left, root2.left) &&
                flipTree(root1.right, root2.right)) ||
            (flipTree(root1.left, root2.right) &&
                flipTree(root1.right, root2.left))
        );
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipTree(root1, root2);
    }
}

// Bfs Approach

// Method to compare node value
public static void checkNode(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;

    return n1.val == n2.val;
}

public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root1, root2);

    while (!q.isEmpty()) {
        TreeNode node1 = q.poll();
        TreeNode node2 = q.poll();

        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        // No flip
        if (
            checkNode(node1.left, node2.left) &&
            checkNode(node1.right, node2.right)
        ) {
            q.offer(node1.left);
            q.offer(node2.left);
            q.offer(node1.right);
            q.offer(node2.right);
        }
        // Flip
        else if (
            checkNode(node1.left, node2.right) &&
            checkNode(node1.right, node2.left)
        ) {
            q.offer(node1.left);
            q.offer(node2.right);
            q.offer(node1.right);
            q.offer(node2.left);
        } else {
            return false;
        }
    }

    return true;
}
