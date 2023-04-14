public class UnfoldofLL {

    public static void unfold(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode fh = head;
        ListNode sh = head.next;
        
        ListNode fp = head;
        ListNode sp = head.next;
        
        while(sp != null && sp.next != null ){
            // backup
            ListNode f = sp.next;
            
            // link
            fp.next = f;
            sp.next = f.next;
            
            // move
            fp = fp.next;
            sp = sp.next;
            
        }
        fp.next = null;
        sh = reverse(sh);
        fp.next = sh;
          
    }
  
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
}

// TC: O(n)
// TC of reverse() --> O(n/2)
// O(n) + O(n/2) = O(n)
