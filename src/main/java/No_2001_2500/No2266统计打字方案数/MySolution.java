package No_2001_2500.No2266统计打字方案数;


import java.util.HashMap;
import java.util.Map;

public class MySolution {
    private static Map<Integer, Long> map3 = new HashMap<>();
    private static Map<Integer, Long> map4 = new HashMap<>();

    /**
     * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
     * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
     * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
     * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
     * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
     * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
     * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
     */
    public static void main(String[] args) {
        String pressedKeys = "88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555";
        System.out.println(countTexts(pressedKeys));
    }

    /**
     * 尝试使用map减少重复计算,但是扔超时
     */
    public static int countTexts(String pressedKeys) {
        long result = 1;
        for (int i = 0; i < pressedKeys.length(); ) {
            char startChar = pressedKeys.charAt(i);
            int charCount = 0;
            while (i < pressedKeys.length() && pressedKeys.charAt(i) == startChar) {
                charCount++;
                i++;
            }
            result = (result * count(startChar, charCount) % 1000000007);

        }

        return (int) (result % 1000000007);
    }

    private static long count(char ch, int count) {
        if (count == 0 || count == 1) {
            return 1;
        }
        Map<Integer, Long> map;
        map = ch == '7' || ch == '9' ? map4 : map3;
        if (map.containsKey(count)) {
            return map.get(count);
        }
        int type = ch == '7' || ch == '9' ? 4 : 3;
        int max = Math.min(count, type);
        long a = max >= 1 ? count(ch, count - 1) : 0;
        long b = max >= 2 ? count(ch, count - 2) : 0;
        long c = max >= 3 ? count(ch, count - 3) : 0;
        long d = max == 4 ? count(ch, count - 4) : 0;
        long res = (a + b + c + d);
        if (res > Integer.MAX_VALUE) {
            res = res % 1000000007;
        }
        map.put(count, res);
        return res;
    }
}
