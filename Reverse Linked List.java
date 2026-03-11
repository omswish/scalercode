/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode nextNode = null;

        while (curr != null) {
            // 1. Store the next node (so we don't lose the list)
            nextNode = curr.next;
            
            // 2. Reverse the current node's pointer
            curr.next = prev;
            
            // 3. Move pointers forward for the next iteration
            prev = curr;
            curr = nextNode;
        }

        // After the loop, 'prev' will be the new head of the reversed list
        return prev;
    }
}
