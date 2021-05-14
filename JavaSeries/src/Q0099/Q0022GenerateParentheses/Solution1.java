package Q0099.Q0022GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, new StringBuffer(), res);
        return res;
    }

    public void helper(int n, int left, int right, StringBuffer cur, List<String> res) {
        if (left == n && right == n) {
            res.add(cur.toString());
            return;
        }
        if (left < n) {
            cur.append('(');
            helper(n, left + 1, right, cur, res);
            cur.setLength(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            helper(n, left, right + 1, cur, res);
            cur.setLength(cur.length() - 1);
        }
    }
}
