class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, target, k, ans);
        return ans;
    }

    public int dfs(TreeNode node, TreeNode target, int k, List<Integer> ans){

        if(node == null) return -1;

        if(node == target){
            kLevelDown(node, k, ans, null);
            return 1;
        }

        int left = dfs(node.left, target, k, ans);

        if(left != -1){
            kLevelDown(node, k-left, ans, node.left);
            return left + 1;
        }

        int right = dfs(node.right, target, k, ans);

        if(right != -1){
            kLevelDown(node, k-right, ans, node.right);
            return right + 1;
        }

        return -1;
    }

    public void kLevelDown(TreeNode node, int k, List<Integer> ans, TreeNode block){

        if(node == null || node == block || k < 0)
            return;

        if(k == 0){
            ans.add(node.val);
            return;
        }

        kLevelDown(node.left, k-1, ans, block);
        kLevelDown(node.right, k-1, ans, block);
    }
}