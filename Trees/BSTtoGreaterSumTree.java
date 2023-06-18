
public class BSTtoGreaterSumtree{
int inordersum = 0;
    public TreeNode bstToGst(TreeNode root) {
        
        f(root);
        return root;
    }
    
    void f(TreeNode root){
        if(root == null) return;
        
       
        
        f(root.right);
        root.val += inordersum;
        inordersum = root.val;
        f(root.left);
        
    }
}