package Step6_LinkedList.Singly_LinkedList;

public class DummyList {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }
    static Node insertAtEnd(Node head, int value){
        Node newNode = new Node(value);
        if(head==null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    static void printList(Node head){
        Node temp = head;
        // System.out.print(" List contains: ");
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);             
        head = insertAtEnd(head, 6);   

        System.out.print(" Original Linked List: ");
        printList(head);

        System.out.print(" Modified Linked List: ");

        printList(head);
    }

    
}
