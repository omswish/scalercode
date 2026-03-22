import java.util.Stack;

class Solution {
    // Main stack to store all elements
    private Stack<Integer> mainStack = new Stack<>();
    // Auxiliary stack to store the minimums
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        
        // If minStack is empty, x is the current minimum
        // Otherwise, push the smaller of x and current min
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
