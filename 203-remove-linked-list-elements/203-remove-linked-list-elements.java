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
    public ListNode removeElements(ListNode head, int val) {
        //Initialise a dummyNode to handle corner cases 
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode current = head;
        ListNode prev = dummyNode;
        //Until and unless we havent reached the end of the LL 
        while(current != null){
            //if the currentNode val is equal to the val 
            if(current.val == val){
                //prev pointer will point to the next of the node which will get deleted
                prev.next = current.next;
                //current pointer will point to the next node 
                current = current.next;
            }else{
                //otherwise prev will go to the current node and 
                prev = current;
                //current will iterate and move to the next node 
                current = current.next;
            }
        }
        return dummyNode.next;
            
    }
}