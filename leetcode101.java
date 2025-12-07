class Solution {
    public boolean isSymmetric(TreeNode root) {

        TreeNode node1 = root.left;
        TreeNode node2 = root.right;

        // Recursive call
        return symRec(node1,node2);
    }

    public static boolean symRec(TreeNode node1, TreeNode node2){

       if(node1 == null && node2 == null){
          return true;
       }
       if(node1 == null || node2 == null) return false;


       // Condition
       if(node1.val != node2.val){
          return false;
       }


       return symRec(node1.left,node2.right) && symRec(node1.right,node2.left);

    }
}
