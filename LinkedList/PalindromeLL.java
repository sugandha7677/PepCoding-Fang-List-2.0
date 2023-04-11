// brute 

// using left and right pointer
// left= 0;
// right = size -1
// get(left) == get(right)

// tc: o(n ^ 2)
// sc : o(1)

// better 

// using array ds

// store all data in array. reverse and check for pallindrome

// tc: o(n)
// sc: o(n)

// optimised

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // using recursion will cost o(n) space and o(n2) time
        
        if(head == null || head.next == null){
            return true;
        }
        // first reverse half part then check 

        // find mid 
        ListNode mid = midNode(head);
        
        // reverse
        ListNode newHead = mid.next;
        newHead = reverse (newHead);
        
        ListNode c1 = head;
        ListNode c2 = newHead;
        boolean res = true;
        while( c2 != null){

            if(c1.val != c2.val){
                res = false;
                break;
            }

            c1 = c1.next;
            c2 = c2.next;
        }
        // reverse back to restore the original ll
        newHead = reverse(newHead);
        mid.next = newHead;

      return res;

    }

    public ListNode midNode(ListNode head){

        if(head == null || head.next == null ){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head ){

        if( head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp1 = curr.next;
            curr.next = prev;
            prev =  curr;
            curr = temp1;
        }

        return prev;
    }
}

// tc: o(n/2) x 5
// sc: o(1)