/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        // Base case: if list is empty or has only one node
        if (A == null || A.next == null) {
            return A;
        }

        // Create a dummy node to act as the predecessor of the head
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        
        ListNode prev = dummy;

        // Ensure there are at least two nodes left to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Execute the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev forward: now it should point to 'first'
            // because 'first' is the second element of the swapped pair
            prev = first;
        }

        return dummy.next;
    }
}
