
public class DeleteOccurrencesOfKey{
    static class Node{
        int data;
        Node next;
        Node prev;
        // Constructor to create new node
        // next and prev are by default initialized to null
        Node(int value){
            next=null;
            prev=null;
            data = value;
        }
    }
    static Node insert(Node head, int value){
        Node new_node = new Node(value);
        /*If list is empty */ 
        if(head==null){
            head = new_node;
            return head;
        }
        /*If list is not empty */ 
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        new_node.prev = temp;//Remember: Always modify new_node's field first
        temp.next = new_node;
        return head;
    }
    static void printList(Node head){
        Node temp = head;
        while(temp!=null && temp.next!=null){
            System.out.print(temp.data + "<->");
            temp=temp.next;
        } 
        if(temp!=null)  System.out.println(temp.data+"->null");
        else System.out.println("->null");
    }

    static Node deleteOccurrencNode(Node head, int key){
        Node temp = head;
        while(temp!=null){
            if(temp.data==key){
                if(temp==head)
                    head=head.next;
                if(temp.prev!=null)
                    temp.prev.next = temp.next;
                if(temp.next!=null)
                    temp.next.prev=temp.prev;
                temp=temp.next;
            } else {
                temp=temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head,10);
        head = insert(head,4);
        head = insert(head,10);
        head = insert(head,10);
        head = insert(head,6);
        head = insert(head,10);

        System.out.print("Original DLL: ");
        printList(head);
        head=deleteOccurrencNode(head,10);
        System.out.print("Modified DLL: ");
        printList(head);
    }
}