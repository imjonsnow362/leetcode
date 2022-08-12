/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        //Now we will initialise a current here and point it to head
        ListNode current = head;
        //put condition until and unless current is not null 
        while(current != null){
            //It might be possible that the node is already present in the HashSet 
            if(seen.contains(current))
                return true;
            //otherwise we will add current in the HashSet and point current to current.next for iteration
            seen.add(current);
            current = current.next;
            
        }
        //if current is null anytime that means the ll does not have a cycle so just return false
        return false;
    }
}