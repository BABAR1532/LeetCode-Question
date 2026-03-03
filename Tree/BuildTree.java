import java.util.*;

class Node {

    int value;
    Node left;
    Node right;

    Node() {}

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BuildTree {

    // Insert in Node
    public static Node insert(Node root, int value) {
        Queue<Node> q = new LinkedList<>();

        if (root == null) {
            Node newNode = new Node(value);
            root = newNode;
            return root;
        }

        q.add(root);

        while (!q.isEmpty()) {
            Node currentNode = q.remove();

            if (currentNode.left == null) {
                Node newNode = new Node(value);
                currentNode.left = newNode;
                return root;
            } else if (currentNode.right == null) {
                Node newNode = new Node(value);
                currentNode.right = newNode;
                return root;
            } else {
                q.add(currentNode.left);
                q.add(currentNode.right);
            }
        }

        return root;
    }

    // Traversal level Order
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node newNode = q.peek();

            System.out.print(newNode.value + "->");

            if (newNode.left != null) {
                q.add(newNode.left);
            }

            if (newNode.right != null) {
                q.add(newNode.right);
            }

            q.poll();
        }
    }

    public static void main(String[] args) {
        Node root = null;

        // Insertion
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 5);
        root = insert(root, 6);

        // Traversal(level Order)
        levelOrder(root);
    }
}
