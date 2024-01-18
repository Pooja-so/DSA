package Strings;

import java.util.* ;

class ReverseEachWord {

    static String reverseEachWord(String input)
    {
        // Write your code here
        String[] words= input.split(" ", -2);
        String reverseWords ="";

        for(String w: words){
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseWords += sb.toString() + " ";
        }

        return reverseWords.trim();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = reverseEachWord(input);
        System.out.println(ans);
        sc.close();
    }
}