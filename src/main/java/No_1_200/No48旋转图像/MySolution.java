package No_1_200.No48旋转图像;

import java.util.Arrays;

public class MySolution {

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * TODO 同官解
     */
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 从外圈开始一层一层旋转
     * 每次以四个为一组进行交换
     * 时间复杂度n2
     * 空间复杂度1
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1-i; j++) {
                int temp=matrix[i][j];
                //交换
                matrix[i][j]=matrix[n - 1 - j][i];
                matrix[n - 1 - j][i]=matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j]=matrix[j][n - 1 - i];
                matrix[j][n - 1 - i]=temp;
            }
        }
    }

}

