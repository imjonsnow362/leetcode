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
        if(head == null)
            return null;
        
        ListNode fastPtr = head;
        ListNode slwPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slwPtr = slwPtr.next;
        }
        return slwPtr;
    }
}