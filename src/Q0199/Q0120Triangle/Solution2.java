package Q0199.Q0120Triangle;

import java.util.List;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {

        recursive(triangle, triangle.size() - 1);
        return triangle.get(0).get(0);
    }

    public void recursive(List<List<Integer>> triangle, int index) {
        if (index == 0) {
            return;
        }

        List<Integer> list = triangle.get(index);
        List<Integer> lastList = triangle.get(index - 1);
        for (int i = 0; i < lastList.size(); i++) {
            int sum = lastList.get(i) + Math.min(list.get(i), list.get(i + 1));
            lastList.set(i, sum);
        }

        recursive(triangle, index - 1);
    }
}
