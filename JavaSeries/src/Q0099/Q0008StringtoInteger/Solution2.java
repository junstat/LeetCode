package Q0099.Q0008StringtoInteger;

public class Solution2 {
    public int myAtoi(String str) {
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
