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
//O(nlogn) time and O(n) space  ->Merge Sort
class Solution {
     public ListNode sortList(ListNode head) {
         if(head==null || head.next==null){
            return head;
        }
        ListNode mid = middleNode(head);
        // ListNode a =  head;
        ListNode b = mid.next;
        mid.next=null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(b);
        
        return merge(l1,l2);
    }

    
    public ListNode merge(ListNode a, ListNode b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.val > b.val){
            b.next = merge(a,b.next);
            return b;
        }
        else{
            a.next = merge(a.next,b);
            return a;
        }
    }
    
    private ListNode middleNode(ListNode head) {
        ListNode fast = head.next;  // still doubt why not initalize fast with head
        ListNode slow = head;
        while(fast!=null && fast.next!=null){ 
            slow = slow.next;
            fast = fast.next.next;  
        }
        return slow;
    }
}
