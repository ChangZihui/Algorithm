package No_1001_2000.No1605给定行和列的和求可行矩阵;

public class Solution {

    public static void main(String[] args) {
        int[] rowSum = {4,12,10,1,0}, colSum = {1,0,3,16,7};
        int[][] ints = restoreMatrix(rowSum, colSum);
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ints = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                ints[i][j] = 0;
            }
        }
        for (int i = 0; i < Math.min(rowSum.length, colSum.length); i++) {
            ints[i][i] = Math.min(rowSum[i], colSum[i]);
            if (rowSum[i] >= colSum[i]) {
                rowSum[i] -= colSum[i];
                colSum[i] = 0;
            } else {
                colSum[i] -= rowSum[i];
                rowSum[i] = 0;
            }
        }

        for (int i = 0; i < Math.min(rowSum.length, colSum.length); i++) {
            if (rowSum[i] == 0) {
                continue;
            }
            for (int j = 0; j < Math.min(rowSum.length, colSum.length); j++) {
                if (i==j) continue;
                if (colSum[j] != 0) {
                    if (rowSum[i] >= colSum[j]) {
                        ints[i][j] = colSum[j];
                        rowSum[i] -= colSum[j];
                        colSum[j] = 0;
                    } else {
                        ints[i][j] = rowSum[i];
                        colSum[j] -= rowSum[i];
                        rowSum[i] = 0;
                    }
                }
            }
        }

        if (rowSum.length > colSum.length) {
            for (int i = colSum.length; i < rowSum.length; i++) {
                for (int j = 0; j < colSum.length; j++) {
                    if (rowSum[i] > colSum[j]) {
                        ints[i][j] = colSum[j];
                        rowSum[i] -= colSum[j];
                        colSum[j] = 0;
                    } else {
                        ints[i][j] = rowSum[i];
                        colSum[j] -= rowSum[i];
                        rowSum[i] = 0;
                    }
                }
            }
        } else {
            for (int i = 0; i < rowSum.length; i++) {
                for (int j = rowSum.length; j < colSum.length; j++) {
                    if (rowSum[i] > colSum[j]) {
                        ints[i][j] = colSum[j];
                        rowSum[i] -= colSum[j];
                        colSum[j] = 0;
                    } else {
                        ints[i][j] = rowSum[i];
                        colSum[j] -= rowSum[i];
                        rowSum[i] = 0;
                    }
                }
            }
        }

        return ints;
    }
}
