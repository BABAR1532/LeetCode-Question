import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node() {}
}

public class stackBst {

    // Insert in Node
    public static Node insert(int val, Node root) {
        root = insertBst(root, val);
        return root;
    }

    // Helper to insert in root

    public static Node insertBst(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.val > val) {
            root.left = insertBst(root.left, val);
        } else if (root.val < val) {
            root.right = insertBst(root.right, val);
        }

        return root;
    }

    // Inoder Traversal
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(20, root);
        root = insert(23, root);
        root = insert(4, root);
        root = insert(3, root);

        // inorder(root);

        Stack<Node> stack = new Stack<>();

        Node nextSmall = root;

        // Pushing all the elements

        // while (node != null) {
        //     stack.push(node);
        //     node = node.left;
        // }

        // Starting printing (BST Iterative)
        while (!stack.isEmpty() || nextSmall != null) {
            while (nextSmall != null) {
                stack.push(nextSmall);
                nextSmall = nextSmall.left;
            }

            Node currentNode = stack.pop();

            System.out.print(currentNode.val + " ");

            nextSmall = currentNode.right;
        }
    }
}
