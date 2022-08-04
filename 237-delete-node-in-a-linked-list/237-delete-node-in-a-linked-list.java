/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //I just need to put swap condition here 
        node.val = node.next.val;
        //Now delete the next node (I will point the swapped node to the next of the node which got deleted)
        node.next = node.next.next;
    }
}