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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Stack<TreeNode> curr=new Stack<>();
        Stack<TreeNode> next=new Stack<>();
        List<List<Integer>> ans=new ArrayList<>();
        int level=0;
        curr.push(root);
        while(!curr.isEmpty()){
            List<Integer> list=new ArrayList<>();
            while(!curr.isEmpty()){
                TreeNode node=curr.pop();
                list.add(node.val);
                if(level%2==0){
                    if(node.left!=null) next.add(node.left);
                    if(node.right!=null) next.add(node.right);
                }
                else{
                    if(node.right!=null) next.add(node.right);
                    if(node.left!=null) next.add(node.left);
                }
            }
            level++;
                ans.add(list);
                curr=next;
                next=new Stack<>();
        }

        return ans;
    }
}