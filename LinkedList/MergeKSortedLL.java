// Approach 1: Divide and conquer 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0){
            return null;
        }
        return mergeKLists(lists , 0 , lists.length - 1);

    }

    public ListNode mergeKLists(ListNode[] lists , int si , int ei){
        // using divide and conquer technique

        
        if(si  > ei){
            return null;
        }
        if(si == ei ){
            return lists[si];
        }


        int mid = (si + ei ) / 2;
        ListNode l1 = mergeKLists(lists , si ,mid);
        ListNode l2 = mergeKLists(lists , mid + 1 ,ei);

        return mergeTwoLL(l1,l2);
    }

    public ListNode mergeTwoLL(ListNode l1 , ListNode l2 ){

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

// TC: O(n k logK)

// A2: using PQ

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x,y)-> x.val - y.val);

        for(ListNode l : lists){
            if(l != null )pq.add(l);
        }

        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while(!pq.isEmpty()) {
            ListNode p = pq.remove();
            prev.next = p;
            prev = prev.next;

            if(p.next != null) pq.add(p.next);

        }

        return head.next;
    }
}

// TC: O(n k log k)
