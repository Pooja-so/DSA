package Prefix_Infix_Postfix_Conversions;

import java.util.Stack;

public class PrefixToPostfix {
        static String prefixToPostfix(String prefix){
        Stack<String> stack = new Stack<String>();

        // Scan the prefix expresson from right to left
        for(int i=(prefix.length()-1); i>=0; i--){
            char c = prefix.charAt(i);

            // Case 1: If the scanned character is operand push it onto the stack
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                stack.push(String.valueOf(c));
            } 
            // Case 2: If the scanned character is operator, Pop two operator from the stack build a string having operator in-between them and push the string onto the stack
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = op1 + op2 + c;
                stack.push(exp);
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String prefix = "*+A/BC-/DEF";
        String postfix = prefixToPostfix(prefix);

        System.out.println("Prefix expression: " + prefix);
        System.out.println("Postfix expression: " + postfix);
    }
}
