// https://leetcode.com/problems/add-two-numbers/submissions/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ans_ptr = ans;
        int sum=0, carry =0;
        while(l1!=null && l2!=null){
            int digSum = l1.val + l2.val + carry;
            //check if digSum >9 --> Yes? calculate carry
            if(digSum>9){
                ans_ptr.next = new ListNode(digSum -10);
                carry = 1;
            }
            else{
                ans_ptr.next= new ListNode(digSum);
                carry = 0;
            }
            l1 = l1.next;
            l2=l2.next;
            ans_ptr = ans_ptr.next;
        } 
        
        ListNode remain = l1==null? l2:l1; //no error -> defines remain in the current global scope
        
        //if else gives error as the scope of remain ListNode is only for if else,
        //it cant be used in next while loop if its local
        if(l1==null){
            ListNode remain = l2;
        }
        else{
            ListNode remain  = l1;
        }
      
        if(remain!=null){
            while(remain!=null){
            int digSum = carry + remain.val;
            if(digSum>9){
                ans_ptr.next = new ListNode(digSum -10);
                carry = 1;
            }
            else{
                ans_ptr.next= new ListNode(digSum);
                carry = 0;
            }
                ans_ptr = ans_ptr.next;
                remain = remain.next;
        }
        }
        
         if(carry==1){
            ans_ptr.next= new ListNode(1);
        }
        
        return ans.next;
    }
}
