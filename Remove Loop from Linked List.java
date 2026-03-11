/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode slow = A;
        ListNode fast = A;
        boolean hasCycle = false;

        // Step 1: Detect Cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // If no cycle exists, return the list as is
        if (!hasCycle) return A;

        // Step 2: Find the start of the cycle
        slow = A;
        // Special case: if the cycle starts at the head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Step 3: Break the cycle
        // 'fast' is currently at the node just before the cycle start
        fast.next = null;

        return A;
    }
}
