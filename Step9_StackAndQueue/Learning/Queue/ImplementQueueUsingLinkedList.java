package Queue;

// Time Complexity: O(1) for all operations
// Space complexity: O(size), where size is the size of queue

class QueueList{
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;
    private int size;
    public QueueList(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return (front==null);
    }

    public void enqueue(int x){
        Node newNode = new Node(x);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(" Data pushed successfully..");
    } 

    public int dequeue(){
        if(isEmpty()){
            System.out.println(" Queue underflow.");
            return -1;
        }
        int deltedItem = front.data;
        if(front.next == null){
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        size--;
        return deltedItem;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public int size(){
        return size;
    }
}
public class ImplementQueueUsingLinkedList {

    public static void main(String[] args) {
        QueueList queue = new QueueList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
            
        System.out.println("Top of the queue: " + queue.peek() );
        System.out.println("-----------------------------------");
        System.out.println("Size of the queue before deleting the element: " + queue.size());
        System.out.println("Element deleted: "+ queue.dequeue());
        System.out.println("Size of the queue after deleting the element: " + queue.size());
        System.out.println("Top of the queue: " + queue.peek() );
        System.out.println("-----------------------------------");
        System.out.println("Size of the queue before deleting the element: " + queue.size());
        System.out.println("Element deleted: "+ queue.dequeue());
        System.out.println("Size of the queue after deleting the element: " + queue.size());
        System.out.println("Top of the queue: " + queue.peek() );
        System.out.println("-----------------------------------");
        System.out.println("Size of the queue before deleting the element: " + queue.size());
        System.out.println("Element deleted: "+ queue.dequeue());
        System.out.println("Size of the queue after deleting the element: " + queue.size());
        System.out.println("Top of the queue: " + queue.peek() );
        System.out.println("-----------------------------------");
        System.out.println("Size of the queue before deleting the element: " + queue.size());
        System.out.println("Element deleted: "+ queue.dequeue());
        System.out.println("Size of the queue after deleting the element: " + queue.size());
        System.out.println("Top of the queue: " + queue.peek() );
       }
    
}
