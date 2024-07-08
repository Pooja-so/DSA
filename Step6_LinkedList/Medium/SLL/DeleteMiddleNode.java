public class DeleteMiddleNode {
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
    static Node deleteMiddleNode(Node head){
        /* Edge case: If list is empty or has only single node */
        if(head==null || head.next==null){
            return null;
        }
        Node temp = head;
        int count=0;
        /*Step1: Count the nodes */
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        /*Step2: Traverse till node before the middle node */
        temp=head;
        for(int i=1; i<(count/2); i++){
            temp=temp.next;
        }
        /*Step3: Update the link and delte the node */
        temp.next = temp.next.next;
        return head;
    }
    static Node deleteMiddleNode2(Node head){
        /* Edge case: If list is empty or has only single node */
        if(head==null || head.next==null){
            return null;
        }
        /*As we want the node before the middle node, we will skip one step of slow ptr by initializing fast ptr with third node ahead instead of head node.*/
        Node slow=head, fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        /*Step3: Link the previous node to the node after the middle node  */
        slow.next=slow.next.next;
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
    
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        // head = insertAtEnd(head, 5);             
        // head = insertAtEnd(head, 6);             
        System.out.print(" Original list:  ");
        printList(head);

        head = deleteMiddleNode2(head);
        if(head==null){
            System.out.println(" Empty list ");
        } else {
            System.out.print(" Modified list:  ");
            printList(head);
        }
    }
}
