import java.util.Stack;

public class CheckForBalancedParanthesis {
    
    //* Solution: Using stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } 
            else if((c==')' && stack.peek()=='(') || 
                    (c==']' && stack.peek()=='[') || 
                    (c=='}' && stack.peek()=='{'))
                    stack.pop();
            else
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
       String str = "()[{}()]";
    //    String str = "(";
    //    String str = ""; // Empty string is also balanced
       
       if(isBalanced(str))
            System.out.println(" Balanced ");
       else
            System.out.println(" Not Balanced ");
    }
}
