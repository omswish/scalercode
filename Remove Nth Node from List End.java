/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) return null;

        ListNode fast = A;
        ListNode slow = A;

        // 1. Move fast pointer B steps ahead
        for (int i = 0; i < B; i++) {
            fast = fast.next;
            // If B is >= size of list, remove the head
            if (fast == null) {
                return A.next;
            }
        }

        // 2. Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. Skip the target node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return A;
    }
}
