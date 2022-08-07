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
    public boolean isPalindrome(ListNode head) {
        //corner case
        if(head == null || head.next == null)
            return true;
        
        //find out the middle node 
        ListNode midNode = middleNode(head);
        //now to divide the ll in two halves 
        //first after finding middle I will take middle in the left half
        //then I will point middle.next to null the ll will be divided 
        //to store the right half I will store in tempNode or righthalfNode
        ListNode rightHalf = midNode.next;
        midNode.next = null;
        ListNode leftHalf = head;
        //I want to check whether both the values are equal or not
        //Left half and reverse of right half 
        return compare(leftHalf, reverseList(rightHalf));
    }
    
    
        
    
    private boolean compare(ListNode leftHalf, ListNode rightHalf){
        //I want to compare node by node 
        //So I will initialise two pointers
        ListNode l1 = leftHalf;
        ListNode l2 = rightHalf;
        
        while(l1 != null && l2 != null){
            //in this case I will compare values by value 
            if(l1.val != l2.val)
                //If l1 is not equal to l2 just return false
                return false;
                //otherwise move to next node and compare
                l1 = l1.next;
                l2 = l2.next;
        }
        //if after this while loop you are not falling into this if condition that means the linkedlist is a panlindrome 
        return true;
    }   
    //otherwise I will find the middle node     
    private ListNode middleNode(ListNode head) {
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
        //we need to return the first mid node instead of second mid node in case of even
        return slwPtr;
    }
    
    private ListNode reverseList(ListNode head) {
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