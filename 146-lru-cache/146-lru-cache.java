class CdllNode{
    
    int key;
    int val;
    CdllNode prev;
    CdllNode next;
    
    CdllNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    
    CdllNode head = null;
    CdllNode tail = null;
    int maxSize = 0;
    int currentSize = 0;
    Map<Integer, CdllNode> cache;
    
    public LRUCache(int capacity) {
        //-①→←-① to make a doubly link between -1,-1 we use this code line 24,25 (check page 79)
        head = new CdllNode(-1, -1);
        tail = new CdllNode(-1, -1);
        //to create a circular link between the two nodes and normal doubly link between two nodes 
        head.next = tail;
        tail.prev = head;
        head.prev = tail;
        tail.next = head;
        
        cache = new HashMap<>();
        maxSize = capacity;
    }
    
    public int get(int key) {
        //First check whether it is present in the Map or not (the map name is cache)
        if(cache.containsKey(key)){
            //I will get the reference of that node using map.get(key)
            CdllNode currentNode = cache.get(key);
            //Once I have the node I need to delete it from that position and add it to the tail for line 42,43
            deleteNode(currentNode);
            addNodeAtTail(currentNode);
            //return the value of the node using key (in the map)
            return currentNode.val;
        }else{
            //return null or -1 because the node is not present in the map (it is given in description to return -1)
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //if we have reached maximum capacity 
        if(currentSize == maxSize){
            //again we have to check the same thing from line 75 
            if(cache.containsKey(key)){
                CdllNode currentNode = cache.get(key);
                deleteNode(currentNode);
                currentSize -= 1;
                cache.remove(key);
                
                // CdllNode newNode = new CdllNode(key, value);
                // addNodeAtTail(newNode);
                // cache.put(key, newNode);
                // currentSize += 1;
                //if the key is not present in the map I need to delete a node from the front because the capacity is maxed out so we delete the LRU node
            }else{
                CdllNode current = head.next;
                deleteNode(current);
                cache.remove(current.key);
                currentSize -= 1;
            }
            //create a node and put it 
            CdllNode newNode = new CdllNode(key, value);
            addNodeAtTail(newNode);
            cache.put(key, newNode);
            currentSize += 1;
        //if it is less then capacity 
        }else{
            //if the key is already present that means the app is already open so we will delete it from that position and put it at tail  
            if(cache.containsKey(key)){
                CdllNode currentNode = cache.get(key);
                deleteNode(currentNode);
                currentSize -= 1;
                cache.remove(key);
            }
            //if the key is new then we have to add it 
            CdllNode newNode = new CdllNode(key, value);
            addNodeAtTail(newNode);
            //add key to hashmap
            cache.put(key, newNode);
            currentSize += 1;
        }
    }
    
    private void addNodeAtTail(CdllNode newNode){
        newNode.next = tail;
        newNode.prev = tail.prev;
        newNode.prev.next = newNode;
        tail.prev = newNode;
    }
    
    private void deleteNode(CdllNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */