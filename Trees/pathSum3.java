public class pathSum3{

        public int pathSum(TreeNode root, int sum) {
            if(root == null)
                return 0;
            return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }
        
        int findPath(TreeNode root, long sum){
            int res = 0;
            if(root == null)
                return res;
            
            if(sum == root.val)
                res++;
            res += findPath(root.left, sum - root.val);
            res += findPath(root.right, sum - root.val);
            return res;
        }
        
        // TC: O(n ^ 2)
    
        // Better O(n)
        // using 2sum efficient approach

        int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        
        findPathSum(root, 0, targetSum, map);
        return total;
    }
    
    void findPathSum(TreeNode curr, long sum, int target, HashMap<Long,Integer> map){
        
        if (curr == null) return;
        
        sum += curr.val;
        
        if(map.containsKey(sum - target)) total += map.get(sum - target);
        
        map.put(sum , map.getOrDefault(sum , 0) + 1);
        
        findPathSum(curr.left, sum, target, map);
        findPathSum(curr.right, sum, target  , map);
        
        map.put(sum, map.get(sum) - 1);
        
    }
}