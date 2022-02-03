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
//O(n) time and O(1) space
class Solution {
    public int length(ListNode head){
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null){
            return true;
        }
        
        int len = length(head);
        
        //get mid
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){ //while fast ptr doesnt reach end of LL 
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = (len%2==0)? slow: slow.next;  //if LL is odd length move slow ptr to next node

        //reverse after mid/ reversing second half
        ListNode prev = null;
        ListNode next;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow = prev;  // slow is at starting of  the reversed second half of original LL
    
        //comparing first half of LL with reversed second half
        while(slow!=null){
            if(slow.val!=head.val){
                return false;
            }
            slow = slow.next;
            head=head.next;
        }

        return true;
        
    }
}
