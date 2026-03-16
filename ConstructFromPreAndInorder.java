class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length-1,
                             inorder, 0, inorder.length-1);
    }
    public TreeNode constructTree(int[] pre,int si1,int ei1,int[] in,int si2, int ei2){
        if(si1>ei1) return null;
        if(si1==ei1) return new TreeNode(pre[si1]);

        TreeNode root=new TreeNode(pre[si1]);
        int idx=-1;
        for(int i=si2;i<=ei2;i++){
            if(in[i]==root.val){
                idx=i;
                break;
            }
        }

        root.left=constructTree(pre, si1+1 , si1+(idx-si2) , in , si2 , idx-1 );
        root.right=constructTree(pre,si1 + (idx-si2) +1 , ei1 , in , idx+1 , ei2);

        return root;
    }
}