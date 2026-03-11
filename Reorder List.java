/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) return A;

        // Step 1: Find the middle of the list
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split and Reverse the second half
        ListNode secondHalf = slow.next;
        slow.next = null; // Terminate the first half
        ListNode prev = null;
        ListNode curr = secondHalf;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        // 'prev' is now the head of the reversed second half
        ListNode head2 = prev;
        ListNode head1 = A;

        // Step 3: Interleave/Merge the two halves
        while (head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }

        return A;
    }
}
