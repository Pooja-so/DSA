package Step1_Basics.Hashing;

import java.util.*;


//----------------------------1.Brute-force approach--------------------------------
public class NumberHashing {
    public static int numberHashing(int arr[], int n, int number){
        int count=0;
        for(int i=0; i<n; i++) {
            if(arr[i] == number){
                count++;
            }
        }
        return count;
    }
    /*The above function contains a for loop that runs for n times. So, the time complexity of the function will be O(n) ignoring the other constant operations. 

    Now, for each query, we are calling this function. So, if the query contains 5 numbers and we call the function 5 times, the total time complexity will be O(5*N). If the number of queries is Q, the time complexity will be O(Q*N). 
     */

//----------------------------2.Optimal approach-----------------------------------
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of any array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements(between 0 to 12): ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        //precompute:
        int hash[] = new int[13]; //By default all elements are initialized to zero when memory is allocated with the new keyword
        for(int i=0; i<n; i++){
            hash[arr[i]] += 1;
        }

       System.out.print(" Enter the number of queries: ");
        int q = sc.nextInt();
        System.out.print(" Enter " + q + " query number: ");
        while (q-- != 0) {
            int number;
            number = sc.nextInt();
            // fetching:
            System.out.println(hash[number]);
        }


        sc.close();
    }
}
