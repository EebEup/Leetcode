package OFFER;

public class Offer12 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] booleans = new boolean[m][n];
        int x=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(x)){
                    booleans[i][j]=true;
                    if(match(board,word.substring(x+1,word.length()-1),booleans,i,j)){
                        return true;
                    }
                    booleans[i][j]=false;
                }
            }
        }
        return false;
    }

    boolean match(char[][] board,String word,boolean[][] booleans,int i,int j){
        if(word.length()==0) return true;
        if(i>0&&board[i-1][j]==word.charAt(0)&&booleans[i-1][j]==false){
            booleans[i-1][j]=true;
            if(match(board,word.substring(1,word.length()-1),booleans,i-1,j)){
                return true;
            }
            booleans[i-1][j]=false;

        }
        if(j>0&&board[i][j-1]==word.charAt(0)&&booleans[i][j-1]==false){
            booleans[i][j-1]=true;
            if(match(board,word.substring(1,word.length()-1),booleans,i,j-1)){
                return true;
            }
            booleans[i][j-1]=false;

        }
        if(j>board[0].length-2&&board[i][j+1]==word.charAt(0)&&booleans[i][j+1]==false){
            booleans[i][j+1]=true;
            if(match(board,word.substring(1,word.length()-1),booleans,i,j+1)){
                return true;
            }
            booleans[i][j+1]=false;

        }
        if(i<board.length-2&&board[i+1][j]==word.charAt(0)&&booleans[i+1][j]==false){
            booleans[i+1][j]=true;
            if(match(board,word.substring(1,word.length()-1),booleans,i+1,j)){
                return true;
            }
            booleans[i+1][j]=false;

        }


        return false;



    }

}
//  回溯
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}

