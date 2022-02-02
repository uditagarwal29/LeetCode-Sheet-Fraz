// https://leetcode.com/problems/middle-of-the-linked-list/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){ //while fast ptr doesnt reach end of LL 
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
