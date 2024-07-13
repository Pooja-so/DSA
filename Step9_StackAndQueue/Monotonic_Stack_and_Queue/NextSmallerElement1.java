package Monotonic_Stack_and_Queue;

import java.util.Stack;

public class NextSmallerElement1 {

    //* Solution 1: Brute Force approach: Using loop
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    static int[] solution1(int arr[]){
        int n = arr.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++)
        {
            ans[i] = -1;
            for(int j=i-1; j>=0; j--)
            {   
                if(arr[j]<arr[i]){
                    ans[i]=arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    //* Solution 2: Better approach: Using stack
    // Time Complexity: O(N)
    // Space Complexity: O(N), stack space
    static int[] solution2(int arr[]){
        Stack<Integer> stack = new Stack<Integer>();
        int n = arr.length;
        int[] ans = new int[n];

        System.out.println("Solution 2: ");

        // Step1: Traverse the array in from left to right
        for(int i=0; i<n; i++){
            // Step 2.1: Pop out all the greater elements from the stack 
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            // Step 2.2: After popping all the greater elements if the stack is not empty then the element at the top will always be the element smaller than the current array element else if the stack is empty that means there is no smaller element on the right.
            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }else{
                ans[i]=-1;
            }
            // Step 2.3: Push the current element onto the stack
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
        // int arr[] = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        int arr[] = {2, 10, 12, 1, 11};

        int ans[] = solution2(arr);
        
        System.out.println("Next Greater element: ");
        printArray(arr);
        printArray(ans);
    }
}
