package Queue;

// currSize means the number of elements currently in the queue
// maxSize means the number of elements that the queue can hold i.e.capacity
class Queue {
    private int front, rear;
    private int currSize, maxSize;
    private int arr[];

    public Queue(int maxSize){
        front=-1;
        rear=-1;
        currSize=0;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void enqueue(int x){
        if(currSize == maxSize){
            System.out.println("Queue overflow");
            return;
        }
        if(front==-1){
            front=rear=0;
        }else{
            rear = (rear+1) % maxSize;
        }
        arr[rear] = x;
        currSize++;
    }
    public int dequeue(){
        if(front==-1){
            System.out.println("Queue underflow.");
            return -1;
        }
        int popped = arr[front];
        if(currSize == 1){
            front=rear=-1;
        }else{
            front = (front+1) % maxSize;
        }
        currSize--;
        return popped;
    }

    public int peek(){
        if(front== -1){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public int size(){
        return currSize;
    }
}

public class ImplementQueueUsingArray {
public static void main(String[] args) {
    Queue queue = new Queue(10);
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    
    System.out.println("Top of the queue: " + queue.peek() );
    System.out.println("Size of the queue before deleting the element: " + queue.size());
    System.out.println("Element deleted: "+ queue.dequeue());
    System.out.println("Size of the queue after deleting the element: " + queue.size());
    System.out.println("Top of the queue: " + queue.peek() );
}
    
}
