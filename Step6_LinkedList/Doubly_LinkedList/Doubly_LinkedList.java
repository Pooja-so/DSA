package Step6_LinkedList.Doubly_LinkedList;
import java.util.*;

public class Doubly_LinkedList {
    static Node head;

    static class Node{
        int data;
        Node next;
        Node prev;
        // Constructor to create new node
        // next and prev are by default initialized to null
        Node(int value){
            data = value;
        }
    }

    static void insertAtBeginning(int value){
        Node new_node = new Node(value);
        /* If list is empty */ 
        if(head==null){
            head = new_node;
            return;
        }
        /*If list is not empty */ 
        new_node.next = head; //Remember: Always modify new_node's field first
        head.prev = new_node;
        head = new_node;
    }

    static void insertAtEnd(int value){
        Node new_node = new Node(value);
        /*If list is empty */ 
        if(head==null){
            head = new_node;
            return;
        }
        /*If list is not empty */ 
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        new_node.prev = temp;//Remember: Always modify new_node's field first
        temp.next = new_node;
    }

    static void insertAfter(Node prev_node, int value){
        if(prev_node==null){
            System.out.println("The given previous node cannot be Null");
            return;
        }
        Node new_node = new Node(value);
        //Remember: Always modify new_node's field first
        new_node.prev = prev_node;
        new_node.next = prev_node.next;
        prev_node.next = new_node;
        prev_node.next.prev = new_node;
    }

    static void insertBefore(Node next_node, int value){
        if(next_node==null){
            System.out.println("The given next node cannot be Null");
            return;
        }
        Node new_node = new Node(value);
        //Remember: Always modify new_node's field first
        new_node.prev = next_node.prev;
        new_node.next = next_node;
        next_node.prev.next = new_node;
        next_node.prev = new_node;
    }

    static void deleteFirst(){
        /*Case1: If list is empty */ 
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        /*Case2: If only one node left */ 
        if(head.next==null){
            head=null;
        }
        /*Case3: If more than one nodes are available*/
        head=head.next; // Make second node as head node
        head.prev = null; //Set previous field of second node null
    }

    static void deleteLast(){
        /*Case1: If list is empty */ 
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        /*Case2: If only one node left */ 
        if(head.next==null){
            head=null;
        }
        /*Case3: If more than one nodes are available*/
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    static void deleteAfter(Node prev_node){
         /*Case1: If list is empty */ 
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        /*Case2: If only one node left */ 
        if(head.next==null){
            head=null;
        }
        if(prev_node==null || prev_node.next==null){
            System.out.println("The given previous node cannot be Null");
            return;
        }
        prev_node.next = prev_node.next.next;
        prev_node.next.prev = prev_node;
    }

    static void deleteBefore(Node next_node){
         /*Case1: If list is empty */ 
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        /*Case2: If only one node left */ 
        if(head.next==null){
            head=null;
        }
       if(next_node==null || next_node.next==null){
            System.out.println("The given previous node cannot be Null");
            return;
        }
        next_node.prev = next_node.prev.prev;
        next_node.prev.next  = next_node;
    }

    static void deleteGivenData(int value){
        /*Case1: If list is empty */ 
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        /*Case2: If only one node left */ 
        if(head.next==null){
            head=null;
        }
        // search node with given value
        Node temp = head;
        int flag = 0;
        while(temp != null){
            if(temp.data == value){
                flag=1;
                break;
            }
            temp = temp.next;
        }
        // case1: If value not found 
        if(flag==0){
            System.out.println("Given data not found.");
            return;
        }
        // case2: If value matches with first node 
        if(temp == head){
            head = head.next;
            head.prev = null;
            return;
        }
        // case3: If value matches with last node
        if(temp.next == null){
             temp.prev.next = null;
        }
        // case4: If value matches with middle node
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Node with value " + value + " deleted successfully!!"); 

    }

    static void printList(){
        Node temp = head;
        System.out.print("List contains: ");
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        } 
        System.out.println("null");
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        insertAtBeginning(30);        
        insertAtBeginning(20);
        insertAtBeginning(10);
        System.out.println("\n After inserting at beginning: ");
        printList();

        insertAtEnd(50);        
        insertAtEnd(60);
        System.out.println("\n After inserting at end: ");
        printList();

        insertAfter(head.next.next, 40);
        System.out.println("\n After inserting at 4th position(after 3rd position): ");
        printList();

        insertBefore(head.next, 300);
        System.out.println("\n After inserting at 2nd (before 3rd position): ");
        printList();

        deleteFirst();
        System.out.println("\n After deleting first node: ");
        printList();

        deleteLast();
        System.out.println("\n After deleting last node: ");
        printList();

        deleteAfter(head.next);
        System.out.println("\n After deleting third node: ");
        printList();

        deleteBefore(head.next.next);
        System.out.println("\n After deleting second node: ");
        printList();

        System.out.print(" Enter value to delete: ");
        int value = Integer.parseInt(sc.nextLine());
        deleteGivenData(value);
        System.out.println("\n After deleting " + value + ": ");
        printList();

        sc.close();
    }
}
