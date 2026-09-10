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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode tail = dummy;
        int maxSoFar = Integer.MIN_VALUE;

        while(curr!=null){
            if(curr.val >= maxSoFar){
                maxSoFar = curr.val;
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        tail.next = null;
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}