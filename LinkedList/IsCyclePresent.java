import java.util.HashSet;

public class IsCyclePresent {

    // A1. hashing of nodes
    public boolean hasCycle(ListNode head){
        HashSet<ListNode> set = new HashSet<>();

        while(head != null){
            if(set.contains(head)) return true;

            set.add(head);
            head = head.next;
        }

        return false;
    }

    // TC: O(n)
    // SC :O(n)

    //A2. 
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
