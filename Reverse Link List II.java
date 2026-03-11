/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || B == C) return A;

        // Dummy node to handle B = 1 cases gracefully
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode prev = dummy;

        // 1. Move prev to the node at position B-1
        for (int i = 0; i < B - 1; i++) {
            prev = prev.next;
        }

        // 2. Start is the first node of the segment to be reversed
        // 'then' is the node that will be moved to the front of the segment
        ListNode start = prev.next;
        ListNode then = start.next;

        // 3. Perform the reversal in one pass
        // We do this (C - B) times
        for (int i = 0; i < C - B; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
