package Q0299.Q0216CombinationSumIII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
   backtracking 回溯
 */
public class Solution {

    @Test
    public void test1() {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    @Test
    public void test2() {
        int k = 3, n = 9;
        System.out.println(combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, ArrayList<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> list = new ArrayList<>(comb);
            ans.add(list);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}
