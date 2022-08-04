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
    public ListNode reverseList(ListNode head) {
        //I will initialise prev with null
        ListNode prev = null;
        //I will initialise tempNode with null 
        ListNode tempNode = null;
        //I will initialise listNode of currentwith Head 
        ListNode current = head;
        
        while(current != null){
            //store the reference
            tempNode = current.next;
            //update current.next with prev
            current.next = prev;
            //update prev with current
            prev = current;
            //update current with tempNode
            current = tempNode;
        }
        //finally prev will be the new head after reversing so 
        return prev;
    }
}