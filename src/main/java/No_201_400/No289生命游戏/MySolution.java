package No_201_400.No289生命游戏;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    public static void main(String[] args) {
//        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] board = {{1,1},{1,0}};
        gameOfLife(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void gameOfLife(int[][] board) {
        List<int[]> toUpdate = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = inside(i - 1, j - 1, m, n) ? board[i - 1][j - 1] : 0;
                int b = inside(i - 1, j, m, n) ? board[i - 1][j] : 0;
                int c = inside(i - 1, j + 1, m, n) ? board[i - 1][j + 1] : 0;
                int d = inside(i, j - 1, m, n) ? board[i][j - 1] : 0;
                int e = inside(i, j + 1, m, n) ? board[i][j + 1] : 0;
                int f = inside(i + 1, j - 1, m, n) ? board[i + 1][j - 1] : 0;
                int g = inside(i + 1, j, m, n) ? board[i + 1][j] : 0;
                int h = inside(i + 1, j + 1, m, n) ? board[i + 1][j + 1] : 0;
                int live = a + b + c + d + e + f + g + h;
                if (board[i][j] == 0) {
                    if (live == 3) {
                        toUpdate.add(new int[]{i, j});
                    }
                } else {
                    if (live < 2 || live > 3) {
                        toUpdate.add(new int[]{i, j});
                    }
                }
            }
        }
        for (int[] index : toUpdate) {
            if (board[index[0]][index[1]] == 0) {
                board[index[0]][index[1]] = 1;
            } else {
                board[index[0]][index[1]] = 0;
            }
        }
    }

    public static boolean inside(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 & j < n;
    }
}
