class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0 ) return head;
        
        int len = length(head);
        
        ListNode oh = null;
        ListNode ot = null;
        
        ListNode curr = head;
        while(len >= k){
            int temp = k;
            while(temp-- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }
            else{
                ot.next = th;
                ot = tt;
            }
            
            th = null;
            tt = null;
            
            len -= k;
        }
        ot.next = curr;
        return oh;
          
    }
    
    public int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        return len;
    }
    
    ListNode th = null;
    ListNode tt = null;
    public void addFirst(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
}

// TC: O(n)
// SC: O(n)
