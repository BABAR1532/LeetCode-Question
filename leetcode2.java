import java.util.*;

class Node{

   int data;
   Node next;

   Node(int data){
    this.data  = data;
    next = null;
   }

}

class List{

 Node root = null;

 List(){} // Complusary

 List(Node value){
   this.root = value;
 }


 public void insert(int data){

  Node newNode = new Node(data);

  if(root == null){
     root = newNode;
     return;
  }

  Node temp = root;

  while(temp.next != null){

     temp = temp.next;

  }

  temp.next = newNode;

 }


 // Printing node
 public void print(){


  if(root == null) return;

  Node temp = root;

  while(temp != null){


   if(temp.next == null){
      System.out.println(temp.data);
      return;
    }

   System.out.print(temp.data + "->");
   temp = temp.next;
  }

 }

}


public class leetcode2{

 public static void main(String[] args){

   Scanner scan  = new Scanner(System.in);

   List l1 = new List();
   List l2 = new List();

  System.out.println("Enter the Elements of first list: (-1) Exist");

  while(true){

    int data = scan.nextInt();

    if(data == -1) break;

    l1.insert(data);

  }

   System.out.println("Enter the Elements of Second list: (-1) Exist");

  while(true){

    int data = scan.nextInt();

    if(data == -1) break;

    l2.insert(data);

  }

  Node ans = addTwo(l1.root,l2.root);

  List ansList = new List(ans);

  ansList.print();

 }


 public static Node addTwo(Node l1, Node l2){

  if(l1 == null) return l2;
  if(l2 == null) return l1;

  Node dummy = new Node(-1);

  Node current = dummy;

  int carry = 0;


  while(l1 != null || l2 != null || carry != 0){


    int a = l1 != null ? l1.data : 0;
    int b = l2 != null ? l2.data : 0;

    int ans = a + b + carry;

    int value = ans % 10;

    carry = ans / 10;

    current.next = new Node(value);
    current = current.next;

    if(l1 != null) l1 = l1.next;
    if(l2 != null) l2 = l2.next;
  }


  return dummy.next;

 }

}
