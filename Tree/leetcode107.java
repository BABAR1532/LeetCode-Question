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

    // Finding height of tree
    public static int heightTree(TreeNode root) {
        if (root == null) return 0;

        int left = heightTree(root.left);
        int right = heightTree(root.right);

        return Math.max(left, right) + 1;
    }

    public static void dfs(
        TreeNode root,
        int height,
        int currentHeight,
        List<List<Integer>> lists
    ) {
        if (root == null) return;

        lists.get(height - currentHeight - 1).add(root.val);

        dfs(root.left, height, currentHeight + 1, lists);
        dfs(root.right, height, currentHeight + 1, lists);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<Integer>();

        if (root == null) return lists;

        int height = heightTree(root);
        int currentHeight = 0;

        for (int i = 0; i < height; i++) {
            lists.add(new ArrayList<>());
        }

        dfs(root, height, currentHeight, lists);

        return lists;
    }
}


// BFS


public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> ans = new ArrayList<>();

    if(root == null) return ans;

    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);

    while(!q.isEmpty()){

        int size = q.size();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++){

              TreeNode currentNode = q.poll();
              list.add(currentNode.val);

              if(currentNode.left != null){
                  q.add(currentNode.left);
              }
              if(currentNode.right != null){
                  q.add(currentNode.right);
              }
        }
        ans.add(0,list);
    }
   return ans;
  }
}
