/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public void solve(ListNode A) {
        ListNode current = A;
        
        // Traverse until the end of the list
        while (current != null) {
            // Print the value followed by a space
            System.out.print(current.val + " ");
            
            // Move to the next node
            current = current.next;
        }
        
        // Print a new line after the entire list is printed
        System.out.println();
    }
}
