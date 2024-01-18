package Step6_LinkedList.Singly_LinkedList;
import java.util.*;

public class Singly_LinkedList {
    static Node head;
    
    // Create node class
    static class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }

    void insertAtBeginning(int value){
        // Works in both the cases whether the linkedlist is empty or non-empty
        Node new_Node = new Node(value);
        new_Node.next = head; //Remember: Always modify new_node's next field first
        head = new_Node; 
    }
    /*Time Complexity: */

    void insertAtEnd(int value){
        Node new_node = new Node(value);
        //Edge case: If linkedlist is empty, make new_node as head node
        if(head == null){
            head = new_node;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new_node;
        return;
    }
    /*Time Complexity: */

    void insertAfterPosition(int loc, int value){
        Node temp = head;
        Node prev = head;
        for(int i=1; i<=loc; i++){
            prev=temp;
            if(temp==null){
                System.out.println("Invalid position!");
                return;
            } 
            temp=temp.next;  
        }
        Node new_node = new Node(value);
        new_node.next = temp; //Remember: Always modify new_node's next field first
        prev.next = new_node;
    }
    /*Time Complexity: */

    void deleteFirst(){
        /*Edge case: If linkedlist is empty */
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }
    /*Time Complexity: */

    void deleteLast(){
        /*Edge case1: If linkedlist is empty */
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        /*Edge case2: If there is only one node in linkedlist */
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;
    }
    /*Time Complexity: */

    void deleteAtPosition(int pos){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        Node prev = head;
        for(int i=1; i<pos; i++){
            prev=temp;
            temp=temp.next;  
        }
        prev.next=temp.next;
    }
    // Delete given node without accessing head
    void deleteGivenNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
    /*Time Complexity: */

    void printList(){
        Node temp = head;
        System.out.print(" List contains: ");
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }
    /*Time Complexity: */

    int lengthOfLinkedList(){
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    /*Time Complexity: */

    static boolean search(int value){
        Node temp = head;
        while(temp!=null){
            if(temp.data == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    /*Time Complexity: */

    public static void main(String[] args) {
        // Only a static method can call other static methods directly  within same class. But can not access non-static members directly.

        Singly_LinkedList sll = new Singly_LinkedList();
        Scanner sc = new Scanner(System.in);

        sll.insertAtBeginning(30);
        sll.insertAtBeginning(20);
        sll.insertAtBeginning(10);
        System.out.println("\n After inserting at beginning: ");
        sll.printList();
        
        sll.insertAtEnd(50);        
        sll.insertAtEnd(60);
        System.out.println("\n After inserting at end: ");
        sll.printList();
       
        // printList(); //ErrorCannot make a static reference to the non-static method printList()
        
        System.out.print("\n Enter location after which you want to insert: ");
        int loc = sc.nextInt();
        sll.insertAfterPosition(loc, 40);
        System.out.println("\n After insertion : ");
        sll.printList();

        sll.deleteFirst();
        System.out.println("\n After deleting first node: ");
        sll.printList();

        sll.deleteLast();
        System.out.println("\n After deleting last node: ");
        sll.printList();

        System.out.print("\n Enter deleting node position : ");
        int pos = sc.nextInt();
        sll.deleteAtPosition(pos);
        System.out.println("\n After deleting node: ");
        sll.printList();

        int len = sll.lengthOfLinkedList();
        System.out.println("\n Length of linkedlist: " + len);

        System.out.print(" Enter value to searched: ");
        int value = sc.nextInt();
        if(search(value)) 
            System.out.println(" Data found😉!!");
        else 
            System.out.println(" Data not found😔!!");
        sc.close();
    }
}
