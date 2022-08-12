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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        
        //Initialise current and prev pointers 
        //Point current to head
        ListNode current = dummyNode;
        ListNode prev = null;
        //here we will iterate till left that means if left = 2 and right = 4
        //we will iterate till we reach index 2 in nodes
        for(int i=0; i < left; i++){
            //This is the method to iterate through the linkedlist
            //I will update prev with current
            prev = current;
            //I will keep updating current with next of iterating
            current = current.next;
        }
        //I will use a prev pointer because when the specific set of nodes are reversed I can point the prev node [i.e. the node which is before the first node which got reverse AKA left] to the new set of reversed nodes
        //I will point prev.next to the reverse set of nodes from left to right
        //Create a function reverseList and pass the head that is current and the no of nodes I want to reverse
        //We want to start reversing from current (e.g. current is pointing to 2)
        //Formula to find no of nodes to reverse is right - left + 1
        prev.next = reverseList(current, right-left+1);
        return dummyNode.next; 
    }
    //Passing currentNode as l and no of nodes to reverse as n
    private ListNode reverseList(ListNode l, int n){
        //Initialise ListNode of current with l 
        ListNode current = l;
        ListNode prev = null;
        //We put condition that until and unless current is not equal to null 
        //but we are reversing a small set of nodes so
        //check notebook page 41,42 to understand this for loop from point vii)
        for(int i = 0; i < n; i++){
            //Initialise a tempNode
            ListNode tempNode = current.next;
            //ListNode nextNode = current.next;
            //prev is pointing to null so current.next will point to null check reverse ll part 1 
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        //After this for loop n nodes are reversed
        //I want to set link to the remaining nodes after right so 
        l.next = current;
        //I want to return the head so I will return prev
        return prev; 
    }
}