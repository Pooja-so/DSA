package Queue;
class Stack{
    private int top, capacity;
    private int arr[]; 

    public Stack(int capacity){
        this.top=-1;
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public boolean isFull(){
        if(top == (capacity-1))
            return true;
        else
            return false;
    }

    public boolean isEmpty(){
        if(top == -1)
            return true;
        else
            return false;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }
        arr[++top]=x;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[top];
    }

    public int size(){
        return (top+1);
    }
}

//*------------------ Approach 1: Implement queue using 2 Stacks-------------
// Time Complexity:  Enqueue operation: O(n)
// Space complexity: O(2n) as we're using 2 stacks

class Queue1{

    private Stack s1, s2;

    public Queue1(int capacity){
        s1 = new Stack(capacity);
        s2 = new Stack(capacity);
    }

    //* Enqueue Operation */
    /*
     * Step1: s2 <- s1  Push all the elements one by one from stack s1 into stack s2
     * Step2: s1 <- x   Push the new element x  into s1
     * Step3: s1 <- s2  Push all the elements one by one from stack s2 back into stack s1. 
     Doing this way the first element will always remain on the top of the stack and the most recent;y added element will always remain on the vottom of the stack. Follows FIFO order.
     */
    public void enqueue(int x){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int dequeue(){
        return s1.pop();
    }

    public int peek(){
        return s1.peek();
    }

    public int size(){
        return s1.size();
    }

}

//*------------------ Approach 1: Implement queue using 2 Stacks-------------
// Time Complexity:  Enqueue operation: O(1).
    // Dequeue and peek operation: amortized O(1). It means most of the time, the time complexity will be o(1) and sometimes the complexity will be O(n) when the output stack is empty.
// Space complexity: O(2n) as we're using 2 stacks

class Queue2{
    private Stack input, output;

    public Queue2(int capacity){
        input = new Stack(capacity);
        output = new Stack(capacity);
    }

    public void enqueue(int x){
        input.push(x);
    }

    public int dequeue(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public int size(){
        int size = input.size() + output.size();
        return size;
    }
}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        Queue2 queue = new Queue2(10);
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
