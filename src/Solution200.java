public class Solution200 {

    public int numIslands(char[][] grid) {
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i==0&&j==0){
                        num++;
                    }
                    if(i==0){
                        if(grid[i][j-1]==0) num++;
                    }
                    if(j==0){
                        if(grid[i-1][j]==0) num++;
                    }
                    if(grid[i-1][j]==0&&grid[i][j-1]==0){
                        num++;
                    }
                }
            }
        }
        return num;

    }
}
