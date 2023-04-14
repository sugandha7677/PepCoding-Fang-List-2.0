class Solution {

    // A1: with counting length of LL
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode temp = head;
        ListNode temp1 = head;

        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;

        }

        if (len == n ){
            head =head.next;
            return head;
        }

        int i = 1;
        while (i < len - n){
            temp1 = temp1.next;
            i++;
        }

        temp1.next = temp1.next.next;
        return head;
    }

    // TC: O(n) + O(n)

    // without counting

    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        int k = 0;
        while(k < n ){
            fast = fast.next;
            k++;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return start.next;
    }

    // TC: O(n)

}
