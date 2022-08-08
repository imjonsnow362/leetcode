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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Initialise a runner pointer that is going to point to head
        ListNode runner = head;
        //Initialise a dummyNode
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        
        for(int i=1; i < n; i++)
            //I want to move my runner to the next node
            runner = runner.next;
        
        //So I have moved my runner n times 
        //I need to initialise a follower pointer that is going to point to dummyNode
        ListNode follower = dummyNode;
        //Till my runner.next does not become null
        //We will keep moving 
        while(runner.next != null){
            runner = runner.next;
            follower = follower.next;
        }
        //Once we come out of this while loop we know that We are pointng to node we want to delete 
        //Check notebook page 35 bottom right for logic 
        follower.next = follower.next.next;
        return dummyNode.next;
    }
}