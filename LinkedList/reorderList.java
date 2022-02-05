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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return;
        }
        //finding the mid point -> nodes after this have to be reordered
        ListNode mid = middleNode(head); 
        
        //reverse after mid node (or use stack)
        //1->2->3->4->5->6->7 = 1->2->3->4->7->6->5
        ListNode curr = mid.next;
        ListNode nxt = curr.next;
        while(curr.next!=null ){
            curr.next = nxt.next;
            nxt.next = mid.next;
            mid.next = nxt;
            nxt = curr.next;
        }
        
        // partitioning list into 2 parts :
        //Part 1) 1->2->3->4->null   <- this has a start pointer and mid as end pointer
        //Part 2) 7->6->5->null  <- this has a start pointer
        ListNode start = head;
        ListNode end = mid;
        ListNode start2 = mid.next;
        mid.next=null; //making end pointer of part 1 point to null
        
        //reordering
        // start element from part 2 of list is taken and placed in part 1
        while(start2!=null){
            ListNode temp = start2;
            start2 = start2.next;
            temp.next = start.next;
            start.next = temp;
            start = temp.next;
        }
    }
}
