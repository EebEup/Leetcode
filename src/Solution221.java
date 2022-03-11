import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Scanner;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int r= scanner.nextInt();
       int l=scanner.nextInt();
        char[][] ints = new char[r][l];
        for (int i=0;i<r;i++){
            for (int j=0;j<l;j++){
                StringBuilder stringBuilder = new StringBuilder(scanner.nextInt());

                ints[i][j]= stringBuilder.charAt(0);
            }
        }
        Solution221 solution221 = new Solution221();
        System.out.println(solution221.maximalSquare(ints));
        scanner.close();

    }
}




