package No_1_200.No12整数转罗马数字;

public class MySolution {
    /**
     * 七个不同的符号代表罗马数字，其值如下：
     * 符号	值
     * I	1
     * V	5
     * X	10
     * L	50
     * C	100
     * D	500
     * M	1000
     * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
     * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，
     * 然后将其余部分转换为罗马数字。
     * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，
     * 例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。
     * 仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
     * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。
     * 你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
     * 给定一个整数，将其转换为罗马数字。
     * 1 <= num <= 3999
     * 例:
     * 输入：num = 3749
     * 输出： "MMMDCCXLIX"
     */
    public static void main(String[] args) {
        int num = 58;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int a = num / 1000;
        int b = (num - a * 1000) / 100;
        int c = (num - a * 1000 - b * 100) / 10;
        int d = num - a * 1000 - b * 100 - c * 10;
        // 千位处理,因为num小于4000,所以千位是多少,就补多少个M
        result.append("M".repeat(Math.max(0, a)));

        if (b > 0) {
            if (b == 9) {
                result.append("CM");
            } else if (b >= 5) {
                result.append("D");
                result.append("C".repeat(Math.max(0, b - 5)));
            } else if (b == 4) {
                result.append("CD");
            } else {
                result.append("C".repeat(b));
            }
        }
        if (c > 0) {
            if (c == 9) {
                result.append("XC");
            } else if (c >= 5) {
                result.append("L");
                result.append("X".repeat(Math.max(0, c - 5)));
            } else if (c == 4) {
                result.append("XL");
            } else {
                result.append("X".repeat(c));
            }
        }
        if (d > 0) {
            if (d == 9) {
                result.append("IX");
            } else if (d >= 5) {
                result.append("V");
                result.append("I".repeat(Math.max(0, d - 5)));
            } else if (d == 4) {
                result.append("IV");
            } else {
                result.append("I".repeat(d));
            }
        }
        return result.toString();
    }
}
