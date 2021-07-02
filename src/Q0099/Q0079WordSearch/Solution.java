package Q0099.Q0079WordSearch;

public class Solution {

    /*
       Here accepted solution based on recursion. To save memory I decuded to apply bit mask for every visited cell. Please check board[y][x] ^= 256;
     */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {  // y represent row number
            for (int x = 0; x < board[y].length; x++) {  // x represent col number
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;  // 已检查过
        boolean exist = exist(board, y, x + 1, word, i + 1) // 右
                || exist(board, y, x - 1, word, i + 1) // 左
                || exist(board, y + 1, x, word, i + 1)  // 上
                || exist(board, y - 1, x, word, i + 1); // 下
        board[y][x] ^= 256;  // 恢复
        return exist;

    }
}
