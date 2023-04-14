class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = findMid(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        ListNode c1 = sortList(head);
        ListNode c2 = sortList(nHead);
        return mergeTwoLists(c1, c2);
    }

     public static ListNode findMid(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        
        if(l2 == null) return l1;
        
        ListNode head = null;
        if(l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        }
        else {
            head = l2;
            l2 = l2.next;
        }
        
        ListNode prev = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null ) prev.next = l1;
        if(l2 != null) prev.next = l2;
        
        return head;
    }

}

// TC: O(nlogn)