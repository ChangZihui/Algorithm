package No_3000Plus.No3240最少翻转次数使二进制矩阵回文II;

public class MySolution {

    /**
     * 3240. 最少翻转次数使二进制矩阵回文 II
     * <p>
     * 给你一个 m x n 的二进制矩阵 grid 。
     * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
     * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
     * 请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。
     */
    public static void main(String[] args) {
        int[][] grid = {{1,1}};
        System.out.println(minFlips(grid));
    }


    public static int minFlips(int[][] grid) {
        // 矩阵要达到回文效果,则对称的四个位置必然相等,要么全是0,要么全是1
        // 矩阵对称的四个位置是0或1都不影响条件:1的数目被4整除,所以只需要翻转次数最少即可
        // 如果行或列为奇数个,那么会有一条中轴,在这条中轴上,对称的不是4个位置而是2个位置
        // 对中轴线上的数进行翻转,会影响最后1的个数
        // 但是不会影响翻转的次数,因为只要不对称,就只会翻转1次
        // 所以需要看翻转后1的个数距离模4是不是2,
        // 如果是,就要看是否有过翻转操作,如果翻转过,那么将翻转操作要么是1变0,要么是0变1,只需要将这次翻转操作进行翻转就能达成模4=0
        // 如果行列均为奇数,则中心点必须为0

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
            if (!flag){
                count += 2;
            }
        }
        return count;
    }
}
