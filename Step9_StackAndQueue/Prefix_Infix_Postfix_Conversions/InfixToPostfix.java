package Prefix_Infix_Postfix_Conversions;

import java.util.Stack;

public class InfixToPostfix {
    
    // Step 1: Function to return the precedence of the operator
    static int precedence(char c){
        if(c == '^')
            return 3;
        else if(c == '*' || c == '/')
            return 2;
        else if(c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

     // Step 2: Function to return the associativity of the operator
     static char associativity(char c){
        if(c == '^')
            return 'R';
        else
            return 'L';
    }


    // Step 3: Function to return the Postfix expression
    static StringBuilder infixToPostfix(String infix){
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();

        // Scan the infix expression from left to right
        for(int i=0; i<infix.length(); i++){
            char c = infix.charAt(i);

            // Rules to convert infix to postfix
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                result.append(c);
            } 
            else if( c == '('){
                stack.push(c);
            } 
            else if( c == ')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result.append(stack.pop());
                }
                stack.pop(); // Discarding the left parenthesis
            } 
            else {
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek()) && associativity(c)=='L' && stack.peek()!='('){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder postfix = infixToPostfix(infix);

        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);
    }
}

// Time Complexity: O(N)
// Space Comlexity: O(N)
//  N is the size of the infix expression
