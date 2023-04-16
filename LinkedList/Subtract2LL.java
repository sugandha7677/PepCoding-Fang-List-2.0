public class Subtract2LL {
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
  
    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        
        ListNode l1 = reverse(l1);
        ListNode l2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode iter= dummy;
        
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int diff = 0;
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            
            n1 -= carry;
            
            if(n1 - n2 < 0){
                diff = n1 + 10 - n2;
                carry = -1;
            }else {
                diff = n1 - n2;
                carry = 0;
            }
            
            iter.next = new ListNode(diff);
            iter = iter.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
      return reverse(dummy.next);
    }
}

// TC: O(n)
// SC: O(n)
