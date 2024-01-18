package Step3_Array.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    // ----------------------------1. Brute Approach----------------------------
    public static int majorityElement1(int arr[], int n){
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(arr[i] == arr[j]){
                    cnt++;
                }
            }
            if(cnt > (n/2)){
                return arr[i];
            }
        }
        return -1;
    }

    // ----------------------------2. Better Approach----------------------------
    public static int majorityElement2(int arr[], int n){
        HashMap<Integer,Integer> map = new HashMap<>();

        //storing the elements with its occurnce:
        for(int i=0; i<n; i++){
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value+1);
        }

        //searching for the majority element:
        for(Map.Entry<Integer,Integer> it: map.entrySet()){
            if(it.getValue() > (n/2)){
                return it.getKey();
            }
        }
        
        return -1;
    }

    // ---------------3. Optimal Approach (Moore’s Voting Algorithm)----------------------------
        public static int majorityElement3(int arr[], int n){
            int count = 0;
            int element = 0;

            //applying the algorithm:
            for(int i=0; i<n; i++){
                if(count == 0){
                    element = arr[i];
                    count=1;
                } else if(element == arr[i]){
                    count++;
                } else {
                    count--;
                }
            }

             //checking if the stored element is the majority element:
             int cnt = 0;
             for(int i=0; i<n; i++){
                if(element == arr[i]){
                    cnt++;
                }
             }

             if(cnt>(n/2)){
                return element;
             }
              
            return -1;
        }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int num = majorityElement2(arr,n);
        System.out.println(" The majority appearing element: " + num);
        sc.close();
    }
}
