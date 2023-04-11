class   ListNode {
    int data;
    ListNode add;

    ListNode(int data){
        this.data = data;
        this.add = null;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next == null) return slow;
        return slow.next;
    }
}

// TC: O(n) // size of ll 
// SC: O(1)