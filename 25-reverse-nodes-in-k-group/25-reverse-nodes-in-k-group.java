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
/*class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseLinkedListinKGroups(head, k);
    }
    
    private reverseLinkedListinKGroups(ListNode head, int k){
        //we will put the base condition here 
        if(head == null)
            return null;
        
        //first thing we are going to check whethere we are going to have a batch of size k 
        //we will create a function which will check whether we have ll of size k or not 
        Boolean check = validate(head, k);
        
        if(check){
            ListNode current = head;
            int currentLength = 1;
            
            while(current.next != null && currentLength < k){
                currentLength += 1;
                current = current.next;
            }
            
            ListNode tempNode = current.next;
            current.next = null;
            
            ListNode reversedList = reverseLinkedList(head);
            head.next = reverseLinkedListinKGroups(tempNode);
            return reversedList;
            
        }else{
            //this is the condition when the batch is less than k (like 2 nodes are there in the batch) so there is no need of reversing just return the head as it is
             return head;
        }
    }
    private ListNode validate(ListNode head, int k){
        //initialise current pointer with head
        ListNode current = head;
        //initialise length (we are initialising with node itself so we will start with 1)
        int currentLength = 1;
        //until and unless next of current is not null
        while(current.next != null && currentLength < k){
            //I will keep increasing currentLength by 1 
            currentLength += 1;
            //update current with current.next
            current = current.next;   
        }
        //finally if my cL is equal to k that means I have a list of size k so return it
        return currentLength == k;   
    }
    
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null){
            ListNode tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        return prev;
    }
}
*/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseGroups(head, k);
        
    }
    
    public ListNode reverseGroups(ListNode head, int k){
        
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        int currentLength = 1;
        
        while(current.next != null && currentLength < k){
            current = current.next;
            currentLength += 1;
        }
        
        if(currentLength < k){
            return head;
        }
        
        ListNode tempNode = current.next;
        current.next = null;
        
        ListNode tempList = reverseGroups(tempNode, k);
        
        ListNode prev = null;
        current = head;
        
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        
        head.next = tempList;
        
        return prev;
        
    }
    
}