public class Sort0s_1s_2s {
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
    static Node sortNodes1(Node head){
        Node temp=head;
        /*Step1: storing the no. of 0s, 1s and 2s*/
        int cnt0=0, cnt1=0, cnt2=0;
        while(temp!=null){
            if(temp.data==0)
                cnt0++;
            else if(temp.data==1)
                cnt1++;
            else
                cnt2++;
            temp=temp.next;
        }
        /*Step2: Replacing data */
        temp=head;
        while(temp!=null){
            if(cnt0!=0){
                temp.data=0;
                cnt0--;
            }else if(cnt1!=0){
                temp.data=1;
                cnt1--;
            }else{
                temp.data=2;
                cnt2--;
            }
            temp=temp.next;
        }

        return head;
    }
    static Node sortNodes2(Node head){
        /* Edge case: If list is empty or has one node */
        if(head==null || head.next==null){
            return head;
        }
        /* Three Dummy Nodes */
        Node zeroHead = new Node(-1); 
        Node oneHead  = new Node(-1); 
        Node twoHead  = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=temp;
            }else if(temp.data==1){
                one.next=temp;
                one=temp;
            }else{
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }
        zero.next = (oneHead.next!=null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        Node newHead = zeroHead.next; 
        return newHead;
    }
    
    static void printList1(Node head){
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
        head = insertAtEnd(head, 0);
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 0);             
        head = insertAtEnd(head, 2);   
        head = insertAtEnd(head, 1);   

        System.out.print(" Original List: ");
        printList1(head);

        head=sortNodes2(head);
        System.out.print(" Sorted List: ");
        printList1(head);
    }
}
