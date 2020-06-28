/*
    自动机
    1. 输入字符所有可能情况分类: space(空格), +/-, number, other
    2. 根据当前状态(字符)，与下一个字符可以得出下一状态: 即 下一状态 = f(当前状态, 下一字符)
                            下一字符
                            space           +/-         number      other
        当前状态 start       start          signed       in_number   end
                signed      end             end         in_number   end
                in_number   end             end         in_number   end
                end         end             end         end         end
     来自官方题解
     System.out.println(Integer.MAX_VALUE);  // 2147483647
     System.out.println(Integer.MIN_VALUE);  // -2147483648   -2147483647
 */
public class StringtoInteger {
    /**
     * 不使用long，手动判断溢出
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
        int res = 0;
        boolean neg = str.charAt(0) == '-';
        int curNumberIndex = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (curNumberIndex < str.length() && Character.isDigit(str.charAt(curNumberIndex))) {
            // int型的边界扣除当前数，即当前res的边界
            int tmp = ( (neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(curNumberIndex) - '0') ) / 10;
            if (tmp > res) { // 因为tmp, res均为负，tmp > res <=> abs(tmp) < abs(res)，即当前res已越界
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 - (str.charAt(curNumberIndex++) - '0'); // res  恒为负    1 3 8 -> -12
        }
        return neg ? (int) res : (int) -res;
    }

    public int myAtoi2(String str) {
        str = str.trim();       // 两端去除空白，start状态 跳转到 end
        if (str.length() == 0) return 0;
        // 非number, signed, 即other 跳转到 end
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
        long res = 0L;
        boolean neg = str.charAt(0) == '-'; // 为负？
        int curNumberIndex = !Character.isDigit(str.charAt(0)) ? 1 : 0; // 当前数值的下标 初始: 0位为符号位则数值从1号位开始，否则0号位开始
        while (curNumberIndex < str.length() && Character.isDigit(str.charAt(curNumberIndex))) {
            res = res * 10 + (str.charAt(curNumberIndex++) - '0'); // res  恒正
            if (!neg && res > Integer.MAX_VALUE) {  // 上溢
                return Integer.MAX_VALUE;
            }
            if (neg && res > 1L + Integer.MAX_VALUE) {  // 下溢
                return Integer.MIN_VALUE;
            }
        }
        return neg ? (int) -res : (int) res;
    }
}
