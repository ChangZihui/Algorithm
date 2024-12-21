package No_2501_3000.No2545根据第K场考试的分数排序;

import java.util.Arrays;

public class MySolution {

    /**
     * 班里有 m 位学生，共计划组织 n 场考试。给你一个下标从 0 开始、大小为 m x n 的整数矩阵 score ，
     * 其中每一行对应一位学生，而 score[i][j] 表示第 i 位学生在第 j 场考试取得的分数。矩阵 score 包含的整数 互不相同 。
     * 另给你一个整数 k 。请你按第 k 场考试分数从高到低完成对这些学生（矩阵中的行）的排序。
     * 返回排序后的矩阵。
     * TODO 同官解
     */
    public static void main(String[] args) {
//        int[][] score = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
        int[][] score = {{3,4},{5,6}};
        int k = 0;
        int[][] ints = sortTheStudents(score, k);
        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }
}
