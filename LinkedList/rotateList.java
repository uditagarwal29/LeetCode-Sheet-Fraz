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
    public int length(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
        
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ArrayList<ListNode> lastKnodes = new ArrayList<ListNode>();
        
        int len = length(head);
        
        //processing k;
        if(len==k){
            return head;
        }
        k = k%len; // rotations done length number of times result in same array after rotation
      
        
        ListNode kPtr = head;
        int tempLen = 1;
      //Moving pointer to the location just before the last node included in rotation, so that we can point it to null after it reaches end
        while(tempLen<=len-k-1){
            tempLen++;
            kPtr = kPtr.next; 
        }
        
        ListNode lastNode = kPtr;
        kPtr = kPtr.next;
      
        //fill arraylist with last k nodes
        while(kPtr!=null){
            lastKnodes.add(kPtr);
            kPtr=kPtr.next;
        }
        //rotating
        while(!lastKnodes.isEmpty()){
            ListNode tempNode = lastKnodes.get(lastKnodes.size() - 1);
            tempNode.next = head;
            head = tempNode;
            lastKnodes.remove(tempNode);
        }
        lastNode.next=null;
        return head;
    }
}
