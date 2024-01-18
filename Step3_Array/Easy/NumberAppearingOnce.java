package Step3_Array.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberAppearingOnce {
    public static int numAppearingOnce1(int arr[], int n){

        for(int i=0; i<n; i++) {
            int num = arr[i];
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(arr[j] == num)
                    cnt++;
            }
            if(cnt==1)
                return arr[i];
        }
        return -1;
    }
    /*  Time Complexity: O(N2), where N = size of the given array.
        Reason: For every element, we are performing a linear search to count its occurrence. The linear search takes O(N) time complexity. And there are N elements in the array. So, the total time complexity will be O(N2).

        Space Complexity: O(1) as we are not using any extra space.
     */

    // -------------------------2.1. Better Approach(Using Hash Array)--------------------------------
     public static int numAppearingOnce2(int arr[], int n){
        //Step1: Find the maximum element: TC:O(n)
         int max = arr[0];
         for(int i=0; i<n; i++){
             max = Math.max(max, arr[i]);
        }

        //Step2:  Declare hash array of size maxi+1
        // And hash the given array: TC:O(n)
        int hash[] = new int[max+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }

        // Step3: Find the single element and return the answer: TC:O(n)
        for(int i=0; i<n; i++){
            if(hash[arr[i]] == 1)
                return arr[i];
        }
        
        //This line will never execute if the array contains a single element.
        return -1;
     }
     /* Time Complexity: O(N)+O(N)+O(N), where N = size of the array
        Reason: One O(N) is for finding the maximum, 
        the second one is to hash the elements and 
        the third one is to search the single element in the array.

        Space Complexity: O(maxElement+1) where maxElement = the maximum element of the array.
        Used by the hash array
      */


    // -------------------------2.2. Better Approach(Using HashMap)--------------------------------
    public static int numAppearingOnce3(int arr[], int n){
        // Step1: Declare the hashmap. And hash the given array:
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int key = arr[i];
            int freq = map.getOrDefault(arr[i], 0);
            map.put(key, freq+1);
        }

        // Step2: //Find the single element and return the answer:
       for(Map.Entry<Integer,Integer> it : map.entrySet()){
            if(it.getValue() == 1){
                return it.getKey();
            }
       }

       //This line will never execute if the array contains a single element.
       return -1;
    }
    /*  Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
        Reason: We are inserting N elements in the map data structure and insertion takes logM time(where M = size of the map). So this results in the first term O(N*logM). The second term is to iterate the map and search the single element. In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, the time complexity will be O(N) + O(M).
     * 
     * Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.
     */


    // -------------------------2.2. Optimal Approach(Using XOR)--------------------------------
    public static int numAppearingOnce4(int arr[], int n){ 
        int xor = 0;
        for(int i=0; i<n; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }
    /*  Time Complexity: O(N), where N = size of the array.
        Reason: We are iterating the array only once.

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

        int x = numAppearingOnce3(arr, n);
        System.out.println(" Single element: " + x) ;
        sc.close();
    }
}
