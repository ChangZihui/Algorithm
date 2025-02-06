package No_1_200.No57插入区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi]
     * 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。
     * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
     * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，
     * 且区间之间不重叠（如果有必要的话，可以合并区间）。
     * 返回插入之后的 intervals。
     * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] inserted = insert(intervals, newInterval);
        for (int[] ints : inserted) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        boolean flag = true;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                list.add(interval);
                continue;
            }
            if (interval[0] > newInterval[1]) {
                if (flag) {
                    list.add(newInterval);
                    flag = false;
                }
                list.add(interval);
                continue;
            }
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        if (flag){
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }
}
