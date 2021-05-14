package Q0399.Q316RemoveDuplicateLetters;

import java.util.ArrayDeque;
import java.util.Deque;

/*
   暴力解法: 枚举所有不包含重复字符且保持字母相对顺序的字符序列
-----------------------------------------------------------------
   分析:
   对于 example 1: s = "bcabc"， 遍历变量为 ch
   1. ch = 'b': 第一次出现，所以保留到结果中 -> "b"
   2. ch = 'c': 第一次出现，保留 -> "bc"
   3. ch = 'a': 第一次出现，保留 -> "bca"; 考虑到 'a' 还会出现 'c',丢弃；同理，丢弃'b'； -> 'a' (后进先出，用栈)
   4. ch = 'b': 保留 -> 'ab'
   5. ch = 'c': 保留 -> 'abc'

   对于 example 2: s = "cbacdcbc"
   1. ch = 'c': 入栈 -> "c"
   2. ch = 'b': 'c' 出栈(后面还有'c'), 'b' 入栈 -> "b"
   3. ch = 'a': 'b' 出栈, 'a'入栈 -> "a"
   4. ch = 'c': 'c'入栈 -> "ac"
   5. ch = 'd': 'd' 入栈 -> "acd"
   6. ch = 'c': 已在栈中，丢弃
   7. ch = 'b': 后面再无'b'(不能构成 "bd" 字典序最小的序列，故'd'不能舍弃), 'b' 入栈 -> "acdb"
   8. ch = 'c': 丢弃

    Summary:
       如果当前看到的字母已经在栈中，它一定不是某一段单调递增字母的最后一个字母；故，若遍历到栈中已存在的字符可以舍弃
       需要使用栈作为辅助的数据结构；
       需要记录每一个字符最后一次出现的下标；


  */
class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();  // 不用charAt，因为它还要检查下标是否越界
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        /*
        Stack 文档中说，用 Deque(双端队列) 代替 Stack
       A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class. For example:

        Deque<Integer> stack = new ArrayDeque<Integer>();
      */
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) { // 当前遍历元素已在栈中出现过
                continue; // 跳过
            }
            //                            字典序                               后续还会出现
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast(); // 取出栈顶元素
                visited[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }
        StringBuilder StringBuilder = new StringBuilder();
        for (char c : stack) {
            StringBuilder.append(c);
        }
        return StringBuilder.toString();
    }
}

/*
   学习建议:
    1. 通过特殊用例分析出处理问题符合"先进后出"的顺序
    2. 画图模拟元素出栈入栈的顺序，帮助理清思路和细节，写出正确的代码

    什么是数据结构:
      - 数据结构是缓存；
      - 不同的数据结构在合适的场合帮助我们高效地完成特定的任务

    练习:
      20. 有效的括号
      71
      150
      32
      739
      84
      42
      496
      901
      581
      402
      321
      1673
  */