public class RemoveDuplicates1 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        
        while(head != null){
            if(head.val != prev.val) {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        prev.next = null;
        return dummy.next;
    }

    // TC: O(n)
}
