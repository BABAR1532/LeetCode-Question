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

    // Creating pair
    class Pair{

        TreeNode node;
        int depth;

        Pair(TreeNode p, int height){
            this.node = p;
            this.depth = height;
        }
    }


    // Method  for dfs
     public Pair dfs(TreeNode root){
         if(root == null) return new Pair(null,0);

         Pair left = dfs(root.left);
         Pair right = dfs(root.right)


         if(left.depth > right.depth){
             return new Pair(left,left.depth + 1);
         }

         else if(right.depth > left.depth){
             return new Pari(right,right.depth+1);
         }

         else{
             return new Pair(root,left.depth+1);
         }
     }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
}
