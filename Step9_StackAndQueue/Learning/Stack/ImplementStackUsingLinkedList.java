package Stack;

// Time Complexity: O(1) for all operations
// Space complexity: O(size), where size is the size of queue

class StackList {
    private class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;
    public StackList(){
        this.top = null;
        this.size=0;
    }

    public boolean isEmpty(){
        return (top==null);
    }
    public void push(int x){
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(" Data Pushed successfully. ");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println(" Stack underflow ");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        size--;
        System.out.println(" Data popped successfully. ");
        return popped;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println(" Stack is empty. ");
            return -1;
        }
        return top.data;
    }

    public int size(){
        return size;
    }
}

public class ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        StackList stack = new StackList();
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
