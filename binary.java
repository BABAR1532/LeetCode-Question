import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Binary {

    // Insertion in binary tree
    public static Node insertNode(int data, Node root) {
        Queue<Node> q = new LinkedList<>();

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return root;
        }

        // If node is not root
        q.add(root);

        while (!q.isEmpty()) {
            // Getting top value
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                q.add(temp.right);
            }
        }

        return root;
    }

    // Traversal
    public static void traversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node currentValue = q.poll();

            System.out.print(currentValue.data + " ");

            if (currentValue.left != null) {
                q.add(currentValue.left);
            }

            if (currentValue.right != null) {
                q.add(currentValue.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = null;

        root = insertNode(4, root);
        root = insertNode(6, root);
        root = insertNode(8, root);
        root = insertNode(14, root);
        root = insertNode(34, root);

        System.out.println("Traversal: ");
        traversal(root);
    }
}
