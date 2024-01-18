public class RemoveNthNode {
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
    static void printList1(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }
    static int countNode(Node head){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    static Node removeNode(Node head, int N){
        /*Edge case: If list is empty or has single node */
        if(head==null || head.next==null){
            return null;
        }
        int count = countNode(head);
        if(count==N){
            return head.next;
        }
        int res = count-N;
        Node temp = head;
        while(res>1){
            temp = temp.next;
            res--;
        }
        temp.next = temp.next.next;
        return head;
    }

    static Node removeNode2(Node head, int n){
        System.out.println("-------------------");
        /*Edge case: If list is empty or has single node */
        if(head==null || head.next==null){
            return null;
        }
        Node fast=head, slow=head;
        /* Step1: Move fast pointer to (n+1)th node */
        for(int i=1; i<=n; i++){
            fast=fast.next;
        }
        /* when n = length of LL */
        if(fast==null){
            return head.next;
        }
        /* Step2: Move fast and slow pointer on step till fast reaches the last node. At the end of this step slow pointer will be at node before the node to be deleted. */
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        /* Step3: Delete the node by updating links */
        slow.next = slow.next.next;
        return head;
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);             
        head = insertAtEnd(head, 6);             

        int N=2;
        // valid value of N: 
        if(N>=1 && N<=countNode(head)) {
            System.out.print("Original List: ");
            printList1(head);
            System.out.println("After deleting " + N + "th node from the back");
            System.out.print("Modified List: ");
            head=removeNode2(head,N);
            printList1(head);
        } else {
            System.out.print("Invalid value of N");
        }
    }
}
