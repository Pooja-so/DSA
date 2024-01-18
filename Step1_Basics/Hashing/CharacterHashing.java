package Step1_Basics.Hashing;

import java.util.Scanner;

public class CharacterHashing {
    //----------------------------1.Brute-force approach--------------------------------
    public static int characterHashing(String str, char c){
        int count=0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
    /*Time Complexity analysis of the function:
    It is as same as the one we calculated for the previous problem. If the number of queries is Q, the time complexity will be O(Q*N) where N = size of the string.  
     */

    // Case 1: If string contains only lowercase letters
    public static int characterHashing1(String str, char c){
        int hash[] = new int[25];

        //  Step 1: Precomputing
        for(int i=0; i<str.length(); i++){
            hash[str.charAt(i) - 'a'] += 1;
        }

        // Step 2: Fetching
        int freq = hash[c - 'a'];
        return freq;
    }


    // Case 2: If string contains only uppercase letters
    public static int characterHashing2(String str, char c){
        int hash[] = new int[25];

        //  Step 1: Precomputing
        for(int i=0; i<str.length(); i++){
            hash[str.charAt(i) - 'A'] += 1;
        }

        // Step 2: Fetching
        int freq = hash[c - 'A'];
        return freq;
    }

    // Case 3: If string contains both  lowercase and uppercase letters
    public static int characterHashing3(String str, char c){
        int hash[] = new int[256];

        //  Step 1: Precomputing
        for(int i=0; i<str.length(); i++){
            hash[str.charAt(i)] += 1;
        }

        // Step 2: Fetching
        int freq = hash[c];
        return freq;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter a string: ");
        String str = sc.nextLine();

        System.out.print(" Enter character: ");
        char c = sc.next().charAt(0);

        
        int freq;
        if(str.equals(str.toLowerCase()))
            freq = characterHashing1(str, c);
        else if(str.equals(str.toUpperCase()))
            freq = characterHashing2(str, c);
        else
            freq = characterHashing3(str, c);

        System.out.print(" The frequency of character " + c + " is: " + freq);

        sc.close();
    }

}
