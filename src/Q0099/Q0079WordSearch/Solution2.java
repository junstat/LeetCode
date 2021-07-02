package Q0099.Q0079WordSearch;

/*
   执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
   内存消耗：36.3 MB, 在所有 Java 提交中击败了87.13%的用户
 */
public class Solution2 {

    private char[] ch;
    private int n;
    private boolean[][] visit;
    private int m1;
    private int m2;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        int m1 = board.length;
        int m2 = board[0].length;
        if (n > m1 * m2) {
            return false;
        }

        int[] f1 = new int[133];
        int[] f2 = new int[133];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < m2; j++) {
                ++f1[board[i][j]];
            }
        }

        for (int i = 0; i < n; i++) {
            ++f2[ch[i]];
        }

        for (int i = 0; i < 133; i++) {
            if (f1[i] < f2[i]) {
                return false;
            }
        }

        visit = new boolean[m1][m2];
        this.n = n;
        this.ch = ch;
        this.m1 = m1;
        this.m2 = m2;
        this.board = board;

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < m2; j++) {
                if (board[i][j] == ch[0] && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        char[][] board = this.board;
        boolean[][] visit = this.visit;
        visit[i][j] = true;
        if (board[i][j] == ch[index]) {
            if (index == n - 1) {
                return true;
            }
            if (
                    (i - 1 >= 0 && !visit[i - 1][j] && dfs(i - 1, j, index + 1))
                            ||
                            (i + 1 < m1 && !visit[i + 1][j] && dfs(i + 1, j, index + 1))
                            ||
                            (j - 1 >= 0 && !visit[i][j - 1] && dfs(i, j - 1, index + 1))
                            ||
                            (j + 1 < m2 && !visit[i][j + 1] && dfs(i, j + 1, index + 1))
            ) {
                return true;
            }
        }
        return visit[i][j] = false;
    }
}
