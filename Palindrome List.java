/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;

        // 1. Find the middle
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode secondHalfHead = reverse(slow.next);

        // 3. Compare the two halves
        ListNode p1 = A;
        ListNode p2 = secondHalfHead;
        int result = 1;
        
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = 0;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: Restore the list structure before returning
        // slow.next = reverse(secondHalfHead);

        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
