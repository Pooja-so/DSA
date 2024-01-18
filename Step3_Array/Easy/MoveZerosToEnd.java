package Step3_Array.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveZerosToEnd {
    //-------------------------1.Brute Force Approach: Using temp array-----------------------------------
    public static void moveZerosToEnd1(int arr[], int n){
        ArrayList<Integer> temp = new ArrayList<>();
        int i;
        // Step1: Storing all non-zero elements in an Arraylist(temporary array ). 
        for(i=0; i<n; i++){
            if(arr[i]!=0)
                temp.add(arr[i]);
        }
        // Step2: Copying all non-zero elements stored in ArrayList to the original array startinf from 0th index. 
        for(i=0; i<temp.size(); i++){
            arr[i] = temp.get(i);
        }
        // Step3: If size of ArrayList is not equal to the size of array than there are 
        // arr.length - ArrayList.size() zero elements in the array.
        while(i<n){
            arr[i]=0;
            i++;
        }
    }
    /* Time Complexity: O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,
    X = no. of non-zero elements, and N-X = total no. of zeros.
    Reason: O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. So, the total time complexity will be O(2*N).

    Space Complexity: O(N), as we are using a temporary array to solve this problem and the maximum size of the array can be N in the worst case.
    Reason: The temporary array stores the non-zero elements. In the worst case, all the given array elements will be non-zero.
    */

    //-------------------------2.Optimal Approach: Using 2 pointers-----------------------------------
    public static void moveZerosToEnd2(int arr[], int n){
        //Step1: Placing pointer j at first zero element
        int j=-1;
        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }
        // If there are no any zero elments than array consists of all non-zero elements so return
        if(j==-1) 
            return;

        //Step2: After that, we will point i to index j+1 and start moving the pointer using a loop.
        for(int i=j+1; i<n; i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    /*  Time Complexity: O(N), N = size of the array.
        Reason: We have used 2 loops and using those loops, we are basically traversing the array once.
        Space Complexity: O(1) as we are not using any extra space to solve this problem.
     */


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        moveZerosToEnd2(arr, n);

        System.out.print(" Modified array: ");
        for(int i: arr){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
