package aliTest;

import java.util.Scanner;

public class Solution {

    static int sm;
    static int sn;
    static int sm;
    static int sn;
    static int up(int[][] ints,int i,int j){
        int ans=0;
        for(int x=i;x>=0;x--){
            if(ints[x][j]==1) {ans=1;
                break;}

        }
        return ans;
    }
    static int dowm(int[][] ints,int i,int j){
        int ans=0;
        for(int x=i;x<sm;x++){
            if(ints[x][j]==1) {ans=1;
                break;}
        }
        return ans;
    }
    static int left(int[][] ints,int i,int j){
        int ans=0;
        for(int x=j;x>=0;x--){
            if(ints[i][x]==1){ ans=1;
                break;}
        }
        return ans;
    }
    static int right(int[][] ints,int i,int j){
        int ans=0;
        for(int x=j;x<sn;x++){
            if(ints[i][x]==1) {ans=1;
                break;}
        }
        return ans;
    }




    public static void main(String[] args) {
        int ans=0;
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        int m=Integer.valueOf(s1[0]);
        sm=m;
        int n=Integer.valueOf(s1[1]);
        sn=n;
        int[][] ints = new int[m][n];
        for(int i=0;i<m;i++){
           String[] s2= scanner.nextLine().split(" ");
           for(int j=0;j<n;j++){
               ints[i][j]=Integer.valueOf(s2[j]);
           }
        }
       int[][][]dp= new int[m][n][4];

        for(int j=0;j<n;j++){
            dp[0][j][0]=0;
            dp[0][j][1]=dowm(ints,0,j);
            dp[0][j][2]=left(ints,0,j);
            dp[0][j][3]=left(ints,0,j);
        }
        for(int i=1;i<m;i++){
            dp[i][0][0]=up(ints,i,0);
            dp[i][0][1]=dowm(ints,i,0);
            dp[i][0][2]=0;
            dp[i][0][3]=right(ints,i,0);

        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(ints[i][j]==0){
                    dp[i][j][0]
                }
            }
        }




        System.out.println(ans);


    }
}
