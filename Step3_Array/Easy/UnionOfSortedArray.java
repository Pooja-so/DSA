package Step3_Array.Easy;

import java.util.*;

public class UnionOfSortedArray {

    //--------------------------------Solution 1.Using Set------------------------------------------
    public static ArrayList<Integer> unionUsingSet(int arr1[], int arr2[], int n1, int n2){
        // Set only contains unique elements 
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList < Integer > Union=new ArrayList<>();

        for(int i=0; i<n1; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<n2; i++){
            set.add(arr2[i]);
        }

        for (int it: set)
            Union.add(it);
    
        return Union;
    }

    /* Time Compleixty : O( (n1+n2)log(n1+n2) ) . Inserting an element in a set takes logN time, where N is no of elements in the set. At max set can store n1+n2 elements {when there are no common elements and elements in arr,arr2 are distntict}. So Inserting n1+n2 th element takes log(n1+n2) time. Upon approximation across inserting all elements in worst, it would take O((n1+n2)log(n1+n2) time.

    Using HashSet also takes the same time, On average insertion in unordered_set takes O(1) time but sorting the union vector takes O((n1+n2)log(n1+n2))  time. Because at max union vector can have n1+n2 elements.

    Space Complexity : O(n1+n2) {If Space of Union ArrayList is considered} 
    O(1) {If Space of union ArrayList is not considered} 
 */

    //--------------------------------Solution 2.Using Map------------------------------------------
    // Whenever we want to store something in pair(2 interrelated elements: Key-Value pair) we use Map.
    // Note: HashMap are unordered map i.e. they do not preserve the insertion order of ther elements
    public static ArrayList<Integer> unionUsingMap(int arr1[], int arr2[], int n1, int n2){
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();

        for(int i=0; i<n1; i++){
            // put(Integer key, Integer value)
            freq.put(arr1[i], freq.getOrDefault(arr1[i],0)+1);
        }
        for(int i=0; i<n2; i++){
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0)+1);
        }

        for(int it: freq.keySet()){
            union.add(it);
        }
        return union;
    }

    //--------------------------------Solution 1.Using 2 pointers------------------------------------------
    public static ArrayList<Integer> unionOfSortedArray(int arr1[], int arr2[], int n1, int n2){
        ArrayList<Integer> union = new ArrayList<>();

        int i=0, j=0;
        while(i<n1 && j<n2) {

            // Case 1 and 2 
            // union.get(union.size()-1) will give the last element of ArrayList
            if(arr1[i] <= arr2[j]){
                if(union.size() == 0    ||  union.get(union.size()-1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } //case 3
            else {
                if(union.size() == 0    ||  union.get(union.size()-1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        // If any element is left in arr1
        while(i<n1) {
            if(union.size() == 0    ||  union.get(union.size()-1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // If any element is left in arr2
        while(j<n2) { 
            if(union.size() == 0    ||  union.get(union.size()-1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }
    
    /*Time Complexity: O(n1+n2), Because at max i runs for n1 times and j runs for n2 times. When there are no common elements in arr1  and arr2 and all elements in arr1, arr2 are distinct. 

    Space Complexity : O(n1+n2) {If Space of Union ArrayList is considered} 
                       O(1) {If Space of union ArrayList is not considered}
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array1: ");
        int n1 = sc.nextInt();

        int arr1[] = new int[n1];
        System.out.print(" Enter " + n1 + " elements: ");
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.print(" Enter the size of array2: ");
        int n2 = sc.nextInt();

        int arr2[] = new int[n2];
        System.out.print(" Enter " + n2 + " elements: ");
        for(int i=0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }

        // ArrayList<Integer> union  = unionUsingSet(arr1, arr2, n1, n2);
        // ArrayList<Integer> union  = unionUsingMap(arr1, arr2, n1, n2);
       ArrayList<Integer> union = unionOfSortedArray(arr1, arr2, n1, n2);


        System.out.print(" Modified array: ");
        for(int i: union){
            System.out.print(" " + i );
        }

        sc.close();
    }
}
    