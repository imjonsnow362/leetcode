//Initialise DLL here 
class DLLNode{
    String url;
    DLLNode next;
    DLLNode prev;
    //Initialise URL with constructor 
    DLLNode(String url){
        this.url = url;
    }
    
} 
class BrowserHistory {
    //Initially the head will pointing to null because we havent done any visit/forward operation once visit is performed we will point the head to the newNode
    DLLNode head = null;
    //Iterator will be used as a pointer to go forward or backward while using forward,backward,visit function accordingly check page 68,69 for explanation 
    DLLNode iterator = null;
    public BrowserHistory(String homepage) {
        //Whenever we are calling BrowserHistory we have to initialise our homepage 
        //We wil initialise head and pass the url(homepage) in the DLLNode
        head = new DLLNode(homepage);
        //I will point iterator to the head 
        iterator = head;
    }
    
    public void visit(String url) {
        //Whenever I am visiting I need to create a newNode 
        DLLNode newNode = new DLLNode(url);
        //Once I have made the new node I need to add it to the ll (aka attach it to the nodes)
        //increment iterator by 1 and point next of iterator to the newNode 
        //line 30 and 31 is to put a doubly link ←→ like this between two nodes
        iterator.next = newNode;
        newNode.prev = iterator;
        //after putting link then point iterator to the latest node
        iterator = newNode;
        //return;
    }
    
    public String back(int steps) {
        //There can be commands like go back 7 nodes and it is possible the ll does not have 7 nodes so once the iterator pointer reaches the node whos previous is null we just stop and return that node
        while(iterator.prev != null && steps > 0){
            //moving back
            iterator = iterator.prev;
            //this is just decrementing the count of steps till it reaches 0 thats why we have put it in while loop (steps is basically k here k can be the number which is given in the []square bracket)
            steps -= 1;
        }
        //after this while loop only one condition will be valid iterator.prev != null or steps > 0 so return the url of the node which iterator is pointing to
        return iterator.url;
    }
    
    public String forward(int steps) {
        //same going back logic for forward line 37
        while(iterator.next != null && steps > 0){
            //moving forward
            iterator = iterator.next;
            //this is just decrementing the count of steps till it reaches 0 thats why we have put it in while loop (steps is basically k here k can be the number which is given in the []square bracket)
            steps -= 1;
        }
        //after this while loop only one condition will be valid iterator.next != null or steps > 0 so return the url of the node which iterator is pointing to
        return iterator.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */