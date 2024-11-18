package No_2001_2500.No2304网格中的最小路径代价;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{5, 3}, {4, 0}, {2, 1}}, moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(minPathCost(grid, moveCost));
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] ints = new int[grid.length][grid[0].length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (i == 0) ints[i][j] = grid[i][j];
                else ints[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                //ints[i][j]=min{int[i-1][k]+moveCost[grid[i-1][k]][j] | k∈[0,j]}
                for (int k = 0; k < ints[0].length; k++) {
//                    ints[i][j]=Math.min(ints[i][j],ints[i-1][k]+moveCost[grid[i-1][k]][j]);
                    ints[i][j] = Math.min(ints[i][j], ints[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ints[0].length; i++) {
            min = Math.min(min, ints[ints.length - 1][i]);
        }
        return min;
    }
}
