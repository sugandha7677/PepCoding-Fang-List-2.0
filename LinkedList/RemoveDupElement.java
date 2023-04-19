public class RemoveDupElement {
    Node removeDuplicates(Node head)
    {
	// Your code here
	Node dummy = new Node(-1);
	Node prev = dummy;
	Node curr = head; 
	
	while( curr != null){
	    if(prev.data == curr.data){
	        curr = curr.next;
	    }
	    else{
	        prev.next = curr;
	        curr = curr.next;
	        prev = prev.next;
	    }
	}
	
	prev.next = null;
	return dummy.next;
    }

    // TC: O(N)
    // SC: O(1)
}
