/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // Create a dummy node to simplify the head management
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Traverse both lists while they both have elements
        while (A != null && B != null) {
            if (A.val <= B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes of the non-empty list
        if (A != null) {
            tail.next = A;
        } else if (B != null) {
            tail.next = B;
        }

        // The actual head is the node following the dummy
        return dummy.next;
    }
}
