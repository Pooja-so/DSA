package Prefix_Infix_Postfix_Conversions;

import java.util.Stack;

public class PrefixToInfix {

    static String prefixToInfix(String prefix){
        Stack<String> stack = new Stack<String>();

        // Scan the prefix expresson from right to left
        for(int i=(prefix.length()-1); i>=0; i--){
            char c = prefix.charAt(i);

            // Case 1: If the scanned character is operand push it onto the stack
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                stack.push(String.valueOf(c));
            } 
            // Case 2: If the scanned character is operator, Pop two operands from the stack build a string having operator in-between them and push the string onto the stack
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = "(" + op1 + c + op2 + ")";
                stack.push(exp);
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String prefix = "*+A/BC-/DEF";
        String infix = prefixToInfix(prefix);

        System.out.println("Prefix expression: " + prefix);
        System.out.println("Infix expression: " + infix);
    }

}

// Time Complexity: O(N)
// Space Comlexity: O(N)
//  N is the size of the prefix expression