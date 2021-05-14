package Q0099.Q0071SimplifyPath;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    分析
    对于 path 的预处理: 两端去空白 + '/' 分割 -> 得到 String[] dirs
    遍历 dirs，工作变量为dir
    case 1. dir = "." -> do nothing
    case 2. dir = ".." 显然，需要把之前遍历到的dir缓存，需要返回上一级，符合后进先出(栈) -> 弹栈
    case 3. dir = "" 由"//"切割而来 -> do nothing
    case 4. dir = "xxxx" -> 入栈

 */
public class Solution {
    public String simplifyPath(String path) {
        // corner case
        if (path == null || path.length() == 0) return "";
        String[] dirs = path.trim().split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String dir : dirs) {
            if (!stack.isEmpty() && "..".equals(dir)) {
                stack.removeLast();
            } else if (!".".equals(dir) && !"..".equals(dir) && !"".equals(dir)) {
                stack.addLast(dir);
            }
        }
        // 组装
        return "/" + String.join("/", stack);
    }
}
