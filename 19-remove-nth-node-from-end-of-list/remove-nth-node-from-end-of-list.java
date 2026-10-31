/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Step 3: Move fast n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 4: Move both until fast becomes null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 5: Delete the target node
        slow.next = slow.next.next;

        // Step 6: Return updated head
        return dummy.next;
    }
}