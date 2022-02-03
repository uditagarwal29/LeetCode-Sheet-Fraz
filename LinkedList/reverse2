
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

//O(n) time , o(left -right) space
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode dummy = new ListNode(0); // doing this in case of input of length 2
                                        // we need to initialize leftPtr with 0,i.e a node before  the node from which reversing starts
        dummy.next = head;
        ListNode leftPtr = dummy; 
        int leftjump = 1;
        while(leftjump< left ){
            leftjump++;
            leftPtr = leftPtr.next;
        }

        ListNode curr = leftPtr.next;
        ListNode nxt = curr.next;
        for(int i=0;i<right-left;i++){
            curr.next = nxt.next; //1->2->-3->4 , connect 2->4
            nxt.next = leftPtr.next; //1->2->4  3 , connect 3->2 to make  1 3->2->4
            leftPtr.next = nxt; // connect 1 to 3 ,i.e 1->3->2->4
            nxt = curr.next; //move current node forward
        }
        
        return dummy.next;
    }
}
//O(n) time , o(left -right) space
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int leftjump = 1;
        ListNode leftPtr = head;
        while(leftjump< left){
            leftjump++;
            leftPtr = leftPtr.next;
        }
        
        ListNode leftPtemp = leftPtr;
        
        ArrayList<Integer> ele = new ArrayList<Integer>();
        while(leftjump<=right){
            ele.add(0,leftPtr.val);
            leftPtr = leftPtr.next;
            leftjump++;
        }
        
        while(left<=right){
            leftPtemp.val = ele.get(0);
            leftPtemp = leftPtemp.next;
            ele.remove(0);
            left++;
        }
        
        
        return head;
    }
}
