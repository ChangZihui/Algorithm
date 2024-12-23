package No_1_200.No13罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，
     * 累加每个字符对应的数值即可。
     * 例如 XXVII 可视作 X+X+V+I+I=10+10+5+1+1=27。
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。
     * 对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
     * 例如 XIV 可视作 X−I+V=10−1+5=14。
     */
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
