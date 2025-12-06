
class Solution {
    public int minDepth(TreeNode root) {

         return recMin(root);

    }

    public static int recMin(TreeNode root){

       if(root == null){
           return 0;
       }

      if(root.left == null) return 1 + recMin(root.right);
      if(root.right == null) return 1 + recMin(root.left);


       return 1 + Math.min(recMin(root.left), recMin(root.right));
    }
}
