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
    int cameras=0;
    public int minCameraCover(TreeNode root) {
        int ans=helper(root);
        if(ans==-1) cameras++;
        return cameras;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;

        int lans=helper(root.left);
        int rans=helper(root.right);        
        
        //no cameras 
        if(lans==-1 || rans==-1){
            cameras++;
            return 1;
        }

        //no need for camera
        if(lans==1 || rans==1){
            return 0;
        }

        return -1;
    }
}