import java.util.Stack;

public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (c == ')') {
                int operatorCount = 0;
                
                // Pop until we find the opening brace
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorCount++;
                    }
                }
                
                // Pop the '(' itself
                stack.pop();

                // If no operator was found between ( and ), it's redundant
                if (operatorCount == 0) {
                    return 1;
                }
            } else {
                // Push everything else: '(', operators, and operands
                stack.push(c);
            }
        }

        return 0;
    }
}
