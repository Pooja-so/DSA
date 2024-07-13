package Monotonic_Stack_and_Queue;

import java.util.Stack;

public class NextGreaterElement2 {

    //* Solution 1: Brute Force approach: Using loop
    // Time Complexity: O(n*2n)
    // Space Complexity: O(1)
    static int[] solution1(int arr[]){
        int n = arr.length;
        int[] nge = new int[n];

        for(int i=0; i<n; i++)
        {
            nge[i] = -1;
            for(int j=i+1; j<2*n; j++)
            {   
                if( arr[j%n] > arr[i] ){
                    nge[i] = arr[j%n];
                    break;
                }
            }
        }
        return nge;
    }

    //* Solution 2: Better approach: Using stack
    // Time Complexity: O(2N + 2N) = O(N)
    // Space Complexity: O(N), stack space

    static int[] solution2(int arr[]){
        int cnt=0;
        Stack<Integer> stack = new Stack<Integer>();
        int n = arr.length;
        int[] nge = new int[n];

        System.out.println(" Solution 2: ");
        //Step 1: As we gonna traverse the whole array twice in case of circular 
        for(int i=(2*n-1); i>=0; i--){

            // Step 2.1: Pop out all the smaller elements from the stack. 
            while(!stack.isEmpty() && stack.peek() <= arr[i%n]){
                cnt++;
                System.out.println(" Count: " + cnt); // Does not go beyond 2n
                System.out.println(" Stack before popping: " + stack);
                stack.pop();
            }
            // Step 2.2(condition): Only if the value of i is less then n. Because thw array contains only n elements. we are iterating the same array twice by using modulo n. 
            if(i<n){
                // Explained in variant 1 solution
                if(!stack.isEmpty())
                    nge[i] = stack.peek();
                else
                    nge[i]=-1;
            }
            //Step 2.3: Push the current element onto the stack
            stack.push(arr[i%n]);
        }

        return nge;
    }

    static void printArray(int[] arr){
        System.out.print(" [");
        for(int i=0; i<arr.length; i++){
            System.out.print("  " + arr[i] );
        }
        System.out.print(" ]\n");
    }

    public static void main(String[] args) {
        int arr[] = {4, 12, 5, 3, 1, 2, 5, 6};
        // int arr[] = {2, 10, 12, 1, 11};
        int nge[] = solution2(arr);
        
        System.out.println("Next Greater element: ");
        printArray(arr);
        printArray(nge);
    }
}
