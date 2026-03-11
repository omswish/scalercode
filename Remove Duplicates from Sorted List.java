/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return null;
        }

        ListNode current = A;

        // Traverse the list as long as there is a next node to compare with
        while (current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found: link current node to the one after the duplicate
                current.next = current.next.next;
            } else {
                // No duplicate: move the pointer forward
                current = current.next;
            }
        }

        return A;
    }
}
