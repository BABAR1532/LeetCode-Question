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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        if(root ==  null) return lists;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode newNode = q.poll();

                list.add(newNode.val);

                if (newNode.left != null) {
                    q.add(newNode.left);
                }
                if (newNode.right != null) {
                    q.add(newNode.right);
                }
            }
            lists.add(list));
        }
        return lists;
    }
}
