public class SortedInsertCLL {
    public static Node sortedInsert(Node head,int data)
         {
            //add code here.
            Node newNode = new Node(data);
            
            if(head == null ) return newNode;
            
            else if(head.next == null) {
                newNode.next = head;
                head.next = newNode;
                return head;
            }
          
            Node temp = head.next; 
            Node curr = head;
            
            
            if( data < curr.data){
                
                while(temp.next != head){
                    temp = temp.next;
                }
                
                temp.next = newNode;
                newNode.next = head;
                return newNode;
                
            }else{
                while(temp.data < data){
                    curr = curr.next;
                    temp = temp.next;
                }
            
                newNode.next = temp;
                curr.next = newNode;
                return head;
            }
            
         
            
         }

         // TC: O(n)
         //SC: O(1)
}
