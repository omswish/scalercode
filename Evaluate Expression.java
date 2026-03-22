import java.util.Stack;

public class Solution {
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();

        for (String s : A) {
            if (isOperator(s)) {
                // The order of popping matters for subtraction and division
                int val2 = stack.pop(); // Right operand
                int val1 = stack.pop(); // Left operand
                
                int result = calculate(val1, val2, s);
                stack.push(result);
            } else {
                // It's a number, push to stack
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calculate(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division as per standard RPN
            default: return 0;
        }
    }
}
