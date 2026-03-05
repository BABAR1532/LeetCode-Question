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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) return lists;

        Queue<TreeNode> q = new LinkedList<>();

        boolean leftToRight = true;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> currentList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();

                if (leftToRight) {
                    currentList.add(currentNode.val);
                } else {
                    currentList.add(0, currentNode.val);
                }

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
            lists.add(currentList);
            leftToRight = !leftToRight;
        }

        return lists;
    }
}
