import java.util.*;

public class FindPairsWithGivenSum {
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

    public static List<List<Integer>> createListOfLists() {
        List<List<Integer>> listOfLists = new ArrayList<>();

        // Creating and adding the first list
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        listOfLists.add(list1);

        // Creating and adding the second list
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        listOfLists.add(list2);

        // You can add more lists as needed

        return listOfLists;
    }

    static List<List<Integer>> findPairs1(Node head, int sum_value){
        List<List<Integer>> pairs = new ArrayList<>();
        Node first = head;
        while(first!=null ){
            Node second = first.next;
            while(second!=null && ((first.data + second.data) <= sum_value)){
                if((first.data + second.data) == sum_value){
                    List<Integer> list = new ArrayList<>();
                    list.add(first.data);
                    list.add(second.data);
                    pairs.add(list);
                }
                second = second.next;
            }
            first = first.next;
        }
        return pairs;
    }

   
    static Node tail(Node head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
    static List<List<Integer>> findPairs2(Node head, int sum_value){
        List<List<Integer>> pairs = new ArrayList<>();
        Node start = head;
        Node end = tail(head);
        while(start.data < end.data){
            if((start.data + end.data) == sum_value){
                List<Integer> list = new ArrayList<>();
                list.add(start.data);
                list.add(end.data);
                pairs.add(list);
                start = start.next;
                end = end.prev;
            } else if((start.data + end.data )< sum_value){
                start = start.next;
            } else {
                end = end.prev;
            }
        }
        return pairs;
    }


    public static void main(String[] args) {
        Node head = null;
        head = insert(head,1);
        head = insert(head,2);
        head = insert(head,4);
        head = insert(head,5);
        head = insert(head,7);
        head = insert(head,8);
        head = insert(head,10);

        List<List<Integer>> pairs = new ArrayList<>();

        System.out.print("Original DLL: ");
        printList(head);

        int sum_value = 15;
        System.out.println("Pairs with sum " + sum_value);
        pairs=findPairs2(head, sum_value);

        if(pairs.size()==0){
            System.out.println("No pair with given sum exist");
        }else{
            for(List<Integer> pair: pairs){
                System.out.println(pair);
            }
        }
        
    }
}
