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
    public ListNode deleteDuplicates(ListNode head) {
        //Initialise a dN to handle corner cases 
        ListNode dummyNode = new ListNode(-1);
        //point next of dn to head 
        dummyNode.next = head;
        //Initialise prev so that I can delete nodes using the pointer 
        //I will point prev to dN
        ListNode prev = dummyNode; 
        //currentNode will start from head so point it to current to head
        ListNode currentNode = head;
        
        //put while condition until and unless current is not null
        while(currentNode != null){
            //to get to know whether we have found a duplictae or not
            boolean flag = false;
            //we have to check whether next of currentNode exist or not (is it null or not) and whether currentnode and next of currentnodes value is equal or not 
            while(currentNode.next != null && currentNode.next.val == currentNode.val){
                flag = true;
                //I will keep iterating my currentNode to reach that last node 
                currentNode = currentNode.next;
            }
            if(flag){
                //if this while loop is getting executed that means current is going to point at the last duplicate value (e.g. 2 -> 2 -> 2 -> 3 [pointing at 2]) 
            //in that case we will update next of prev with current (here prev is not moving we are just pointing it)
            //and current will point to current.next
                prev.next = currentNode.next;
                currentNode = currentNode.next;
            }else{
                //if we havent found a duplicate set then we didnt go inside the while loop 
            //then prev will point to current 
            //and current will point to current.next
                prev = currentNode;
                currentNode = currentNode.next;       
            }     
        }
        //after this point I just need to return the head 
        return dummyNode.next;   
    }
}