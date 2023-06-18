
public class FlattenBTtoLL {
    
    Stack<TreeNode> st = new Stack<>();
    public void flatten(TreeNode root) {
      
        if(root == null) return;
        f(root);
        
        TreeNode head = new TreeNode(0);
        TreeNode prev = head;
        while(!st.isEmpty()){
            prev.right = st.pop();
            prev.left = null;
            prev = prev.right;
        }
        
       root = head.right;
    }
    
    
    void f(TreeNode root){
        if(root == null) return;
        
        f(root.right);
        f(root.left);
        st.add(root);
    }
}
