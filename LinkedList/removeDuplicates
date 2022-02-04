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
    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-999);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = prev.next;
        int repeatval = -999; // to store the current repeating value
        while(curr.next!=null){ 
            
            //following if loop removes all the repeating nodes of a node
            //eg 1->1->1->2 will be made 1->2
            //we need to remove 1 too while will be done at bottom of while loop
            if(curr.next.val == curr.val){
                repeatval = curr.val;
                curr.next = curr.next.next;
            }
            // we need to remove that last 1 too
            
            //this is a special case loop, for repeating values are at end of LL
            //eg 1->2->3->3->3, we make it 1->2->3 and then break
            //if loop outside while take care of the last 3
            if(curr.next==null){
                break;
            }
            
            //move pointer or not?
            // we only move curr pointer if next nodes dont have same value as curr
            if(curr.val!=curr.next.val ){
                //this if loop is to remove the last node whose values were repeating
                //e.g 1->1->1->2->3 was made 1->2->3, we remove the last 1 here
                //to make it 2->3
                if(repeatval == curr.val){
                    prev.next = curr.next;
                    curr = prev.next;
                    repeatval = -999;
                }
                else{
                    // if there were no repeating values , we simply move the prev and curr                         pointer
                     prev = prev.next;
                     curr = prev.next;
                }
            }
        }
        
        //this is for case 1->2->3->3->3, in the while loop before it was made 1->2->3
        //we remove the last 3 here
        if(repeatval != -999){
            prev.next = null;
        }
        return dummy.next;       
    }
}
