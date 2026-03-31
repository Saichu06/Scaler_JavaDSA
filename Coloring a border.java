class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oc=grid[row][col];
        dfs(grid,row,col,oc);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0) grid[i][j]=color;
            }
        }
        return grid;
    }

    public void dfs(int[][] grid,int r,int c,int oc){
        //base case if the it fails
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=oc){
            return;
        }

        grid[r][c]=-oc;

        dfs(grid,r-1,c,oc);
        dfs(grid,r+1,c,oc);
        dfs(grid,r,c-1,oc);
        dfs(grid,r,c+1,oc);

        //check for middle elemnts which might have same value but not boundary
        if(r-1>=0 && c-1>=0 && c+1<grid[0].length && r+1<grid.length &&
        Math.abs(grid[r-1][c])==oc && Math.abs(grid[r+1][c])==oc && 
        Math.abs(grid[r][c-1])==oc && Math.abs(grid[r][c+1])==oc){
            grid[r][c]=oc;
        }
    }
}