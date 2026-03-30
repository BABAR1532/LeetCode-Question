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

    public static boolean dfs(TreeNode root, int k, HashSet<Integer> map) {
        if (root == null) return false;

        int requiredValue = k - root.val;

        if (map.contains(requiredValue)) {
            return true;
        }

        return dfs(root.left, k, map) && dfs(root.right, k, map);
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map = new HashSet<>();

        map.put(root.val);

        return dfs(root, k, map);
    }
}

// Bst Iterative

class Solution {

    // Bst Iterative ascending Order
    public static void popSmall(Stack<TreeNode> incOrder, TreeNode small) {
        while (small != null) {
            incOrder.push(small);
            small = small.left;
        }
    }

    // Bst Iterative descending Order
    public static void popLarge(Stack<TreeNode> decOrder, TreeNode large) {
        while (large != null) {
            decOrder.push(large);
            large = large.right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> incOrder = new Stack<>();
        Stack<TreeNode> decOrder = new Stack<>();

        popSmall(incOrder, root);
        popLarge(decOrder, root);

        TreeNode smallOne = incOrder.pop();
        popSmall(incOrder, smallOne.right);

        TreeNode bigOne = decOrder.pop();
        popLarge(decOrder, bigOne.left);

        while (smallOne != bigOne) {
            if (smallOne.val + bigOne.val == k) {
                return true;
            } else if (smallOne.val + bigOne.val > k) {
                // May be that number is not present
                if (decOrder.isEmpty()) return false;

                bigOne = decOrder.pop();
                popLarge(decOrder, bigOne.left);
            } else if (smallOne.val + bigOne.val < k) {
                if (incOrder.isEmpty()) return false;

                smallOne = incOrder.pop();
                popSmall(incOrder, smallOne.right);
            }
        }

        return false;
    }
}
