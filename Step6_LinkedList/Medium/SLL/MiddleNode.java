
public class MiddleNode {
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
        System.out.print(" List contains: ");
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }

    static Node middleNode1(Node head){
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp=head;
        System.out.println("(count/2): (" +  count + "/2) " + (count/2));
        for(int i=1; i<=(count/2); i++){
            temp = temp.next;
        }
        return temp;
    }


    static Node middleNode2(Node head){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next; // Move one step at a time
            fast = fast.next.next; // Move two steps at a time
        } 
        return slow;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);        
        // head = insertAtEnd(head, 60);

        printList(head);
        Node middle = middleNode1(head);
        System.out.println(" The data of middle node: " + middle.data);
        
    }
}
