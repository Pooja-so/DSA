// package Step6_LinkedList.Medium;

import java.util.Stack;

public class ReverseSLL {
    static class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
        }
    }
    
    static Node insertAtEnd(Node head, int value){
        Node new_node = new Node(value);
        //Edge case: If linkedlist is empty, make new_node as head node
        if(head == null){
            head = new_node;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new_node;
        return head;
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }

    //Reversing data using Stack
    static Node reverseSLL1(Node head){
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
        return head;
    }

    // Iterative approach
    static Node reverseSLL2(Node head){
        if (head == null || head.next == null)
            return head;
        Node prev = null, next=null;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; 
    }

    // Recursive approach
     static Node reverseSLL3(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead = reverseSLL3(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 40);

        System.out.print(" Original LinkedList: ");
        printList(head);

        head = reverseSLL3(head);
        System.out.print(" Reversed LinkedList: ");
        printList(head);
    }
}
