package Q0099.Q0006ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 1. 使用含min(numRows, len(s)) 个字符串的list表示非空行
     * 2. 遍历给定字符串，将遍历字符放入合适的行
     * 3. 使用标志位goingDow表示是否向下，仅在第1行和末尾行需要改变行进方向
     * 4. 遍历结束，把所有行拼接在一起即可
     * 来自官方题解
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == (numRows - 1)) goingDown = !goingDown;  // 改变行进方向
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
