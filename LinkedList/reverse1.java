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
    

    public ListNode reverseList(ListNode head) {
        if(head==null ||head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // Node nextHead = head.next;
        // nextHead.next = head.next;
        // above two lines can be written in one line
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
