package Q0199.Q0118PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

// r[i][j] = r[i - 1][j - 1] + r[i - 1][j];
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            result.add(new ArrayList<>(row));
        }
        return result;
    }
}
