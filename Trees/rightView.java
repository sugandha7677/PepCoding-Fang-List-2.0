public class rightView {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        if( root == null ) return ans;
        reversePreorder( root , 0);
        return ans;
    }

    public void reversePreorder(TreeNode node , int level){
        if( node == null) return;

        if(level == ans.size()) ans.add(node.val);
        reversePreorder(node.right , level + 1);
        reversePreorder(node.left , level + 1);
    }
}
