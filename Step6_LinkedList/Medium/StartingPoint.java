// package Step6_LinkedList.Medium;
import java.util.*;

public class StartingPoint {
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
        System.out.print("\n List contains: ");
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

        System.out.print("\n List containing cycle: ");
        while(cnt<=12){
            System.out.print(temp.data + "->");
            temp=temp.next;
            cnt++;
        }
    }

    // 1. Using Hashing
  static Node startingPoint1(Node head){
    Node temp = head;
    HashMap<Node,Integer> map = new HashMap<>(); 
    while(temp!=null){
        if(map.containsKey(temp)){
            return temp;
        }
        map.put(temp,1);
        temp=temp.next;
    }
    return null;
  }

    // 2. Using Hare-Tortoise approach
    static Node startingPoint2(Node head){
        Node fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                Node entry = head;
                while(slow!=entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
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
        Node startNode = startingPoint2(head);
       if(startNode != null){
        System.out.println(" Starting point of the cycle: "+ startNode.data);
       } else{
        System.out.println(" No cycle detected.");
       }

        head = createCycle(head, 3);
        printList2(head);

       startNode = startingPoint2(head);
       if(startNode != null){
        System.out.println("\n Starting point of the cycle: "+ startNode.data);
       } else{
        System.out.println("\n No cycle detected.");
       }
    }
}
