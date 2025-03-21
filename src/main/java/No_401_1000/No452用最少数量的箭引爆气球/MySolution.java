package No_401_1000.No452用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

public class MySolution {

    /**
     * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
     * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
     * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
     * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
     * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
     * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
     */
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    public static int findMinArrowShots(int[][] points) {
        int count = points.length;
        Arrays.sort(points, Comparator.comparingInt(ints -> ints[0]));
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1][1] < points[i][0]) {
                continue;
            }
            points[i][0] = Math.max(points[i - 1][0], points[i][0]);
            points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            count--;
        }
        return count;
    }
}
