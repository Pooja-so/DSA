import java.util.HashSet;

public class DetectLoop {
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
            head = newNode;
            return head;
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
        System.out.print(" List contains: ");
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }

    static Node createCycle(Node head, int pos){
        Node temp = head, curr = head;
        // Traverse till last node
        while(temp.next != null){
             temp = temp.next;
        }
        // Traverse till node you want to create the starting point of the loop
        while(pos>1){
            curr = curr.next;
            pos--;
        }
        temp.next = curr;
        return head;
    }

    static void printList2(Node head){
        Node temp = head;
        int cnt=1;

        System.out.print(" List containing cycle: ");
        while(cnt<=12){
            System.out.print(temp.data + "->");
            temp=temp.next;
            cnt++;
        }
    }

    // 1. Using Hashing
    static boolean detectLoop1(Node head){
        Node temp = head;
        HashSet<Node> set = new HashSet<Node>();
        while(temp != null){
            if(set.contains(temp)){
                return true;
            }
            set.add(temp);
            temp = temp.next;
        } 
        return false;
    }

    // 2. Using Hare-Tortoise approach
    static boolean detectLoop2(Node head){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);             
        head = insertAtEnd(head, 6);   
          

        printList1(head);

        head = createCycle(head, 3);
        // printList2(head);

        if(detectLoop2(head))
            System.out.println(" List contains cycle. ");
        else 
            System.out.println(" List did not contains cycle. ");

    }
}
