package Stack;
class Queue {
    private int front, rear;
    private int currSize, maxSize;
    private int arr[];

    public Queue(int maxSize){
        this.front=-1;
        this.rear=-1;
        this.currSize=0;
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull(){
        if(currSize == maxSize)
            return true;
        else
            return false;  
    }

    public boolean isEmpty(){
        if(front==-1) 
            return true;
        else
            return false;
    }

    public void enqueue(int x){
        // Step1: Edge case: Check whether the queue is full
        if(isFull()){
            System.out.println("Queue overflow");
            return;
        }
        // Step2: If queue is empty. Both the pointers will point to the first element else increment the rear pointer accordingly
        if(isEmpty()){
            front=rear=0;
        }else{
            rear = (rear+1) % maxSize;
        }
        //Step3: Insert the element at the rear end
        arr[rear] = x;
        // Step4: Increment the currentSize of the queue
        currSize++;
    }

    public int dequeue(){
        // Step1: Edge case: Check whether the queue is empty
        if(isEmpty()){
            System.out.println("Queue underflow.");
            return -1;
        }
        // Step2: Store the front element in a varaible
        int popped = arr[front];

        // Step3: If queue contains only one element, Both the pointers will point to -1. Else increment the front pointer accordingly
        if(currSize == 1){
            front=rear=-1;
        }else{
            front = (front+1) % maxSize;
        }
        // Step4: Decrement the current size of the queue
        currSize--;
        // Step5: Return the popped element
        return popped;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public int size(){
        return currSize;
    }
}

//**------------------ Approach 1: Implement stack using 2 Queues-------------
// Time Complexity:  Push operation: O(n)
// Space complexity: O(2n) as we're using 2 queues
class Stack1{
    private Queue q1, q2;

    public Stack1(int capacity){
        this.q1 = new Queue(capacity);
        this.q2 = new Queue(capacity);
    }

    //* Push Operation */
    /*
     * Step1: Push the element x in the Queue q2
     * Step2: Push the element one by one from queue q1 to q2 until q1 is empty
     * Step3: Swap q1 and q2. Push the element one by one from queue q2 to q1 until q2 is empty
     */

    public void push(int x){
        q2.enqueue(x);

        while(!q1.isEmpty()){
            q2.enqueue(q1.peek());
            q1.dequeue();
        }

        while(!q2.isEmpty()){
            q1.enqueue(q2.peek());
            q2.dequeue();
        }
    }

    public int pop(){
        return q1.dequeue();
    }

    public int peek(){
        return q1.peek();
    }

    public int size(){
        return q1.size();
    }
}

//*------------------ Approach 2: Implement stack using single Queue-------------
// Time Complexity:  Push operation: O(n)
// Space complexity: O(n) as we're using only one queue
class Stack2{
    private Queue q1;

    public Stack2(int capacity){
        this.q1 = new Queue(capacity);
    }

    //* Push Operation */
    /*
     * Step1: Push the element x in the Queue q1
     * Step2: From first element to the currSize-1 dequeue element one and one and enqueue it on the queue. In this way the most recently added element will be at the front of the queue. 
     */

    public void push(int x){
        q1.enqueue(x);
        for(int i=0; i<q1.size()-1; i++){
            q1.enqueue(q1.dequeue());
        }
    }

    public int pop(){
        return q1.dequeue();
    }

    public int peek(){
        return q1.peek();
    }

    public int size(){
        return q1.size();
    }
}

public class ImplementStackUsingQueue {
   public static void main(String[] args) {
    Stack2 stack = new Stack2(10);
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
        
    System.out.println("Top of the stack: " + stack.peek() );
    System.out.println("-----------------------------------");
    System.out.println("Size of the stack before deleting the element: " + stack.size());
    System.out.println("Element deleted: "+ stack.pop());
    System.out.println("Size of the stack after deleting the element: " + stack.size());
    System.out.println("Top of the stack: " + stack.peek() );
    System.out.println("-----------------------------------");
    System.out.println("Size of the stack before deleting the element: " + stack.size());
    System.out.println("Element deleted: "+ stack.pop());
    System.out.println("Size of the stack after deleting the element: " + stack.size());
    System.out.println("Top of the stack: " + stack.peek() );
    System.out.println("-----------------------------------");
    System.out.println("Size of the stack before deleting the element: " + stack.size());
    System.out.println("Element deleted: "+ stack.pop());
    System.out.println("Size of the stack after deleting the element: " + stack.size());
    System.out.println("Top of the stack: " + stack.peek() );
    System.out.println("-----------------------------------");
    System.out.println("Size of the stack before deleting the element: " + stack.size());
    System.out.println("Element deleted: "+ stack.pop());
    System.out.println("Size of the stack after deleting the element: " + stack.size());
    System.out.println("Top of the stack: " + stack.peek() );
   }
    
}
