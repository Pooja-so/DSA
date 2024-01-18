package Step1_Basics.Hashing;

import java.util.*;

public class NumberHashingUsingMap {
     
    // --------------------------1. Number Hashing ---------------------------- 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements(between 0 to 12): ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // Step1: Precompute
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int key = arr[i];
            int freq = 0;

            if(map.containsKey(key)){
                freq = map.get(key); // fetching value from the map
            }
            freq++;
            map.put(key, freq); // inserting into the map
        }


        // Iterate over the map:
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            System.out.println( it.getKey() + " -> " + it.getValue());
        }

        System.out.print(" Enter the no. of queries: ");
        int q = sc.nextInt();
        while(q-- >0){
            int num = sc.nextInt();
            // Step 2: Fetch
            if(map.containsKey(num))
                System.out.println(map.get(num));
            else
                System.out.println(0);
        }
        sc.close();
    }
}
/*
 The total time complexity will be O(N * time taken by map data structure).

 In java,
 HashMap in Java, both take O(1) time complexity to perform storing(i.e. insertion) and fetching(i.e. retrieval).

 In C++,
Storing(i.e. insertion) and fetching(i.e. retrieval) in a C++ map, both take always O(logN) time complexity, where N = the size of the map. 

But the unordered_map in C++. Now, it is valid for the best case and the average case. 

But in the worst case, this time complexity will be O(N) for unordered_map. Now, the worst case occurs very very rarely. It almost never happens and most of the time, we will be using unordered_map. 

Note: Our first priority will be always to use unordered_map and then map. If unordered_map gives a time limit exceeded error(TLE), we will then use the map.

The time complexity in the worst case is O(N) because of the internal collision.
 */
