/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, ListNode B) {
        ListNode currA = A;
        ListNode currB = B;

        // Traverse both lists as long as both have nodes
        while (currA != null && currB != null) {
            // Check if values at the current position are different
            if (currA.val != currB.val) {
                return 0;
            }
            
            // Move both pointers forward
            currA = currA.next;
            currB = currB.next;
        }

        // After the loop, both pointers must be null for the lists to be identical.
        // If one is null and the other isn't, the lengths were different.
        if (currA == null && currB == null) {
            return 1;
        } else {
            return 0;
        }
    }
}
