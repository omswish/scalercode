/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) {
        ListNode curr = A;
        
        // Traverse the list until we hit the end (null)
        while (curr != null) {
            // Check if the current node's value matches the target B
            if (curr.val == B) {
                return 1; // Value found
            }
            
            // Move to the next node in the sequence
            curr = curr.next;
        }
        
        // If we exit the loop, the value was not in the list
        return 0;
    }
}
