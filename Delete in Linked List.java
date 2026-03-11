/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        // Handle the case where the list is empty (though constraints say size >= 1)
        if (A == null) return null;

        // Case 1: Deleting the head node (Position 0)
        if (B == 0) {
            return A.next;
        }

        // Case 2: Deleting a node at position B
        ListNode current = A;
        int count = 0;

        // Traverse until we reach the node at position B-1
        while (current != null && count < B - 1) {
            current = current.next;
            count++;
        }

        // If current is not null and the node to delete exists
        if (current != null && current.next != null) {
            // Skip the B-th node
            current.next = current.next.next;
        }

        return A;
    }
}
