package Step3_Array.Easy;

import java.util.Scanner;

public class MissingNumber {
    //----------------------------1.My approach- Work only for sorted array----------------------------
    public static int findMissingNumber(int arr[], int n) {
        for(int i=0; i<(n-1); i++){
            if(!(arr[i+1] == (arr[i]+1)))
                return (arr[i]+1);
        }
        return -1;
    }
    /* Time Complexity: O(n) as it iterate through the array only once.
     * Space complexity: O(1) as it does not uses any extra spaces.
    */

//----------------------------1.Brute-force approach(Using Linear Search)--------------------------------
    public static int findMissingNumber1(int arr[], int n) {
        // Outer loop that runs from 1 to N:
        for(int i=1; i<=n; i++){
            // flag variable to check 
            // if an element exists
            int flag=0;
            //Search the element using linear search:
            for(int j=0; j<(n-1); j++){
                // i is present in the array:
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            // check if the element is missing
            //i.e flag == 0:
            if(flag==0)
                return i;
        }
        // No missing elements
        return -1;
    }
/* Time Complexity: O(n^2), where n = size of the array+1.
    Reason: In the worst case i.e. if the missing number is n itself, the outer loop will run for n times, and for every single number the inner loop will also run for approximately n times. So, the total time complexity will be O(n^2).

    Space Complexity: O(1)  as we are not using any extra space.
*/

//--------------------------- 2.Better Approach (using Hashing)-------------------------------------
public static int findMissingNumber2(int arr[], int n) {
    int hash[] = new int[n+1];

    //Step1: storing the frequencies:
    for(int i=0; i<(n-1); i++){
        hash[arr[i]] = 1;
    }

    //Step2: Checking the freqencies for numbers 1 to n:
    for(int i=1; i<=n; i++){
        if(hash[i]==0)
            return i;
    }
    
    // No missing elements
    // The following line will never execute. It is just to avoid warnings.
    return -1;
}
/*  Time Complexity: O(n) + O(n) ~ O(2*n),  where n = size of the array+1.
    Reason: For storing the frequencies in the hash array, the program takes O(n) time complexity and for checking the frequencies in the second step again O(n) is required. So, the total time complexity is O(n) + O(n).

    Space Complexity: O(n), where n = size of the array+1. Here we are using an extra hash array of size n+1.
 */

//  ----------------------------3.1.Optimal Approach(Summation approach)-----------------------------
    public static long findMissingNumber3(int arr[], int n) {
        //Step1: Summation of first n natural numbers
        long sum1 = (n*(n+1))/2;

        //Step2: Summation of all n-1 elements of array arr
        long sum2 = 0;
        for(int i=0; i<(n-1); i++){
            sum2 += arr[i];
        }

        // Step3:Finally, we will consider the difference between the summation of the first N natural numbers and the sum of the array elements.
        long missingNo = (sum1-sum2);
        return missingNo;
    }
    /* Time Complexity: O(N), where N = size of array+1.
        Reason: Here, we need only 1 loop to get the sum of the array elements. The loop runs for approx. N times. So, the time complexity is O(N).
        Space Complexity: O(1) as we are not using any extra space.
     */

//  -------------------------------3.2.Optimal Approach(XOR Approach)--------------------------------
// So, if we perform the XOR of the numbers 1 to N with the XOR of the array elements, we will be left with the missing number.
    public static int findMissingNumber4(int arr[], int n) {
        int xor1 = 0;
        int xor2 = 0;

        for(int i=0; i<(n-1); i++){
            xor1 = xor1 ^ arr[i]; // XOR of array elements
            xor2 = xor2 ^ (i+1); //XOR up to [1...n-1]
        }
        xor2 = xor2 ^ n; //XOR up to [1...n]

        int missingNo = xor1 ^ xor2; // the missing number
        return missingNo;
    }
    /*  Time Complexity: O(N), where N = size of array+1.
        Reason: Here, we need only 1 loop to calculate the XOR. The loop runs for approx. N times.
        So, the time complexity is O(N).

        Space Complexity: O(1) as we are not using any extra space.
     */
    //Reason of betterment: The diffrenece between optimal3.1 and optimal3.2 is the matter of space complexity. The xor of all int elements will result in integer value only but the summation of all int elements of array may result into an long value //

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n-1];
        System.out.print(" Enter " + (n-1) + " elements: ");
        for(int i=0; i<n-1; i++){
            arr[i] = sc.nextInt();
        }

        long x = findMissingNumber4(arr, n);
        if(x==-1)
            System.out.println(" There is no missing number in the given array.");
        else
            System.out.println(" Missing number is: " + x);

        sc.close();
    }
}
