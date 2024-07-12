package Monotonic_Stack_and_Queue;

import java.util.Stack;

public class NextGreaterElement1 {

    // Brute Force approach: Using loop
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    static int[] solution1(int arr[]){
        int n = arr.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++)
        {
            ans[i] = -1;
            for(int j=i+1; j<n; j++)
            {   
                if(arr[j]>arr[i]){
                    ans[i]=arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    // Better approach: Using stack
    // Time Complexity: O(N)
    // Space Complexity: O(N), stack space
    /*
     Step1: Travserse the stack from right to left
     Step2: Conditions
     case 1: If top of the stack is greater then the current array element then store it as answer
     case 2: If top of the stack is greater then the current array element then pop the element until we find any greater element at the top
     Step 3: Push the element onto the stack
     */

    static int[] solution2(int arr[]){
        Stack<Integer> stack = new Stack<Integer>();
        int n = arr.length;
        int[] ans = new int[n];

        for(int i=n-1; i>=0; i--){
            ans[i]=-1;
            // Case 1: If top element is less than or equal to the current element. i.e. the current elemnt is greater. Pop the stack until the condition holds 
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            // Case 2: If top element is greater than the current element.
            if(stack.peek() > arr[i]){
                ans[i] = stack.peek();
            }
            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return ans;
    }

    static void printArray(int[] arr){
        System.out.print(" [");
        for(int i=0; i<arr.length; i++){
            System.out.print("  " + arr[i] );
        }
        System.out.print(" ]\n");
    }
    public static void main(String[] args) {
        int arr[] = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        int ans[] = solution1(arr);
        
        System.out.println("Next Greater element: ");
        printArray(arr);
        printArray(ans);
    }
}
