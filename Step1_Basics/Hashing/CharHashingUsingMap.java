package Step1_Basics.Hashing;

import java.util.*;

public class CharHashingUsingMap {
    // --------------------------1. Character Hashing ----------------------------
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter a string: ");
        String str = sc.next();

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char key = str.charAt(i);
            int freq = 0;

            if(map.containsKey(key))
                freq = map.get(key);
            
            freq++;
            map.put(key, freq);
        }

        for(Map.Entry<Character,Integer> it: map.entrySet()){
            System.out.println(it.getKey() + " -> " + it.getValue());
        }

        System.out.print(" Enter the no. of queries: ");
        int q = sc.nextInt();
        while(q-- >0){
            char c = sc.next().charAt(0);
            // Step 2: Fetch
            if(map.containsKey(c))
                System.out.println(map.get(c));
            else
                System.out.println(0);
        }
        sc.close();
    }
    
}
