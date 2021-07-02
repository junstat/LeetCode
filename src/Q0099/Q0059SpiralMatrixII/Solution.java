package Q0099.Q0059SpiralMatrixII;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;

        int num = 1, rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // 向 右
            for (int i = colBegin; i <= colEnd; i++) matrix[rowBegin][i] = num++;
            rowBegin++;

            // 向 下
            for (int i = rowBegin; i <= rowEnd; i++) matrix[i][colEnd] = num++;
            colEnd--;

            // 向 左
            for (int i = colEnd; i >= colBegin; i--) matrix[rowEnd][i] = num++;
            rowEnd--;

            // 向上
            for (int i = rowEnd; i >= rowBegin; i--) matrix[i][colBegin] = num++;
            colBegin++;
        }
        return matrix;
    }
}