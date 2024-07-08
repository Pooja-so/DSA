
public class RemoveDuplicates{
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

    static Node removeDuplicate(Node head){
        /* Edge case: If list is empty or has only single node */
        if(head==null || head.next==null){
            return head;
        }
        //nextnode is the first element that will be not equal to the currNode data
        Node currNode = head;
        while(currNode!=null && currNode.next!=null){
            Node nextNode = currNode.next;
            /*Move nextNode till the data is equal. Note: stops if it encounter null as there will be no duplicates at the end of the DLL*/
            while(nextNode!=null && nextNode.data==currNode.data){
                nextNode = nextNode.next;
            }
            //when nextNode.data!=currNode.data or nextNode==null
            currNode.next = nextNode;
            if(nextNode!=null){
                nextNode.prev = currNode;
            }
            currNode=nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head,1);
        head = insert(head,1);
        head = insert(head,1);
        head = insert(head,2);
        head = insert(head,3);
        head = insert(head,3);
        head = insert(head,4);

        System.out.print("Original DLL: ");
        printList(head);
        System.out.print("Modified DLL: ");
        head=removeDuplicate(head);
        printList(head);
    }
}