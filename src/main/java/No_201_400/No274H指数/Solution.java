package No_201_400.No274H指数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] citations = {100};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > res && n - i>=res) res++;
        }
        return res;
    }
}
