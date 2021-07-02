package Q0199.Q0150EvaluateReversePolishNotation;

/*
   用数组代替栈
 */
class Solution2 {

    boolean isOp(String str) {
        if (str.length() != 1) return false;
        char ch = str.charAt(0);
        return ch == '+' || ch == '*' || ch == '-' || ch == '/';
    }

    int calc(String op, int v2, int v1) {
        switch(op.charAt(0)) {
            case '+' : return v1 + v2;
            case '-' : return v1 - v2;
            case '*' : return v1 * v2;
            case '/' : return v1 / v2;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {
        int[] s = new int[tokens.length];
        int i = 0;
        for (String token : tokens) {
            if (isOp(token)) {
                int v2 = s[--i];
                int v1 = s[--i];
                s[i++] = calc(token, v2, v1);
            } else {
                s[i++] = Integer.parseInt(token);
            }
        }
        return s[0];
    }
}