import java.util.Stack;

public class Solution {
    public String solve(String A) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            // If operand, add to result
            if (Character.isLetter(c)) {
                result.append(c);
            } 
            // If '(', push to stack
            else if (c == '(') {
                stack.push(c);
            } 
            // If ')', pop until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } 
            // If operator
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && 
                       getPrecedence(stack.peek()) >= getPrecedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
}
