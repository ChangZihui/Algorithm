package No_2001_2500.No2171拿出最少数目的魔法豆;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] beans = {25,27,1,10,8,35,17,5,4,16};
        System.out.println(minimumRemoval(beans));

    }

    public static long minimumRemoval(int[] beans) {
            int n = beans.length;
            Arrays.sort(beans);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += beans[i];
            }
            int height = 0;
            for (int i = n - 1; i >= 0; i--) {
                int gap = Math.abs(beans[i] - height) * (n - 1 - i) - beans[i];
                if (gap < 0) {
                    sum += gap;
                    height = beans[i];
                } else {
                    break;
                }
            }
            return sum;
    }
}
