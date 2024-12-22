package No_1001_2000.No1387将整数按权重排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MySolution {

    /**
     * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
     * 如果 x 是偶数，那么 x = x / 2
     * 如果 x 是奇数，那么 x = 3 * x + 1
     * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
     * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，
     * 如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
     * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
     * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
     * 1 <= lo <= hi <= 1000
     * 1 <= k <= hi - lo + 1
     * TODO 计算一个数权重的过程中产生的数据,可以用于计算其他数的权重,使用记忆化可以节省这一部分的时间
     */
    public static void main(String[] args) {
//        int lo = 12, hi = 15, k = 2;
        int lo = 7, hi = 11, k = 4;
        System.out.println(getKth(lo, hi, k));

    }

    public static int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hi - lo + 1; i++) {
            list.add(lo + i);
        }
        list.sort(Comparator.comparingInt(MySolution::weight));
        return list.get(k - 1);
    }

    public static int weight(int num) {
        int i = 0;
        while (num != 1) {
            i++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
        }
        return i;
    }


}
