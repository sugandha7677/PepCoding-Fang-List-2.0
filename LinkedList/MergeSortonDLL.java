public class MergeSortonDLL {
    
    // A1. With extra space
    static Node sortDoubly(Node head)
    {
        // add your code here
        if(head == null || head.next == null) return head;
        
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        
        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        
        int i =0;
        
        while(temp != null){
            temp.data = list.get(i++);
            temp = temp.next;
        }
        
        return head;
    }
    // TC: O(n) + O(n) + O(nlogn)
    // SC: O(n)


    //A2. without extra space
    static Node sortDoubly(Node head)
    {
        // add your code here
        if(head == null || head.next == null) return head;
        
        Node mid = findMid(head);
        
        Node nHead = mid.next;
        mid.next = null;
        nHead.prev = null;
        
        Node l1 = sortDoubly(head);
        
        Node l2 = sortDoubly(nHead);
        
        Node l = mergeSort(l1, l2);
        
        return l;

    }
    
    static Node findMid(Node head){
        if(head == null || head.next == null) return head;
        
        
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
        
    }
    
    static Node mergeSort(Node l1, Node l2) {
        if(l1  == null || l2 == null) return l1 == null ? l2 : l1;
        
        Node l = new Node(-1);
        if(l1.data <= l2.data) {
            l = l1;
            l1 = l1.next;
        }else{
            l = l2;
            l2 = l2.next;
        }
        
        l.prev = null;
        Node temp = l;
        
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                temp.next = l1;
                l1.prev = temp;
                temp = temp.next;
                l1= l1.next;
            }else{
                temp.next = l2;
                l2.prev = temp;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1 == null && l2 != null){
            temp.next = l2;
            l2.prev = temp;
        }
        if(l1 != null && l2 == null){
            temp.next = l1;
            l1.prev = temp;
        }
        return l;
    }
    // TC: O(n log n)
    // SC: O(1)
}
