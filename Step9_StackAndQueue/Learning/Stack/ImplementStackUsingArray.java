package Stack;
class Stack{
    int top = -1;
    int capacity = 10;
    int arr[] = new int[capacity]; 

    public void push(int x){
        if((top+1) == capacity){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top]=x;
    }

    public int pop(){
        if((top-1) == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public int size(){
        return (top+1);
    }
}
public class ImplementStackUsingArray{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        System.out.println("Top of the stack: " + stack.peek() );
        System.out.println("Size of the stack before deleting the element: " + stack.size());
        System.out.println("Element deleted: "+ stack.pop());
        System.out.println("Size of the stack after deleting the element: " + stack.size());
        System.out.println("Top of the stack: " + stack.peek() );
    }
}

// Time Complexity:
/*
 * push(): O(1)
 * pop(): O(1)
 * peek(): O(1)
 */

//  Space Complexity: 
// Auxiliary Space: O(n), n: number of items in the stack