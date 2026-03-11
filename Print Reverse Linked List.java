import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public void solve(ListNode A) {
        if (A == null) return;

        // Using a Deque as an explicit stack to avoid StackOverflowError
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode curr = A;

        // Traverse forward and push values onto the stack
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        // Pop values from the stack (this gives them in reverse order)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        // Print a new line after the entire list is printed
        System.out.println();
    }
}
