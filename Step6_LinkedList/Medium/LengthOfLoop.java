
import java.util.*;

public class LengthOfLoop {
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
    static int lengthOfLoop1(Node head){
        Node temp = head;
        int timer=1;
        HashMap<Node,Integer> map = new HashMap<>(); 
        while(temp != null){
            if(map.containsKey(temp)){
                return(timer - map.get(temp));
            }
            map.put(temp,timer);
            timer++;
            temp = temp.next;
        } 
        return 0;
    }

    // 2. Using Hare-Tortoise approach
    static int findLength(Node slow){
        int len=1;
        Node temp=slow.next;
        while(temp!=slow){
            len++;
            temp=temp.next;
        }
        return len;
    }
    static int lengthOfLoop2(Node head){
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return findLength(slow);
        }
        return 0;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 5);             
        head = insertAtEnd(head, 6);   
          

        printList1(head);

        head = createCycle(head, 3);
        printList2(head);

       System.out.println("\n Length of list: " + lengthOfLoop2(head));
    }
}
