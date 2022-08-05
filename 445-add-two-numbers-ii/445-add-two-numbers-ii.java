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
        //add two ll in reverse in the bracker reverse ll and then add 
        //and print the answer in reverse so use reverseList again 
        return reverseList(addTwoNumbersinReverse(reverseList(l1), reverseList(l2)));
        
    }
    //Just add reverse LL code here as function 
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
    //Add Add two number code here as function 
    public ListNode addTwoNumbersinReverse(ListNode l1, ListNode l2) {
        //I will initialise a dummyNode 
        ListNode dummyNode = new ListNode(-1);
        //Point result node to dummyNode
        ListNode result = dummyNode;
        //Initialise a carry flag 
        int carry = 0;
        //Until and unless l1 and l2 are not equal to null 
        while(l1 != null && l2 != null){
            //if both are not null then there are no issues 
            //create a new node with this value and perform addition 
            int currentVal = l1.val + l2.val + carry;
            //if the value of that division is greater than or equal to 10 carry will be set to 1 otherwise 0 
            carry = currentVal / 10;
            
            ListNode newNode = new ListNode(currentVal % 10);
            //next of result will be set with newNode
            result.next = newNode;
            //update result with result.next
            result = result.next;
            //update p1 and p2 with next meaning move to next node 
            l1 = l1.next;
            l2 = l2.next;
        }
        //after all this lets say that any of the linkedlist is not empty 
        while(l1 != null){
            int currentVal = l1.val + carry;
            carry = currentVal/10;
            ListNode newNode = new ListNode(currentVal % 10);
            result.next = newNode;
            result = result.next;
            l1 = l1.next;
        }
        
        //after these two while loops if l1 is empty and l2 is not then run for l2
        while(l2 != null){
            int currentVal = l2.val + carry;
            carry = currentVal/10;
            ListNode newNode = new ListNode(currentVal % 10);
            result.next = newNode;
            result = result.next;
            l2 = l2.next;
        }
        //finally lets say both linked list are empty but carry flag is not empty so 
        if(carry == 1)
            result.next = new ListNode(1);
        
        return dummyNode.next;   
    }
}