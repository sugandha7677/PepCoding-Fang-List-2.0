class LRUCache {
    
    Node head = new Node(0, 0);
    Node tail = new Node(0 , 0);
    
    int cap;
    
    HashMap<Integer, Node > map = new HashMap<>();
    

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public void addNode(Node newNode){
        map.put(newNode.key, newNode);
        newNode.next = head.next;
        head.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
    }
    
    public void deleteNode(Node delete){
        map.remove(delete.key);
        Node delprev = delete.prev;
        Node delnext = delete.next;
        
        delprev.next = delnext;
        delnext.prev = delprev;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            
            deleteNode(resNode);
            addNode(resNode);
        
            return resNode.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node existingNode = map.get(key);
            // erase from map
            
            deleteNode(existingNode);
        }
        if(map.size() == cap){
            // erase tail.prev.key
            deleteNode(tail.prev);
        }
        
        Node newNode = new Node(key, value);
        addNode(newNode);
        
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    Node(int key , int val){
        this.key = key;
        this.val = val;
    }
}