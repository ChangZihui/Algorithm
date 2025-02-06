package No_1_200.No56合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MySolution {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        for (int[] ints : merged) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals).
                sorted(Comparator.comparingInt((int[] a) -> a[0])).toList();
        List<int[]> filter = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1)[1] < list.get(i)[0]) {
                filter.add(list.get(i - 1));
            } else if (list.get(i - 1)[1] <= list.get(i)[1]) {
                list.get(i)[0] = list.get(i - 1)[0];
            } else {
                list.get(i)[0] = list.get(i - 1)[0];
                list.get(i)[1] = list.get(i - 1)[1];
            }
        }
        filter.add(list.get(list.size() - 1));
        return filter.toArray(new int[filter.size()][]);
    }
}
