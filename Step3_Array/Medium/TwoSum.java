package Step3_Array.Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    // public static String twoSum(int arr[], int n, int target){
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(i==j)
    //                 continue;

    //             int sum = arr[i]+arr[j];
    //             if(sum==target)
    //                 return "YES";

    //         }
    //     }
    //     return "NO";
    // }
    // ----------------------------1. Brute Approach----------------------------
    public static String twoSum11(int arr[], int n, int target){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = arr[i]+arr[j];
                if(sum==target)
                    return "YES";

            }
        }
        return "NO";
    }

    public static int[] twoSum12(int arr[], int n, int target){
        int res[] = {-1, -1}; 
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = arr[i]+arr[j];
                if(sum==target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }

            }
        }
        return res;
    }

    // ----------------------------2. Better Approach----------------------------
    public static String twoSum21(int arr[], int n, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int x = arr[i];
            int more = target - x;

            if(map.containsKey(more)){
                return "YES";
            }
            map.put(arr[i],i);
        }
        return "NO";
    }

    public static int[] twoSum22(int arr[], int n, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = {-1, -1}; 

        for(int i=0; i<n; i++){
            int x = arr[i];
            int more = target - x;

            if(map.containsKey(more)){
                res[0] = map.get(more);
                res[1] = i;
                return res;
            }
            map.put(arr[i],i);
        }
        return res;
    }

    // ----------------------------3. Optimal Approach----------------------------
    public static String twoSum31(int arr[], int n, int target){
        int left = 0, right = n-1;

        // Step1: Sort an array (left to right --> indicates increasing order) and right to left indicates decreasding order
        Arrays.sort(arr);

        // Step 2: Finding two numbers such that their sum is equal to target
        while(left<right){
            int sum = arr[left] + arr[right];

            if(sum == target){
                return "YES";
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }

        return "NO";

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

        System.out.print(" Enter target: ");
        int target = sc.nextInt();

        String result=  twoSum31(arr, n, target);
        // int res[] = twoSum32(arr, n, target);

        System.out.println(" Result: "+ result);
        // System.out.print(" Indices: [ " + res[0] + ", " + res[1] + "]" );
        sc.close();
    }
}
