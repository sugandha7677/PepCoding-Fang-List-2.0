public class CopyRandomPointer {

    // A1.
    public Node copyRandomList(Node head) {

        // deep copy
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        Node nHead = curr;
        while (curr != null) {
            map.get(curr).next = curr.next != null ? map.get(curr.next) : null;
            map.get(curr).random = curr.random != null ? map.get(curr.random) : null;
            curr = curr.next;
        }
        return map.get(head);
    }

    // Tc: O(n)
    // SC: O(n)


    // A2. Optimised
    static Node copyRandomList(Node head) {
        Node temp = head;
       //step 1
       while(temp != null) {
           Node newNode = new Node(temp.val);
           newNode.next = temp.next;
           temp.next = newNode;
           temp = temp.next.next;
       }
       //step 2
       Node itr = head;
       while(itr != null) {
           if(itr.random != null)
               itr.next.random = itr.random.next;
           itr = itr.next.next;
       }
       //step 3
       Node dummy = new Node(0);
       itr = head;
       temp = dummy;
       Node fast;
       while(itr != null) {
           fast = itr.next.next;
           temp.next = itr.next;
           itr.next = fast;
           temp = temp.next;
           itr = fast;
       }
       return dummy.next;
   }
   // TC: O(n) + O(n) + O(n)
   // SC: O(1)


}
