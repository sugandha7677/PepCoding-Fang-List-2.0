public static ListNode reverse(ListNode head){
    if(head == null || head.next == null) return head;
    
    ListNode curr = head;
    ListNode prev = null;
    while(curr != null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }
    return prev;
}

public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null || l2 == null) return l1 == null ? l2: l1;
    
    ListNode l1 = reverse(l1);
    ListNode l2 = reverse(l2);
    ListNode dummy = new ListNode(-1);
    ListNode iter = dummy;
    
    int carry = 0;
    while(l1 != null && l2 != null){
        
        int sum = l1.val + l2.val + carry;
        iter.next = new ListNode(sum % 10);
        carry = sum / 10;
        iter = iter.next;
        
        l1 = l1.next;
        l2 = l2.next;
    }
    
    while(l1 != null){
        int sum = l1.val + carry;
        iter.next = new ListNode(sum % 10);
        carry = sum / 10;
        iter = iter.next;
        
        l1 = l1.next;
    }
    
    while(l2 != null){
        int sum = l2.val + carry;
        iter.next = new ListNode(sum % 10);
        carry = sum / 10;
        iter = iter.next;
        
        l2 = l2.next;
    }
    if(carry > 0){
        iter.next = new ListNode(carry);
        iter = iter.next;
    }
    
    return reverse(dummy.next);
}

// TC: O(n) + O(m)
// sc: O(max length(n, m) + 1)