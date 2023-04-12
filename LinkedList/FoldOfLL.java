// step1. find mid and reverse right half
 // step2. use 2 pointer 
 class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode rev = reverse(mid.next);
        mid.next = null;

        ListNode c1 = head;
        ListNode c2 = rev;

        while(c1 != null && c2 != null) {
            ListNode temp = c1.next;
            ListNode temp1 = c2.next;
            c1.next = c2;
            c2.next = temp;
            c1 = temp;
            c2 = temp1;
        }

    }

    ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
