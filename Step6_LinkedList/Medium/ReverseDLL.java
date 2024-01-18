import java.util.*;

public class ReverseDLL {
    static Node head;

    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int value){
            data = value;
        }
    }
    static void insert(int value){
        Node new_node = new Node(value);
        if(head == null){
            head = new_node;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        new_node.prev = temp;
        temp.next = new_node;
    }
    static void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print("" + temp.data + "->");
            temp=temp.next;
        } 
        System.out.println("null");
    }
/* 
    Illustrate the working of code by doing dry run on above linked list.
1.	Check edge case: If linkedlist is empty i.e. head==null than return.
2.	There are two pointers temp and curr pointing to head.
3.	temp is used to iterate over the elements of linked list and curr is used to access current node and exchange its next and prev fields. After exchange of fields is done curr will point to next node i.e.temp.
4.	Repeat step-2 till second last node i.e. temp.next !=null.
5.	Set prev field of last node to null and its next field to curr which will be the second last node. Make the last node as head node.
*/
    static void reverseDLL(){
        //Edge case if our linked list is empty Or list with only one node
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        Node curr = head;
        while(temp.next != null){
            temp = temp.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = temp;
        }
        curr.next = curr.prev;
        curr.prev = null;
        head = curr;
    }

    static void reverse(){
        // Ede case: If linkedlist is empty or contains only one 
        if(head==null || head.next==null){
            return;
        }
        Node temp = null;
        Node curr = head;

        // swap next and prev fields for all nodes of doubly linked list
        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if(temp!=null){
            head = temp.prev;
        }
    }

    static void reverseDLL1(){
        Stack<Integer> stack= new Stack<Integer>();
        //Step1:
        Node temp = head;
        while(temp!=null){
            stack.push(temp.data);
            temp = temp.next;
        }
        //Step2
        temp=head;
        while(temp!=null){
            temp.data = stack.pop();
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        insert(10);        
        insert(20);
        insert(30);
        insert(40);
        insert(50);

        System.out.print(" Original LinkedList: ");
        printList();

        System.out.print(" Reversed LinkedList: ");
        reverseDLL1();
        printList();
    }
}
