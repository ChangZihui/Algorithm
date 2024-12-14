package No_1_200.No54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class MySolution {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * TODO
     * 时间复杂度和空间复杂度同官解
     * 可以优化的点是四种遍历方式的前后顺序是固定的,可以将四种遍历当做一个整体进行循环
     */
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // 记录边界
        int minLine = 0, maxLine = matrix.length - 1, minColumn = 0, maxColumn = matrix[0].length - 1;
        // 遍历方向,true=横向,false=纵向
        boolean flag = true;
        // 遍历方向,true=下标增加,false=下标减少
        boolean forward = true;
        while (minLine <= maxLine && minColumn <= maxColumn) {
            if (flag && forward) {
                for (int i = minColumn; i <= maxColumn; i++) {
                    result.add(matrix[minLine][i]);
                }
                minLine++;
                flag = false;
            } else if (flag && !forward) {
                for (int i = maxColumn; i >= minColumn; i--) {
                    result.add(matrix[maxLine][i]);
                }
                maxLine--;
                flag = false;
            } else if (!flag & forward) {
                for (int i = minLine; i <= maxLine; i++) {
                    result.add(matrix[i][maxColumn]);
                }
                maxColumn--;
                flag = true;
                forward = false;
            } else if (!flag && !forward) {
                for (int i = maxLine; i >=minLine; i--) {
                    result.add(matrix[i][minColumn]);
                }
                minColumn++;
                flag = true;
                forward = true;
            }
        }
        return result;
    }
}
