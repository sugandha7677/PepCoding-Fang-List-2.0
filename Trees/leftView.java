public class leftView {

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer>list = new ArrayList<>();
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      
      preorder(root, 0);
      return list;
      
    }
    
    void preorder(Node root , int level) {
        if(root == null) return;
        
        if(level == list.size()) list.add(root.data);
        
        preorder(root.left, level + 1);
        preorder(root.right, level + 1);
    }

}
