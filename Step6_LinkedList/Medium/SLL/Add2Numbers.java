public class Add2Numbers {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }
    static Node insertAtEnd(Node head1, int value){
        Node newNode = new Node(value);
        if(head1==null){
            return newNode;
        }
        Node temp = head1;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head1;
    }
    static void printList(Node head1){
        Node temp = head1;
        // System.out.print(" List contains: ");
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }

    static Node addNumbers(Node head1, Node head2){
        Node temp1=head1, temp2=head2;
        Node dummyNode = new Node(-1);
        Node curr=dummyNode;
        int carry = 0;
        
        while(temp1!=null || temp2!=null){
            int sum=carry;
            if(temp1!=null)
                sum += temp1.data;
            if(temp2!=null)
                sum += temp2.data;

            Node newNode = new Node(sum % 10); //Last digit
            carry = sum / 10; //First digit

            curr.next = newNode;
            curr = curr.next;

            if(temp1!=null) temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
        }    
        if(carry!=0){
            Node newNode = new Node(carry);
            curr.next = newNode;
        } 
        return dummyNode.next;
    }
    
    public static void main(String[] args) {
        Node head1 = null;
        head1 = insertAtEnd(head1, 4);
        head1 = insertAtEnd(head1, 5);
        head1 = insertAtEnd(head1, 9);
        head1 = insertAtEnd(head1, 9);
        System.out.print(" List1 : ");
        printList(head1);

        Node head2 = null;
        head2 = insertAtEnd(head2, 3);
        head2 = insertAtEnd(head2, 5);
        System.out.print(" List2 : ");
        printList(head2);

        System.out.println(" Sum List: ");
        printList(addNumbers(head1, head2));
    }
}
