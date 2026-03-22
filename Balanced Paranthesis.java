import java.util.Stack;

public class Solution {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Handle closing brackets
            else {
                // If stack is empty, there's no opening bracket to match
                if (stack.isEmpty()) return 0;

                char top = stack.pop();
                if (!isMatch(top, c)) return 0;
            }
        }

        // If stack is empty, all brackets were matched correctly
        return stack.isEmpty() ? 1 : 0;
    }

    private boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
