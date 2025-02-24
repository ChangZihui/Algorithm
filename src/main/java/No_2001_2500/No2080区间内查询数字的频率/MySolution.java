package No_2001_2500.No2080区间内查询数字的频率;

public class MySolution {
    /**
     * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
     * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
     * 请你实现 RangeFreqQuery 类：
     * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
     * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
     * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
     */
    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 33, 33, 22, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        System.out.println(rangeFreqQuery.query(0, 8, 33));
    }

}
