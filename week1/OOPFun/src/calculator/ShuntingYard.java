package calculator;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ShuntingYard {


    // Supported operators
    private static final Map<String, Integer> OPERATORS = new HashMap<String, Integer>();

    static {
        // Map<"token",precedence>
        OPERATORS.put("+", 0);
        OPERATORS.put("-", 0);
        OPERATORS.put("*", 5);
        OPERATORS.put("/", 5);
    }

    private boolean isOperator(String token) {
        return OPERATORS.containsKey(token);
    }
    
    private boolean isFunction(String token) {
        return token.matches("sin|cos|tg|cotg|log|pow|sqrt");
    }

    private final int cmpPrecedence(String token1, String token2) {
        if (!isOperator(token1) || !isOperator(token2)) {
            throw new IllegalArgumentException("Invalied tokens: " + token1
                    + " " + token2);
        }
        return OPERATORS.get(token1) - OPERATORS.get(token2);
    }

    public String[] Yard(String[] inputTokens) {
        LinkedList<String> output = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        int length = inputTokens.length;
        
        int i = 0;
        if (inputTokens[0].equals("-")){
            output.add("0");
        }
        if (inputTokens[0].equals("-") && inputTokens[1].matches("\\d+|pi|e|PI|E")) {
            output.add("-" + inputTokens[1]);
            i = 2;
        }

        for (; i < length; i++) {
            if (inputTokens[i].matches("\\d+|pi|e|PI|E")) {
                output.add(inputTokens[i]);
            } else if (isFunction(inputTokens[i])) {
                stack.push(inputTokens[i]);
            } else if (inputTokens[i].equals(",")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if(stack.empty()){
                    throw new IllegalArgumentException("separator or parentheses were mismatched");
                }
                if(i<=length-3){
                    if (inputTokens[i + 1].equals("-") && inputTokens[i + 2].matches("\\d+|pi|e|PI|E")) {
                        output.add("-" + inputTokens[i + 2]);
                        i = i + 2;
                    }
                }
            } else if (inputTokens[i].equals("(")) {
                stack.add(inputTokens[i]);
                if(i<=length-3){
                    if (inputTokens[i + 1].equals("-") && inputTokens[i + 2].matches("\\d+|pi|e|PI|E")) {
                    output.add("-" + inputTokens[i + 2]);
                    i = i + 2;
                    }
                }
            } else if (isOperator(inputTokens[i])) {
                while (!stack.empty() && isOperator(stack.peek())) {
                    if ( cmpPrecedence(inputTokens[i], stack.peek()) <= 0) {
                        output.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(inputTokens[i]);
            } else if (inputTokens[i].equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if(!stack.empty())
                    stack.pop();
                else{
                    throw new IllegalArgumentException("Invalid input");
                }
                if (!stack.empty() && isFunction(stack.peek())) {
                    output.add(stack.pop());
                }
            }
        }
        while (!stack.empty() && !stack.peek().equals("(")) {
            output.add(stack.pop());
        }
        if(!stack.empty()) throw new IllegalArgumentException("Mismatched parentheses");
        String[] out = new String[output.size()];
        return output.toArray(out);
    }
}
