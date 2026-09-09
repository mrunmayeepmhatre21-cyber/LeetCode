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

 import java.util.*;
class Solution {
    //array solution
    private List<Integer> values;
    private Random rand;

    public Solution(ListNode head) {
        values = new ArrayList<>();
        while(head!=null){
            values.add(head.val);
            head = head.next;
        }
        rand = new Random();
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */