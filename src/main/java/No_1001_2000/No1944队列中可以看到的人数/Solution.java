package No_1001_2000.No1944队列中可以看到的人数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] heights = {11, 19, 12, 15, 14, 18, 7, 1, 8, 9};
        System.out.println(Arrays.toString(canSeePersonsCount(heights)));
    }

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] canSee = new int[n];
        canSee[n - 1] = 0;
        List<Integer> list = new ArrayList<>();
        list.add(heights[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int height = heights[i];
            int index = list.size() - 1;

            for (int j = list.size() - 1; j >= 0; j--) {
                if (list.get(j) > height) {
                    canSee[i] = list.size() - j;
                    index = j + 1;
                    break;
                }
                index = 0;
                canSee[i] = list.size();
            }
            list = list.subList(0, index);
            list.add(height);
        }
        return canSee;
    }
}
