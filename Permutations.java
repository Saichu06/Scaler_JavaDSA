class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        List<Integer> temp=new ArrayList<>();
        permutation(nums,0,visited,list,temp);
        return list;
    }

    public void permutation(int[] nums,int pos,boolean[] 
    visited , List<List<Integer>> ans, List<Integer> temp){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==false){
                temp.add(nums[i]);
                visited[i]=true;
                permutation(nums,pos+1,visited,ans,temp);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}