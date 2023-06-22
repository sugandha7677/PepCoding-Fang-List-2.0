

class BTColoringGame{

    int lc;
    int rc;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        // int lc = 0;
        // int rc = 0;
        
        countNode(root, x);
        
        int parent = n - lc - rc - 1;
        
        int max = Math.max(parent, Math.max(lc, rc));
        
        return max > (n / 2);
    }

    
    int countNode(TreeNode root, int x){
        if(root == null) return 0;
        
        int left = countNode(root.left, x);
        int right = countNode(root.right, x);
        
        if(root.val == x){
            lc = left;
            rc = right;
        }
        
        return left + right + 1;
    }
}