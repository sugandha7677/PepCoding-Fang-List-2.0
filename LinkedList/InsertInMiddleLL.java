public class InsertInMiddleLL {
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
        }
        if(head.next == null){
            head.next = newNode;
        }
        
        Node mid = findMid(head);
        
        newNode.next = mid.next;
        mid.next = newNode;
        
        return head;
    }
    
    Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
     
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
    // TC: O(n)
}
