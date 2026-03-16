/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Stack<TreeNode> path=new Stack<>();
        Stack<Integer> pathsum=new Stack<>();
        path.add(root);
        pathsum.add(root.val);
        while(!path.isEmpty()){
            TreeNode temp=path.pop();
            int tempval=pathsum.pop();

            if(temp.left==null && temp.right==null && tempval==targetSum){
                return true;
            }

            if(temp.right!=null){
                path.add(temp.right);
                pathsum.add(temp.right.val + tempval);
            }
            
            if(temp.left!=null){
                path.add(temp.left);
                pathsum.add(temp.left.val + tempval);
            }
        }

        return false;
    }
}