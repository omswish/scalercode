/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A) {
        if (A == null) return -1;

        ListNode slow = A;
        ListNode fast = A;

        // Move fast pointer twice as fast as the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches the end, slow is at the middle
        return slow.val;
    }
}
