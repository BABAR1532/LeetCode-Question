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

    TreeNode FirstVio = null;
    TreeNode lastVio = null;
    TreeNode prev = null

    public  void inorder(TreeNode root, TreeNode FirstVio, TreeNode lastVio, TreeNode prev){

         if(root == null) return;

         inorder(root.left);

           if(prev != null && root.val < prev.val){
               if(FirstVio == null){
                   FirstVio = prev;
               }
               lastVio = root;
           }
          prev = root;

         inorder(root.right);
    }



    public void recoverTree(TreeNode root) {

        inorder(root);

        // Swapping
        int temp = FirstVio.val;
        FirstVio.val = lastVio.val;
        lastVio.val = temp;

    }
}
