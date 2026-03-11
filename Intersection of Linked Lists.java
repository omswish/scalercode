/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) return null;

        ListNode pA = A;
        ListNode pB = B;

        // Continue until the pointers meet
        while (pA != pB) {
            // Move pA to the next node, or switch to head of B if at the end
            pA = (pA == null) ? B : pA.next;
            
            // Move pB to the next node, or switch to head of A if at the end
            pB = (pB == null) ? A : pB.next;
        }

        // Either they meet at the intersection node or both are null
        return pA;
    }
}
