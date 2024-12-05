package No_3000Plus.No3001捕获黑皇后需要的最少移动次数;

public class MySolution {

    /**
     * 现有一个下标从 1 开始的 8 x 8 棋盘，上面有 3 枚棋子。
     * 给你 6 个整数 a 、b 、c 、d 、e 和 f ，其中：
     * (a, b) 表示白色车的位置。
     * (c, d) 表示白色象的位置。
     * (e, f) 表示黑皇后的位置。
     * 假定你只能移动白色棋子，返回捕获黑皇后所需的最少移动次数。
     * 请注意：
     * 车可以向垂直或水平方向移动任意数量的格子，但不能跳过其他棋子。
     * 象可以沿对角线方向移动任意数量的格子，但不能跳过其他棋子。
     * 如果车或象能移向皇后所在的格子，则认为它们可以捕获皇后。
     * 皇后不能移动。
     * TODO 同官解，解题时在判断同斜线时，未考虑到斜率为负的情况
     */
    public static void main(String[] args) {
        int a = 4, b = 3, c = 3, d = 4, e = 5, f = 2;
        System.out.println(minMovesToCaptureTheQueen(a, b, c, d, e, f));
    }


    /**
     * 分类讨论
     * 1、如果车和皇后在同一条直线上，且象不再车和皇后中间，则返回1
     * 2、如果象和皇后在同一条斜线上，且车不再象和皇后中间，则返回1
     * 3、如果上述两个条件不成立，则返回2
     */
    public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && !(c == a && (b - d) * (d - f) > 0)) {
            return 1;
        }
        if (b == f && (!(d == b && (a - c) * (c - e) > 0))) {
            return 1;
        }
        if (Math.abs(c - e) == Math.abs(d - f)) {
            // 1或者-1
            int flag = (c - e) / (d - f);
            if (!(flag * (c - a) == (d - b) && (d-b) * (b - f) > 0)) {
                return 1;
            }
        }
        return 2;
    }
}
