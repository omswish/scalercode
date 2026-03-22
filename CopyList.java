public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode curr = head;
        
        // Step 1: Interleave nodes
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyCurr = dummy;
        curr = head;
        
        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            
            curr.next = curr.next.next; // Restore original
            curr = curr.next;
        }

        return dummy.next;
    }
}
