import java.util.Stack;

public static class UserQueue {
    private static Stack<Integer> inputStack;
    private static Stack<Integer> outputStack;

    /** Initialize your data structure here. */
    UserQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    /** Push element X to the back of queue. */
    static void push(int X) {
        inputStack.push(X);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        shiftStacks();
        return outputStack.pop();
    }
    
    /** Get the front element of the queue. */
    static int peek() {
        shiftStacks();
        return outputStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    static boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    /** Helper function to move elements from input to output when needed */
    private static void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
