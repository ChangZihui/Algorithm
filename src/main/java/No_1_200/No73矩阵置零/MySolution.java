package No_1_200.No73矩阵置零;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MySolution {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     */
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer column : columns) {
            for (int i = 0; i < m; i++) {
                matrix[i][column] = 0;
            }
        }
    }
}
