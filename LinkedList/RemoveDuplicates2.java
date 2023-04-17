public class RemoveDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val) head = head.next;  
            }
            else{
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
            
        }
        
        
        prev.next = null;
        return dummy.next;
    }

    // tc: o(n)
    // sc: o(n)
}
