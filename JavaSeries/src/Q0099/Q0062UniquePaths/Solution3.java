package Q0099.Q0062UniquePaths;

public class Solution3 {

    /*
        Further inspecting the above code, pre[j] is just the cur[j] before the update. So we can further reduce the
         memory usage to one row.
     */
    public int uniquePaths(int rows, int cols) {
        int[] cur = new int[cols];

        for (int i = 0; i < cols; i++) cur[i] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) cur[j] = cur[j - 1] + cur[j];

        return cur[cols - 1];
    }
}
