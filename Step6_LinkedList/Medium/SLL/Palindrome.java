import java.util.Stack;

public class Palindrome {
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
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }

    static boolean isPalindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp!=null){
            stack.push(temp.data);
            temp = temp.next;
        }
        // System.out.println(stack);
        temp=head;
        while(temp!=null){
            if(temp.data!=stack.peek()){
                return false;
            }
            stack.pop();
            temp=temp.next;
        }
        return true;
    }

      // Recursive approach
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
    static boolean isPalindrome2(Node head){
        Node slow=head, fast=head;
        while(fast.next.next!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        Node newHead = reverse(slow.next);
        Node first = head;
        Node second = newHead;
        while(second!=null){
            if(first.data!=second.data){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 1);             
        System.out.print(" Original List: ");
        printList(head);

        if(isPalindrome2(head))
            System.out.println(" Yes, Linked list is palindrome! ");
        else
            System.out.println(" No, Linked list is not palindrome! ");
    }
}
