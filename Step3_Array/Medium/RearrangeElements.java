package Step3_Array.Medium;

import java.util.*;

public class RearrangeElements {
    /*Solutions for equally positive and negative elements */
    // 1. --------------------- Brute Force Approach -------------------------
    public static int[] solution11(int arr[], int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i]<0)
                neg.add(arr[i]);
            else if(arr[i]>0)
                pos.add(arr[i]);
        }

        for(int i=0; i<(n/2); i++){
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }

        return arr;

    }

    // 2. --------------------- Optimal Approach -------------------------
    public static ArrayList<Integer> solution12(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        int posIndex = 0;
        int negIndex = 1;

        for(int i=0; i<n; i++){
            if(arr.get(i)>0){
                ans.set(posIndex, arr.get(i));
                posIndex+=2;
            } else {
                ans.set(negIndex, arr.get(i));
                negIndex+=2;
            }
        }
        return ans;
    }


    /*Solutions for equally positive and negative elements */
    public static ArrayList<Integer> solution21(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr.get(i)>0)
                pos.add(arr.get(i));
            else
                neg.add(arr.get(i));
        }

        if (pos.size() < neg.size()){
            for(int i=0; i<pos.size(); i++){
                arr.set(2*i, pos.get(i));
                arr.set(2*i+1, neg.get(i));
            }
            int index = pos.size()*2;
            for(int i=pos.size(); i<neg.size(); i++){
                arr.set(index, neg.get(i));
                index++;
            }
        } else {
            for(int i=0; i<neg.size(); i++){
                arr.set(2*i, pos.get(i));
                arr.set(2*i+1, neg.get(i));
            }
            int index = neg.size()*2;
            for(int i=neg.size(); i<pos.size(); i++){
                arr.set(index, pos.get(i));
                index++;
            }
        }
        return arr;
    }


     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

       ArrayList<Integer> arr = new ArrayList<>(n);
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        ArrayList<Integer> result  = solution21(arr, n);

        System.out.print("Sign alertnating Elements: ");
        for(int a: result){
            System.out.print( a + " ");
        }
        sc.close();
    }
}