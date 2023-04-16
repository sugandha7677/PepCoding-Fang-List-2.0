public class SegregateEvenOddNodes {

    public static ListNode segregateEvenOdd(ListNode head) {

        if(head == null || head.next == null) return head;
        
        ListNode nHead = new ListNode(-1);
        ListNode even = null;
        ListNode odd = null;
        ListNode ep = even;
        ListNode op = odd;
        
        
        while(head != null){
            ListNode node = removeFirst(head);
            if(node.val % 2 == 0){
                ep.next = new ListNode(node.val);
                ep = ep.next;
            }else {
                op.next = new ListNode(node.val);
                op = op.next;
            }
        }
        
        if(even == null) return odd.next;
        else {
            if(odd != null) ep.next = odd;
            return even.next;
        }
        
    }
    
    public static ListNode removeFirst(ListNode head){
        if(head == null || head.next == null) {
            ListNode node = head;
            head = null;
            return node;
        }
        ListNode  node = head;
        head = head.next;
        return node;
    }
    
}

// TC: O(n)
