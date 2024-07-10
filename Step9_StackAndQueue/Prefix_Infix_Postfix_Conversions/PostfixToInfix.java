package Prefix_Infix_Postfix_Conversions;

import java.util.Stack;

public class PostfixToInfix {

    static String postfixToInfix(String postfix){
        Stack<String> stack = new Stack<String>();

        // Scan the postfix expresson from left to right
        for(int i=0; i<postfix.length(); i++){
            char c = postfix.charAt(i);

            // Case 1: If the scanned character is operand push it onto the stack
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                stack.push(String.valueOf(c));
            } 
            // Case 2: If the scanned character is operator, Pop two operator from the stack build a string having operator in-between them and push the string onto the stack
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = "(" + op2 + c + op1 + ")";
                stack.push(exp);
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String postfix = "ABC/+DE/F-*";
        String infix = postfixToInfix(postfix);

        System.out.println("Prefix expression: " + postfix);
        System.out.println("Infix expression: " + infix);
    }
    
}
