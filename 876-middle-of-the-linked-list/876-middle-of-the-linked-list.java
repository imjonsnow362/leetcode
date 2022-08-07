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
        //To handle corner case when there is no node
        if(head == null)
            return null;
        //Initialise fastPtr and slowPointer pointing to head 
        ListNode fastPtr = head;
        ListNode slwPtr = head;
        //we will put condition for fast pointer since fast pointer is 2times faster than slow pointer then we will put .next and .next.next 
        while(fastPtr.next != null && fastPtr.next.next != null){
            //Once the while condition satisifies I will update fp and sp to these
            //fastPointer moves 2x faster than slowPointer so we put those conditions 
            //fp 2 and sp 1
            fastPtr = fastPtr.next.next;
            slwPtr = slwPtr.next;
        }
        //we need to make corner case for even length ll 
        //if fp.next is not null it indicates it is even
        if(fastPtr.next != null)
            //this is the middle of the ll  
            return slwPtr.next;
        
        return slwPtr;
    }
}