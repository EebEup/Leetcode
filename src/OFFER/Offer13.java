package OFFER;

public class Offer13 {

    int count;

    public int movingCount(int m, int n, int k) {
        boolean[][] booleans = new boolean[m][n];
        dfs(m,n,0,0,k,booleans);
        return count;
    }
    void dfs(int m,int n,int i,int j,int k,boolean[][] booleans){

        if(i<0||j<0||i>m-1||j>n-1||i/10+i%10+j/10+j%10>k||booleans[i][j]==true) return ;
        count++;
        booleans[i][j]=true;
        dfs(m,n,i+1,j,k,booleans);
        dfs(m,n,i,j+1,k,booleans);


    }


}
