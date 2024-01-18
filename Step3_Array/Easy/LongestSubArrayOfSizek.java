package Step3_Array.Easy;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayOfSizek {

    // ----------------------1.Solution-----------------------------------
    public static int longestSubarray1(int arr[], long sumk, int n){
        int maxLen =0 ;
        for(int i=0; i<n; i++){ //Sarting index

            for(int j=i; j<n; j++){ //Ending index
                // add all the elements of
                // subarray = a[i...j]:
                long sum = 0;
                for(int k=i; k<=j; k++){
                    sum += arr[k];
                }
                if(sum == sumk){
                    maxLen = Math.max(maxLen, (j-i+1));
                }
            }
        }
        return maxLen;
    }
    /*
        Time Complexity: O(N^3) approx., where N = size of the array.
        Reason: We are using three nested loops, each running approximately N times.

        Space Complexity: O(1) as we are not using any extra space.
    */

    // ----------------------2.Solution-----------------------------------
    public static int longestSubarray2(int arr[], long sumk, int n){
        int maxLen =0 ;
        for(int i=0; i<n; i++){ //Sarting index
            long sum = 0;
            for(int j=i; j<n; j++){ //Ending index
                // add all the elements of
                // subarray = a[i...j]:
                sum += arr[j];
                if(sum == sumk){
                    maxLen = Math.max(maxLen, (j-i+1));
                }
            }
        }
        return maxLen;
    }
 /*
        Time Complexity: O(N^2) approx., where N = size of the array.
        Reason: We are using two nested loops, each running approximately N times.

        Space Complexity: O(1) as we are not using any extra space.
    */

    // ----------------------2.Solution-----------------------------------
    public static int longestSubarray3(int arr[], long sumk, int n){
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxlen = 0;

        for(int i=0; i<n; i++){
            //calculate the prefix sum till index i:
            sum += arr[i];

            // Initially, first time when subarray starting from 0 to i has summation = sumk 
            if(sum == sumk){
                maxlen = Math.max(maxlen, i+1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - sumk;

            //Calculate the length and update maxLen:
            if(preSumMap.containsKey(rem)){
                int len = i - preSumMap.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            //Finally, update the map checking the conditions:
            if(! preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }

        return maxlen;
    }
    /* Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
        Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N)(though in the worst case, unordered_map takes O(N) to find an element and the time complexity becomes O(N2)) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.
        Space Complexity: O(N) as we are using a map data structure.
    */

    // -----------------------------4.Solution---------------------------------------------
    public static int longestSubarray4(int arr[], long sumk, int n){
        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;

        while(right < n){
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while(sum>sumk && left<=right){
                sum -= arr[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if(sum == sumk){
              maxLen = Math.max(maxLen, right-left+1);  
            }

            // Move forward thw right pointer:
            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        return maxLen;
    }
/*
    Time Complexity: O(2*N), where N = size of the given array.
    Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index). Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. So, every time the inner loop does not run for n times rather it can run for n times in total. So, the time complexity will be O(2*N) instead of O(N2).

    Space Complexity: O(1) as we are not using any extra space.
 */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(" Enter the value of k: ");
        long k = sc.nextLong();

        int len = longestSubarray3(arr, k, n);

        System.out.println(" The size of longest subarray having sum " + k + " is: " + len);
        sc.close();
    }
}
