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
    public ListNode sortList(ListNode head) {
        //put edge case if there is one node in the linked list or no node in the linked list we dont need to do anything (why because the ll is already sorted)
        if(head == null || head.next == null)
            return head;
        
        //we need to find the mid node
        //use fp and sp approach 
        ListNode fastPtr = head;
        ListNode slwPtr = head;
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slwPtr = slwPtr.next;
        }
        
        //We want to divide this ll 
        //So slwPtr.next is considered as the middle value so right half will start from there 
        ListNode rightHalf = slwPtr.next;
        //We need to split the left and right half so by pointint slwPtr/mid to null the ll will be cut in two halves 
        slwPtr.next = null;
        //We will define leftHalf
        ListNode leftHalf = head;
        
        //Now we need to keep doing iteration till we dont hit null condition 
        ListNode leftSortedList = sortList(leftHalf);
        ListNode rightSortedList = sortList(rightHalf);
        
        //once the iteration hits base condition i.e when one node is left check page 48
        return mergeLinkedList(leftSortedList, rightSortedList);
    }
    
    //make merge ll function here 
    public ListNode mergeLinkedList(ListNode list1, ListNode list2) {
        //We will create a dummyNode with head node having value -1
        ListNode dummyNode = new ListNode(-1);
        //Result pointer will point to dummy Node
        ListNode result = dummyNode;
        
        //Initialise two pointer p1 and p2 pointing to list1 and list2 
        ListNode p1 = list1;
        ListNode p2 = list2;
        //Check key point 5 on page 15 of notebook 
        //Only if the pointer is not null we will compare the value 
         while(p1 != null && p2 != null){
             //compare the values
             if(p1.val < p2.val){
                 //I will create a newNode in the resultant linkedList and put the value which is smaller compared to p1 and p2 
                 ListNode newNode = new ListNode(p1.val);
                 //I will set it with the below condition because we want to print the newnode in the next node present 
                 result.next = newNode;
                 //The result pointer is still pointing to the previous node so we need to move it to the latest pointer which is added otherwise it will not print the other nodes in the correct place 
                 result = result.next;
                 //We will increment the p pointer based on the last added in resultant LL (if p1 was added then we will move p1 to next node in list1)
                 p1 = p1.next;     
             }
             //In this else part we will do the opposite of this for p2 pointer 
             else{
                 ListNode newNode = new ListNode(p2.val);
                 result.next = newNode;
                 result = result.next;
                 p2 = p2.next;
                 }
             }
             //When one of the pointer is pointing to null that indicates that one of the LL is completely empty.This means we have processed all nodes.Check page 15 key point 5 
             //So whatever nodes are left we just need to add them in the pointer 
             if(p1 != null)
                 result.next = p1;
             if(p2 != null)
                 result.next = p2;
             
             return dummyNode.next;
    }
}