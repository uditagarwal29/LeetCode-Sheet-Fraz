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
    
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = prev.next;
        ListNode after = curr.next;
        while(after!=null ){
            //swap
            curr.next = after.next;
            prev.next = after;
            after.next = curr;
            //update pointers
            prev = curr;
            if(prev.next==null){
                //for boundary value, i.e end of LL
                break;
            }
            curr = prev.next;
            after = curr.next;
        }
        
        return dummy.next;
        
    }
}
