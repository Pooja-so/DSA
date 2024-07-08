import java.util.HashSet;

public class IntersectionPoint {
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
        while(temp.next!=null){
            System.out.print(temp.data + "<->");
            temp=temp.next;
        } 
        System.out.println(temp.data+"->null");
    }
    /*1. Brute force: using two nested loops */
    static Node intersectionPoint1(Node head1, Node head2){
        Node temp1=head1; 
        while(temp1!=null){
            Node temp2=head2;
            while(temp2!=null){
                if(temp1==temp2)
                    return temp1;
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return null;
    }
    /*2.1 Better Approach: Using hashing */
    static Node intersectionPoint2(Node head1, Node head2){
        HashSet<Node> set = new HashSet<>();
        Node temp1=head1;
        while(temp1!=null){
            set.add(temp1);
            temp1=temp1.next;
        }
        Node temp2=head2;
        while(temp2!=null){
            if(set.contains(temp2))
                return temp2;
            temp2=temp2.next;
        }
        return null;
    }
    /*2.2 Better Approach: Using Comparision */
    static int count(Node head){
        Node temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    static Node getNode(Node head1, Node head2){
        System.out.println("solution3");
        int c1 = count(head1);
        int c2 = count(head2);
        if(c1>c2){
            int d = c1 - c2;
            return intersectionPoint3(d,head1, head2);
        } else {
            int d = c2 - c1;
            return intersectionPoint3(d, head2, head1);
        }
    }
    static Node intersectionPoint3(int d, Node start1, Node start2 ){
        for(int i=1; i<=d; i++){
            if(start1==null)
                return null;
            start1 = start1.next;
        }
        while(start1!=start2){
            start1 = start1.next;
            start2 = start2.next;
        }// loop will terminate when start1==start2 i.e. common node in case of YLL or reaches null in case of linear LL.
        return start1;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head,3);
        head = insert(head,6);
        head = insert(head,9);
        head = insert(head,12);
        head = insert(head,15);
        head = insert(head,30);

        Node head1 = head;
        head = head.next.next.next.next;

        Node head2 = null;
        head2 = insert(head2,15);
        head2 = insert(head2, 10);
        head2.next.next = head;

        System.out.println("Original DLL: ");
        System.out.print("Linked List1: ");
        printList(head1);
        System.out.print("Linked List2: ");
        printList(head2);

        Node intersectNode = getNode(head1, head2);
        if(intersectNode!=null)
            System.out.println("Intersecting node: "+ intersectNode.data);
        else
            System.out.println("There is no interecting node between the two lists.");
    }
    
}
