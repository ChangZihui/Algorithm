package No_1_200.No59螺旋矩阵II;

import java.util.Arrays;

public class MySolution {
    public static void main(String[] args) {
        int n = 9;
        int[][] ints = generateMatrix(n);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }


    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        int minrow = 0, maxrow = n - 1, mincol = 0, maxcol = n - 1;
        while (cur <= n * n) {
            for (int k = mincol; k <= maxcol; k++) {
                res[minrow][k] = cur++;
            }
            minrow++;

            for (int k = minrow; k <= maxrow; k++) {
                res[k][maxcol] = cur++;
            }
            maxcol--;

            for (int k = maxcol; k >= mincol; k--) {
                res[maxrow][k] = cur++;
            }
            maxrow--;

            for (int k = maxrow; k >= minrow; k--) {
                res[k][mincol] = cur++;
            }
            mincol++;
        }

        return res;
    }
}
