/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // Continue if A has nodes, B has nodes, or there's a leftover carry
        while (A != null || B != null || carry != 0) {
            int val1 = (A != null) ? A.val : 0;
            int val2 = (B != null) ? B.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            // Create the next digit node
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // Move original list pointers forward
            if (A != null) A = A.next;
            if (B != null) B = B.next;
        }

        return dummy.next;
    }
}
