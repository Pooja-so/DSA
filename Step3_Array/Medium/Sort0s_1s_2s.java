package Step3_Array.Medium;

import java.util.Scanner;

public class Sort0s_1s_2s {

    // ----------------------------1. Brute Approach----------------------------
    // (Use sorting algorithms)

    // ----------------------------2. Better Approach----------------------------
    public static void sort1(int arr[], int n){
        // Step 1: Counting the no. of zeros, ones and twos
        int cnt0 =0, cnt1=0;
        // int cnt2=0;

        for(int i=0; i<n; i++){
            if(arr[i] == 0)
                cnt0++;
            else if(arr[i] == 1)
                cnt1++;
            // else
            //     cnt2++;
        }

        // Step 2: Storing 0s, 1s and 2s in the array
        for(int i=0; i<cnt0; i++){
            arr[i] = 0;
        }
        for(int i=cnt0; i<(cnt0+cnt1); i++){
             arr[i] = 1;
        }
        for(int i=(cnt0+cnt1); i<n; i++){
            arr[i] = 2;
        }
    }

    // ---------------3. Optimal Approach (Dutch National flag algorithm. )----------------------------

    public static void sort2(int arr[], int n){
        int low = 0, mid = 0, high = n-1;
        
        while(mid<=high){
            // Incorrect result: int x = arr[mid];

            if( arr[mid] == 0){
                int tmp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = tmp;
                low++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                // swapping arr[mid] and arr[high]
                int tmp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = tmp;
                high--;
            }
        }
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

        sort2(arr,n);

        System.out.print(" Sorted array: ");
        for(int a : arr){
            System.out.print( a + " ");
        }
        sc.close();
    }
}
