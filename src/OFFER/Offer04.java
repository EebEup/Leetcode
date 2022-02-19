package OFFER;

public class Offer04 {

//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//     int mi,mj,ni,nj;
//     mi=0;
//     mj=matrix.length;
//     ni=0;
//     nj=matrix[0].length;
//     while(matrix[(mi+mj)/2][(ni+nj)/2]!=target){
//         if(mi==mj&&ni==nj) return false;
//         if(matrix[(mi+mj)/2][(ni+nj)/2]>target){
//             mj=(mi+mj)/2;
//             nj=(ni+nj)/2;
//         }
//         else{
//             mi=(mi+mj)/2;
//             nj=(ni+nj)/2;
//         }
//     }
//     return true;
//
//
//    }

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int row = 0, column = columns - 1;
            while (row < rows && column >= 0) {
                int num = matrix[row][column];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    column--;
                } else {
                    row++;
                }
            }
            return false;
        }
    }


}
