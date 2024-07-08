import java.util.ArrayList;

public class OddEven {
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

        // -----------------Solution1:Using array data structure------------------------- 
        static Node segregateOddEven1(Node head){
            /*Edge case: If list is empty or has single node */
            if(head==null || head.next==null){
                return head;
            }
            ArrayList<Integer> arr= new ArrayList<>();
            /* Step1: Segregating odd-indexed node */
            Node temp = head;
            while(temp!=null && temp.next!=null){
                arr.add(temp.data);
                temp = temp.next.next;
            }
            // If array is odd-length, the condition temp.next!=null tends to skip the last node
            if(temp!=null){
                arr.add(temp.data);
            }
            /* Step2: Segregating even-indexed node */
            temp = head.next;
            while(temp!=null && temp.next!=null){
                arr.add(temp.data);
                temp = temp.next.next;
            }
            // If array is even-length, the condition temp.next!=null tends to skip the last node
            if(temp!=null){
                arr.add(temp.data);
            }

            /* Step3: Replacing data */
            temp=head;
            int i=0;
            while(temp!=null){
                temp.data = arr.get(i);
                temp = temp.next;
                i+=1;
            }
            return head;
        }
        // -----------------Solution2:Changing links-----------------------

        static Node segregateOddEven2(Node head){
            // System.out.println("-----------Solution2--------------");
            /*Edge case: If list is empty or has single node */
            if(head==null || head.next==null){
                return head;
            }
            Node odd=head, even=head.next, evenHead=head.next;
            /*Condition: we need to check for even pointer because even ptr will be ahead of odd ptr. So if even ptr has not reached the end odd will also have not reached the end. */
            while(even!=null && even.next!=null){
                odd.next = odd.next.next;
                even.next = even.next.next;

                odd=odd.next;
                even=even.next;
            }
            odd.next = evenHead;
            return head;
        }
        
        public static void main(String[] args) {
            Node head = null;
            head = insertAtEnd(head, 20);
            head = insertAtEnd(head, 40);
            head = insertAtEnd(head, 60);
            head = insertAtEnd(head, 80);
            head = insertAtEnd(head, 100);             
            head = insertAtEnd(head, 70);   
            System.out.print(" Original list:   ");
            printList(head);

            head = segregateOddEven2(head);
            System.out.print(" Segregated list: ");
            printList(head);

        }
}
