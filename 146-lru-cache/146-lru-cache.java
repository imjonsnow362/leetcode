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
        head = new CdllNode(-1, -1);
        tail = new CdllNode(-1, -1);

        head.next = tail;
        tail.prev = head;
        head.prev = tail;
        tail.next = head;

        cache = new HashMap<>();
        maxSize = capacity;
    }
    
    public int get(int key) {
        
        if(cache.containsKey(key)){
            CdllNode currentNode = cache.get(key);
            deleteNode(currentNode);
            addNodeAtTail(currentNode);
            return currentNode.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(currentSize == maxSize){
            
            if(cache.containsKey(key)){
                CdllNode currentNode = cache.get(key);
                deleteNode(currentNode);
                currentSize -= 1;
                cache.remove(key);
                
            }else{
                CdllNode current = head.next;
                deleteNode(current);
                cache.remove(current.key);
                currentSize -= 1;
            }
            
            CdllNode newNode = new CdllNode(key, value);
            addNodeAtTail(newNode);
            cache.put(key, newNode);
            currentSize += 1;
            
        }else{
            
            if(cache.containsKey(key)){
                CdllNode currentNode = cache.get(key);
                deleteNode(currentNode);
                currentSize -= 1;
                cache.remove(key);
            }
            
            CdllNode newNode = new CdllNode(key, value);
            addNodeAtTail(newNode);
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