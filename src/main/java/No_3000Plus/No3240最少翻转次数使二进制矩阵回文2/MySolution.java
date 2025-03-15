package No_3000Plus.No3240最少翻转次数使二进制矩阵回文2;

public class MySolution {
    public static void main(String[] args) {
        int[][] grid = {{1, 1}};
        System.out.println(minFlips(grid));
    }


    public static int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int a = grid[i][j];
                int b = grid[m - i - 1][j];
                int c = grid[i][n - j - 1];
                int d = grid[m - i - 1][n - j - 1];
                int sum = a + b + c + d;
                if (sum == 1 || sum == 3) {
                    count++;
                } else if (sum == 2) {
                    count += 2;
                }
            }
        }
        boolean flag = false;
        int size = 0;
        if (m % 2 != 0) {
            for (int i = 0; i < n / 2; i++) {
                int sum = grid[m / 2][i] + grid[m / 2][n - i - 1];
                if (sum == 2) {
                    size += 2;
                } else if (sum == 1) {
                    count++;
                    flag = true;
                }
            }
        }
        if (n % 2 != 0) {
            for (int i = 0; i < m / 2; i++) {
                int sum = grid[i][n / 2] + grid[m - i - 1][n / 2];
                if (sum == 2) {
                    size += 2;
                } else if (sum == 1) {
                    count++;
                    flag = true;
                }
            }
        }
        if (m % 2 != 0 && n % 2 != 0 && grid[m / 2][n / 2] == 1) {
            count++;
        }
        if (size % 4 != 0) {
            if (!flag) {
                count += 2;
            }
        }
        return count;
    }
}
