package No_1_200.No010正则表达式匹配;

public class Solution {
    public static void main(String[] args) {
        String s = "ab", p = "a.";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }

    public static boolean isMatch(String s, String p, int i, int j) {
        if (j < 0) {
            return true;
        }
        if (p.charAt(j) == '.') {
            return isMatch(s, p, --i, --j);
        }
        if (p.charAt(j) == '*') {
            char c = p.charAt(j - 1);
            if ('.' != c) {
                while (s.charAt(j) == ' ') ;
            }
        }
        return true;
    }
}
