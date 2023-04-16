// 1. Iteratively

class Solution {
    public ListNode reverseList(ListNode head) {
        
        if( head == null){
            return null;
        }
        
        if( head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }
}

class   ListNode {
    int data;
    ListNode add;

    ListNode(int data){
        this.data = data;
        this.add = null;
    }
}

// TC: O(n)
// sc: O(1)

// 2. Recursively

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        return f(head, prev);
    }

    ListNode f(ListNode curr, ListNode prev) {
        if(curr.next == null ) {
            curr.next = prev;
            return curr;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        return f(temp, curr);
    }
}

// tc: o(n)
//sc: o(n)

//3. using addFirst()
public LisNode reverse(ListNode head){
    if(head == null || head.next == null) return head;

    ListNode temp = head;
    LisNode rev = null;

    while(temp != null) {
        LisNode node = temp;
        node.next = rev;
        rev = node;
        temp = temp.next;
    }

    return 

}