/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) {
        ListNode current = A;
        int count = 0;

        // Traverse the list until we reach the B-th index
        while (current != null) {
            if (count == B) {
                return current.val;
            }
            current = current.next;
            count++;
        }

        // Based on constraints, B is always valid, 
        // but returning 0 or -1 is a safe fallback.
        return -1; 
    }
}
