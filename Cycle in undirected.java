class Solution {
    
    static boolean dfs(int v,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int parent){
        visited[v]=true;
        
        for(int neighbour:adj.get(v)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,v)){
                    return true;
                }
            }
            else if(neighbour!=parent){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // Code here
        boolean[] visited=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        
        return false;
    }
}