package No_1_200.No14最长公共前缀;

public class MySolution {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        int length = 0;
        while (true) {
            for (String str : strs) {
                if (!(str.length() > length && strs[0].charAt(length) == str.charAt(length))) {
                    return strs[0].substring(0, length);
                }
            }
            length++;
        }
    }
}
