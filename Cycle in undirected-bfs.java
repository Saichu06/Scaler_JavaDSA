class Solution {
    
    static boolean bfs(int v,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{v,-1});
        visited[v]=true;
        
        while(!q.isEmpty()){
            int node=q.peek()[0];
            int parent=q.peek()[1];
            
            q.poll();
            
            for(int neigh:adj.get(node)){
                
                if(!visited[neigh]){
                    visited[neigh]=true;
                    q.add(new int[]{neigh,node});
                }
                else if(neigh!=parent){
                    return true;
                }
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
                if(bfs(i,adj,visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
}