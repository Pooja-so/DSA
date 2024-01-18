public class AddOneToNumber{
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
    static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    static Node addOneToNumber(Node head){
        /* Edge case: If list is empty or has only single node */
        if(head==null || head.next==null){
            return null;
        }
        head = reverse(head);
        Node temp=head;
        int carry=1; // As we need to add 1 to a number take initial carry as 1
        while(temp!=null){
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            if(carry==0)
                break;
            temp=temp.next;
        }
        head=reverse(head);
        if(carry!=0){
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Node head = null;
        // head = insertAtEnd(head, 9);
        // head = insertAtEnd(head, 9);
        // head = insertAtEnd(head, 9);
        // head = insertAtEnd(head, 9);

        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 9);


        System.out.print(" Original Linked List: ");
        printList(head);

        System.out.print(" Modified Linked List: ");
        head = addOneToNumber(head);
        printList(head);
    }

}