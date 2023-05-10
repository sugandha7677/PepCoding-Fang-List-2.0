class Solution {
     long ans = 0L;
     
    public long imgMultiply(Node root)
    {
        // code here
        if(root == null) return ans;
        
        ans += (root.data * root.data) % (long) (1e9 + 7);
        
        helper(root.left, root.right);
        
        return ans;
    }
    
    void helper(Node n1, Node n2){
        if(n1 == null || n2 == null) return;
        
        ans = ( ans + n1.data * n2.data)  % (long) (1e9 + 7);
        
        helper(n1.left, n2.right);
        helper(n1.right, n2.left);
    }
}