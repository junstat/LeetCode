package Q0099.Q0074SearchA2DMatrix;

public class Solution {
    /*
       Use binary search.
        n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
        an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, r = m * n - 1;
        while (l != r) {
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target) l = mid + 1;
            else r = mid;
        }
        return matrix[r / m][r % m] == target;
    }

    /*
       来自 《剑指offer》 第2版，面试题4
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0) {
                if (matrix[row][column] == target) {
                    found = true;
                    break;
                } else if (matrix[row][column] > target) --column;
                else ++row;
            }
        }
        return found;
    }
}
