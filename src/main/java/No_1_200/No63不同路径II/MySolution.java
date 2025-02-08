package No_1_200.No63不同路径II;

public class MySolution {
    /**
     * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。
     * 机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
     * 返回机器人能够到达右下角的不同路径数量。
     * 测试用例保证答案小于等于 2 * 109。
     */
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (j > 0 && obstacleGrid[i][j - 1] == 0 ? dp[i][j - 1] : 0) +
                        (i > 0 && obstacleGrid[i - 1][j] == 0 ? dp[i - 1][j] : 0);
            }
        }

        return dp[m - 1][n - 1];
    }
}
