package No_1_200.No151反转字符串中的单词;

public class Solution {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length-1; i >=0 ; i--) {
            if (!"".equals(split[i])) {
                stringBuilder.append(split[i]).append(" ");
            }
        }
        String string = stringBuilder.toString();
        return string.trim();

    }
}
