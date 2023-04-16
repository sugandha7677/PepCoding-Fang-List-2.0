public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null) return head;
        ListNode d1 = new ListNode(-1);
        ListNode small = d1;
        
        ListNode d2 = new ListNode(-1);
        ListNode big = d2;
        
        while(head != null){
            if(head.val < x){
                small.next = new ListNode(head.val);
                small = small.next;
            }else{
                big.next = new ListNode(head.val);
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = null;
        
        if(d1.next != null && d2.next == null){
            small.next = null;
            return d1.next;
        }else if(d1.next == null && d2.next != null){
            return d2.next;
        }else{
            small.next = d2.next;
            return d1.next;
        }
    }

    // TC: O(n)
    //SC: O(n)
}
