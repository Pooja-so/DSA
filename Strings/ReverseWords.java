package Strings;

import java.util.Scanner;

class ReverseWords {

    static void reverseStringWordWise(String input) {
        // String[] arr = input.split(" ", -2);
        // int n = arr.length;
        // String[] arr2 = new String[n];
        // for(int i=n-1; i>=0; i--){
        //     arr2[i] = arr[n-i-1];
        // }
        // // System.out.println(arr2);
        // for(String s: arr2){
        //     System.out.print(s + " ");
        // }

        String[] arr = input.split(" ", -2);
        String str = new String();
        for(int i=arr.length-1; i>=0; i--){
            // arr2[i] = arr[n-i-1];
            str = str + arr[i] + " ";
        }
        System.out.print(str.trim());
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        reverseStringWordWise(input);
        // String ans = reverseStringWordWise(input);
        // System.out.println(ans);
        sc.close();
    }
}