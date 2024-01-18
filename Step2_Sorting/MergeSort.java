package Step2_Sorting;

import java.util.*;

public class MergeSort {

    /*
     merge(): This function is used to merge the 2 halves of the array. It assumes that both parts of the array are sorted and merges both of them.
     */
    public static void merge(int arr[], int low, int mid, int high, int choice){
        ArrayList<Integer> tmp = new ArrayList<>();  // temporary array
        int left = low;         // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //***storing elements in the temporary array in a sorted manner***//
        //  1. Ascending order
        if(choice == 1){
            while(left<=mid && right<=high) {
                if(arr[left]<=arr[right]){
                    tmp.add(arr[left]);
                    left++;
                } else {
                    tmp.add(arr[right]);
                    right++;
                }
            }
        }  else { //  2. Descending order
            while(left<=mid && right<=high) {
                if(arr[left]>arr[right]){
                    tmp.add(arr[left]);
                    left++;
                } else {
                    tmp.add(arr[right]);
                    right++;
                }
            }
        }
        
        // 

        // if elements on the left half are still left //
        while(left<=mid) {
            tmp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while(right<=high) {
            tmp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for(int i=low; i<=high; i++){
            arr[i] = tmp.get(i-low);
        }
        
    }

    /*
     mergeSort(): This function divides the array into 2 parts. low to mid and mid+1 to high where,
        low = leftmost index of the array
        high = rightmost index of the array
        mid = Middle index of the array 
     */
    public static void mergeSort(int[] arr, int low, int high, int choice) {
        if(low>=high)
            return;
        
        int mid = (low+high) / 2;
        mergeSort(arr, low, mid, choice); // left half
        mergeSort(arr, mid+1, high, choice); // right half
        merge(arr, low, mid, high, choice); // merging sorted halves
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int a[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(" Select the choice of order: \n 1. Ascending order \n 2. Descending order ");
        int choice = sc.nextInt();

        if(choice==1 || choice==2){
            mergeSort(a, 0, n-1, choice);
        } else {
            System.exit(0);
        }

        
        System.out.print(" Sorted array: ");
        for(int i: a){
            System.out.print(" " + i );
        }

        sc.close();
    }
}