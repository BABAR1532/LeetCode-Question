import java.util.*;

class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class llStructure {

    public static Node insert(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // Inserting int last position
        temp.next = newNode;

        return Node;
    }

    public static void traverse(Node head) {
        if (head == null) return;

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Node head = null;

        while (true) {
            int data = scan.nextInt();

            if (data == -1) break;

            head = insert(head, data);
        }

        // Printing later
        traverse(head);
    }
}
